package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IRoleService {
    public List<Role> findAll();

    public void sava(String roleName,String roleDesc);

    Role findById(String id);

    List<Permission> findOtherPermissions(Role role);

    void addPermissionToRole(String roleId, String[] ids);
}
