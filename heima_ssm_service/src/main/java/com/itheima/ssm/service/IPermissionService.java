package com.itheima.ssm.service;



import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();

//    public String sava(Permission permission)
    public void sava(Permission permission);
}
