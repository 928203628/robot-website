package com.WebProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebProject.dao.UserDao;
import com.WebProject.dao.impl.UserDaoImpl;
import com.WebProject.vo.User;
//用户servlet类
public class UserServlet extends HttpServlet {
	UserDao mUserDao = new UserDaoImpl();
	//初始化方法
	public void init() throws ServletException{
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if (method.equals("getUser")) {
			getUser(request, response);//登录
		} else if (method.equals("add")) {
			add(request, response);//注册
		} else if (method.equals("close")) {
			close(request, response);//退出登录  暂时没用到
		}

	}

	private void close(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User mUser = new User( username, password,0.0);
		if(mUserDao.add(mUser)){
			request.setAttribute("message", "Register successfully, please log in!");
			request.getRequestDispatcher("/signin.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Registration failed, please check it!");
			request.getRequestDispatcher("/create_account.jsp").forward(request, response);
		}
	}

	private void getUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User mUser = mUserDao.getUser(username, password);
		if(mUser!=null){
			request.getSession().setAttribute("user", mUser);//把人员对象放到session中，给后面使用
			response.sendRedirect(request.getContextPath() + "/productServlet?method=findAll");
		}else{
			request.setAttribute("message", "Login failed, please check user name password first!");
			request.getRequestDispatcher("/signin.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
