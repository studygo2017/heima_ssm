package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    public UserInfo findByUsername(String username);

    public List<UserInfo> findAll();

    void sava(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRoles(UserInfo userInfo);

    void addOneRoleToUser(@Param("userId") String userId,@Param("roleId") String id);
}
