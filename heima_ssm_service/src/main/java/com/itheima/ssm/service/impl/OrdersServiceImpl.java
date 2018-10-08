package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;
    @Override
    public List<Orders> findAll(int start,int size) {
        PageHelper.startPage(start,size);
        List<Orders> orders = iOrdersDao.findAll();
        return orders;
    }

    @Override
    public Orders findById(String id) {
        return iOrdersDao.findById(id);

    }
}
