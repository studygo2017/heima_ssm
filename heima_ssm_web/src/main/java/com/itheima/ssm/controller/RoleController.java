package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = iRoleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

//    http://localhost:8081/role/save.do
    @RequestMapping("sava.do")
    public String sava(String roleName,String roleDesc){
        System.out.println("添加role前。。。");
        iRoleService.sava(roleName,roleDesc);
        System.out.println("添加role完。。。");
        return "redirect:findAll.do";
    }


//    http://localhost:8081/role/findRoleByIdAndAllPermission.do?id=3A074B49E8AD490D881287448B658D56
    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id){
        Role role = iRoleService.findById(id);
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = iRoleService.findOtherPermissions(role);

        mv.setViewName("role-permission-add");
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        return mv;
    }


//    http://localhost:8081/role/addPermissionToRole.do
//    添加指定ids数组的权限到指定的一个角色role中
    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(String roleId,String[] ids){
        iRoleService.addPermissionToRole(roleId,ids);

        return "redirect:findAll.do";
    }
}
