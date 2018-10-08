package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
//    http://localhost:8081/user/findAll.do
    @Autowired
    private UserService userService;
    
    @RequestMapping("findAll.do")
    @RolesAllowed("ADMIN")//登陆账户必须包含ROLE_ADMIN角色才能使用该方法
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        for (UserInfo userInfo : userList) {
//            statusStr='null'正常
            System.out.println(userInfo);
        }
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("sava.do")
    public String sava(UserInfo userInfo){
        ModelAndView mv = new ModelAndView();
        userService.sava(userInfo);
        return "redirect:findAll.do";
    }

//    http://localhost:8081/user/findById.do?id=5BADB9A78A9C4DD3B584EDA51B63ADF0
    //查询单个用户详情的方法
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        System.out.println("user/findById.do...userInfo。。。"+userInfo);

//        user/findById.do...userInfo。。。
// UserInfo{id='5BADB9A78A9C4DD3B584EDA51B63ADF0', username='huang', email='18971390188@itcast.com', password='$2a$10$JI8d7la3QrnSwR2xGjJ9zudXpMouBpIx2yaO1dSB8LTLArjaOHlF6', phoneNum='18971390188', status=1, statusStr='null', roles=[]}

// user/findById.do...userInfo。。。
// UserInfo{id='5BADB9A78A9C4DD3B584EDA51B63ADF0', username='huang', email='18971390188@itcast.com', password='$2a$10$JI8d7la3QrnSwR2xGjJ9zudXpMouBpIx2yaO1dSB8LTLArjaOHlF6', phoneNum='18971390188', status=1, statusStr='null', roles=[]}

        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }


//    http://localhost:8081/user/findUserByIdAndAllRole.do?id=5BADB9A78A9C4DD3B584EDA51B63ADF0
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id") String userId){
        ModelAndView mv = new ModelAndView();
        //先查询出指定userId的user
        UserInfo userInfo = userService.findById(userId);
        //查出该userInfo中其不包含的所有角色roles数组
        List<Role> otherRoles = userService.findOtherRoles(userInfo);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }


//    http://localhost:8081/user/addRoleToUser.do
    //给用户添加角色
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(String userId,String[] ids){
        userService.addRoleToUser(userId,ids);

        return "redirect:findAll.do";
    }

}
