package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name="start",defaultValue="1",required =true) int start, @RequestParam(name="size",defaultValue="4",required = true) int size){
        List<Orders> orders = ordersService.findAll(start,size);
        ModelAndView mv = new ModelAndView();
//        mv.addObject("ordersList",orders);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("size",size);
        mv.setViewName("orders-page-list");
        return mv;
    }

    //订单详情查询
    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");

        return mv;
    }

}
