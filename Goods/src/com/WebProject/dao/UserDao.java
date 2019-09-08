package com.WebProject.dao;

import com.WebProject.vo.User;

public interface UserDao {
	//用户注册接口
     public boolean add(User mUser);
     //登录接口
     public User getUser(String username,String password);
     //用户信息修改接口  包括余额的信息的修改
     public boolean modify(User mUser);
}
