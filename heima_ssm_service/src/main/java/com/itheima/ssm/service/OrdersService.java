package com.itheima.ssm.service;

import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrdersService {

    public List<Orders> findAll(int start,int size);

    public Orders findById(String id);

}
