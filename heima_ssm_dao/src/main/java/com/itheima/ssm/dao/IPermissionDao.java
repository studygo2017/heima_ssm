package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermissionDao {
    //根据角色role的id来查权限，一对多关系，故返回值为List
    public List<Permission> findByRoleId(String id);

    //直接点击查询所有权限
    public List<Permission> findAll();

//    public void sava(Permission permission)
//      保存权限
    public void sava(Permission permission);
}
