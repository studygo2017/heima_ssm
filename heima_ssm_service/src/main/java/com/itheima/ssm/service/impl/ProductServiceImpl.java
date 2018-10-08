package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao iProductDao;

    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    @Override
    public void sava(Product product) {
        iProductDao.sava(product);
    }

    @Override
    public Product findById(String id) {
        return iProductDao.findById(id);
    }
}
