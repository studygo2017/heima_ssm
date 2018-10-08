package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleDao {
    public List<Role> findRoleByUserId(String userId);

//    <collection property="roles" column="id" ofType="role" select="com.itheima.ssm.dao.IRoleDao.findRoleByUserId"></collection>

    public List<Role> findAll();

    public void sava(@Param("roleName")String roleName, @Param("roleDesc")String roleDesc);

    public Role findById(String id);

    List<Permission> findOtherPermissions(Role role);


    void addOnePermission(@Param("roleId") String roleId, @Param("permissionId") String id);
}
