package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
//    http://localhost:8081/permission/findAll.do
    @Autowired
    private IPermissionService iPermissionService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        List<Permission> permissionList = iPermissionService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;

    }

    @RequestMapping("sava.do")
    public String sava(Permission permission){
        iPermissionService.sava(permission);

        return "redirect:findAll.do";
    }
}
