package com.itheima.ssm.service;


import com.itheima.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();

    public void sava(Product product);

    public Product findById(String id);
}
