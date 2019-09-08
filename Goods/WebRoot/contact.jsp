<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>Contect | RobotTech</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	
</head>
<body>
<div class="hdr-bg">
<div class="wrap"> 
	<div class="header">
		<div class="logo">
				<a href="productServlet"><img src="images/logo1.png" alt=""  title="logo"/></a>
		</div>
        <div class="menu">
           <ul id="nav">
                <li ><a href="productServlet">Home</a></li>
                <li ><a class="hsubs" href="productServlet">Products</a>
                	<ul class="subs">
                        <li><a href="<c:url value='/productServlet?method=queryById&id=1'/>">Robot 001</a></li>
                        <li><a href="<c:url value='/productServlet?method=queryById&id=2'/>">Robot 002</a></li>
                   		<li><a href="<c:url value='/productServlet?method=queryById&id=3'/>">Robot 003</a></li>
                   		<li><a href="<c:url value='/productServlet?method=queryById&id=4'/>">Robot 004</a></li>
                    </ul>
                </li>
                <li><a class="hsubs" href="signin.jsp">Sign in</a></li>

                
                <li><a href="Blog.jsp">Video</a></li>
             <li class="active"><a href="contact.jsp">Contact</a></li>
            </ul>
	</div>
	<div class="clear"></div>	
	</div>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
	<div class="image-slider">
				
			    
			      <li><img src="images/contact.jpg" ></li>
			      
			   
				 
	</div>
<div class="cnt-bg">
<div class="wrap"> </div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="ftr-bg">
	<div class="wrap"> 
		<div class="footer">
				<p> All rights Reserved | Made by Weijia</p>
		</div>
	</div>
</div>
</body>
</html>