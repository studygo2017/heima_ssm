package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    public List<UserInfo> findAll();

    void sava(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRoles(UserInfo userInfo);


    void addRoleToUser(String userId, String[] ids);
}
