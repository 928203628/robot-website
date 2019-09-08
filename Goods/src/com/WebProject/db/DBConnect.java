package com.WebProject.db;


import java.sql.Connection;
import java.sql.DriverManager;

//���ݿ�������
public class DBConnect {  
	    private final String DBDRIVER = "com.mysql.jdbc.Driver";   
	    private final String DBURL = "jdbc:mysql://127.0.0.1:3306/goods?useUnicode=true&characterEncoding=utf-8";   
	    private final String DBUSER = "root";   
	    private final String DBPASSWORD = "cdaz302158";   
	    private Connection conn = null;
	  
		//����ģʽ����ȡ����
		private static DBConnect instance;
		
		public static DBConnect getInstance(){
			synchronized (DBConnect.class) {
				if(instance==null){
					try {
						instance = new DBConnect();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
			}
			
			return instance;
		}
		
		
	    public DBConnect()   {   
	        try{
	        	//ע�����ݿ�����
	            Class.forName(DBDRIVER) ;   
	            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;  
	        }catch (Exception e){ 
	        	System.out.println(e.getMessage());  
	        	}   
	    }   
	  
	    // ȡ�����ݿ�����   
	    public Connection getConnection(){   
	        return this.conn ;   
	    }   
	  
	    // �ر����ݿ�����   
	    public void close(){   
	        try{   
	            this.conn.close() ;   
	        }catch (Exception e){ }          
	    }   
}  
