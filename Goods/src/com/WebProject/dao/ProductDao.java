package com.WebProject.dao;

import java.util.List;

import com.WebProject.vo.Product;
//产品数据库操作接口
public interface ProductDao {
	//查询所有产品
    public List<Product> findAll();
    //修改产品库存
    public boolean modify(Product mProduct);
    //根据id查询商品
    public Product queryById(int id);
}
