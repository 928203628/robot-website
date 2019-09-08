package com.WebProject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.WebProject.dao.UserDao;
import com.WebProject.db.DBConnect;
import com.WebProject.vo.User;
//人员数据库实现类
public class UserDaoImpl implements UserDao {
	//用户注册接口
	@Override
	public boolean add(User mUser) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			String sql = "insert into user(username,password,balance) values(?,?,?)";
			pstmt = DBConnect.getInstance().getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, mUser.getUsername());
			pstmt.setString(2, mUser.getPassword());
			pstmt.setDouble(3, mUser.getBalance());
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//登录接口
	@Override
	public User getUser(String username, String password) {
		PreparedStatement pstmt = null;
		User msg = null;
   	 try{
   		 String sql = "select * from user where username=? and password=?";
   	 		pstmt = DBConnect.getInstance().getConnection().prepareStatement(sql);
   	 	    pstmt.setString(1, username);
   	 	    pstmt.setString(2, password);
   	 		ResultSet rs = pstmt.executeQuery();
   	 		
   	 		if(rs.next()){
   	 			msg = new User();
   	 			msg.setId(rs.getInt(1));
   	 			msg.setUsername(rs.getString(2));
   	 			msg.setPassword(rs.getString(3));
   	 			msg.setBalance(rs.getDouble(4));
   	 		}
   	 	   
   	 		pstmt.close();
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
   	 return msg;
	}
	//用户信息修改接口  包括余额的信息的修改
	@Override
	public boolean modify(User mUser) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			String sql = String
					.format("update user set username='%s',password='%s',balance=%f where id=%d",
							mUser.getUsername(),mUser.getPassword(),mUser.getBalance(), mUser.getId());
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
	
	

}
