package com.WebProject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.WebProject.dao.ProductDao;
import com.WebProject.db.DBConnect;
import com.WebProject.vo.Product;
//��Ʒ���ݿ�ӿ�ʵ����
public class ProductDaoImpl implements ProductDao {
	//��ѯ���в�Ʒ
	@Override
	public List<Product> findAll() {
		PreparedStatement pstmt = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "select * from product";
			pstmt = DBConnect.getInstance().getConnection()
					.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Product msg = null;
			while (rs.next()) {
				msg = new Product();
				msg.setId(rs.getInt(1));
				msg.setName(rs.getString(2));
				msg.setPrice(rs.getDouble(3));
				msg.setCount(rs.getInt(4));
				msg.setSpecifications(rs.getString(5));
				msg.setInfo(rs.getString(6));
				msg.setImage(rs.getString(7));
				msg.setImage1(rs.getString(8));
				list.add(msg);
			}
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	 //�޸Ĳ�Ʒ���
	@Override
	public boolean modify(Product mProduct) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			String sql = String
					.format("update product set count=%s where id=%s",
							mProduct.getCount(), mProduct.getId());
			pstmt = DBConnect.getInstance().getConnection()
					.prepareStatement(sql);
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//����id��ѯ��Ʒ
	@Override
	public Product queryById(int id) {
		PreparedStatement pstmt = null;
		Product msg = null;
		try {
			String sql = "select * from product where id=?";
			pstmt = DBConnect.getInstance().getConnection()
					.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				msg = new Product();
				msg.setId(rs.getInt(1));
				msg.setName(rs.getString(2));
				msg.setPrice(rs.getDouble(3));
				msg.setCount(rs.getInt(4));
				msg.setSpecifications(rs.getString(5));
				msg.setInfo(rs.getString(6));
				msg.setImage(rs.getString(7));
				msg.setImage1(rs.getString(8));
			}
			
			pstmt.close();
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
