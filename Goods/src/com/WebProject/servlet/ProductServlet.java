package com.WebProject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebProject.dao.ProductDao;
import com.WebProject.dao.UserDao;
import com.WebProject.dao.impl.ProductDaoImpl;
import com.WebProject.dao.impl.UserDaoImpl;
import com.WebProject.vo.Product;
import com.WebProject.vo.User;
//产品servlet类
public class ProductServlet extends HttpServlet {
	private ProductDao mProductDao = new ProductDaoImpl();
	UserDao mUserDao = new UserDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method==null){
			findAll(request, response);//查询所有产品
		}else if (method.equals("findAll")) {
			findAll(request, response);//查询所有产品
		} else if (method.equals("modify")) {
			modify(request, response);//修改产品库存和用户余额减少    这个函数就是购买的功能实现
		} else if (method.equals("queryById")) {
			queryById(request, response);//跳转到产品详情页面   展示产品信息
		}

	}

	private void queryById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		
		Product myProduct = mProductDao.queryById(Integer.parseInt(id));
		request.setAttribute("Product", myProduct);
		request.getRequestDispatcher("/robot.jsp").forward(request, response);
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//判断当前用户余额是否能购买
		User mUser = (User) request.getSession().getAttribute("user");
		if(mUser==null){
			 request.setAttribute("message", "Please login first");
			 request.getRequestDispatcher("/signin.jsp").forward(request, response);
			 return;
		}
	    mUser = mUserDao.getUser(mUser.getUsername(), mUser.getPassword());
		
		String id  = request.getParameter("id");
		PrintWriter out = response.getWriter();
		Product mProduct = mProductDao.queryById(Integer.parseInt(id));
		if(mProduct.getCount()>0){
			
			if(mUser.getBalance()>=mProduct.getPrice()){
				mProduct.setCount(mProduct.getCount()-1);
				mProductDao.modify(mProduct);
				mUser.setBalance(mUser.getBalance()-mProduct.getPrice());
				mUserDao.modify(mUser);
				request.getSession().setAttribute("user", mUser);//更新在session中的人员信息
				
				out.println("<script>");
				out.println("alert('Successfully buy！')");
				out.println("window.location='index.jsp'");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('Purchase failure, current balance is insufficient!')");
				out.println("window.location='productServlet'");
				out.println("</script>");
			}
				
		}else{
			out.println("<script>");
			out.println("alert('Insufficient stock and failure to purchase！')");
			out.println("window.location='index.jsp'");
			out.println("</script>");	
		}
		out.flush();
		out.close();
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 List<Product> list = mProductDao.findAll();
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
