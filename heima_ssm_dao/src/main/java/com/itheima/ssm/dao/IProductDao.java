package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface IProductDao {
//    @Select("select * from product")
    public List<Product> findAll();
//   public List<Product> findAll();

   /* private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;
    */
//    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void sava(Product product);

    public Product findById(String id);
}
