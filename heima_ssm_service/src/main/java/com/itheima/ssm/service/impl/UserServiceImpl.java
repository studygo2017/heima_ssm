package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authoritys = getAuthority(roles);
        System.out.println("当前登录用户权限为:"+authoritys);
        //明文密码加"{noop}"
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true, true, authoritys);
        return user;
    }


    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            System.out.println("getAuthority......"+role.getRoleName());
        }
        return authoritys;
    }

    //查询所有用户方法
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> all = userDao.findAll();
        return all;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void sava(UserInfo userInfo) {
        userInfo.setUsername(userInfo.getUsername());
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.sava(userInfo);

    }

    @Override
    public UserInfo findById(String id) {
       return userDao.findById(id);

    }

    //查询该user不包含的所有角色
    @Override
    public List<Role> findOtherRoles(UserInfo userInfo) {
        List<Role> otherRoles = userDao.findOtherRoles(userInfo);

        return otherRoles;
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            userDao.addOneRoleToUser(userId,id);
        }

    }


}
