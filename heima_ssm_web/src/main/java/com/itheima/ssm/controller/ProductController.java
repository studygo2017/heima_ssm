package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        List<Product> productList = iProductService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",productList);
        mv.setViewName("product-list1");
        System.out.println("findAll.do。。。");
        return mv;
    }

    @RequestMapping("sava.do")
    public void sava(Product product, HttpServletRequest request,HttpServletResponse response) throws IOException {

        iProductService.sava(product);
        response.sendRedirect(request.getContextPath()+"/product/findAll.do");
    }
}
