package com.WebProject.vo;
//�û���
public class User {
    private int id;//�û�id
    private String username;//�û���
    private String password;//����
    private double balance;//���
    
	public User(String username, String password,double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
    
}
