package com.WebProject.dao;

import com.WebProject.vo.User;

public interface UserDao {
	//�û�ע��ӿ�
     public boolean add(User mUser);
     //��¼�ӿ�
     public User getUser(String username,String password);
     //�û���Ϣ�޸Ľӿ�  ����������Ϣ���޸�
     public boolean modify(User mUser);
}
