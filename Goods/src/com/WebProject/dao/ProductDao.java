package com.WebProject.dao;

import java.util.List;

import com.WebProject.vo.Product;
//��Ʒ���ݿ�����ӿ�
public interface ProductDao {
	//��ѯ���в�Ʒ
    public List<Product> findAll();
    //�޸Ĳ�Ʒ���
    public boolean modify(Product mProduct);
    //����id��ѯ��Ʒ
    public Product queryById(int id);
}
