package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() {
        List<Role> roles = iRoleDao.findAll();
        return roles;

    }

    @Override
    public void sava(String roleName, String roleDesc) {
        iRoleDao.sava(roleName,roleDesc);
    }


    @Override
    public Role findById(String id) {
        return iRoleDao.findById(id);

    }

    @Override
    public List<Permission> findOtherPermissions(Role role) {
        return iRoleDao.findOtherPermissions(role);

    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String id : ids) {
            iRoleDao.addOnePermission(roleId,id);
        }

    }
}
