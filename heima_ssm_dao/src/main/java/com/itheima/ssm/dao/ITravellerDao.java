package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;

import java.util.List;

public interface ITravellerDao {
//    select * from traveller where id in (select travellerId from order_traveller where orderId='0E7231DC797C486290E8713CA3C6ECCC')
    public List<Traveller> findAll(String orderId);
}
