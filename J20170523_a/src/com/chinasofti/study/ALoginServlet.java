package com.chinasofti.study;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ALoginServlet")  // 此处名字可更改？
public class ALoginServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		获取参数
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		UserInfo u = new UserInfo(userName, pwd);
		System.out.println("登陆的用户信息是：" + u);
//		参数验证(客户端做参数基本检查)
		// TODO
		
		
//		逻辑操作
		ServletContext app = getServletContext();
		app.setAttribute("user", u);
		HashSet<UserInfo> userSet = (HashSet<UserInfo>)app.getAttribute("userSet");
		if(userSet==null){
			userSet = new HashSet<UserInfo>();
		}
		userSet.add(u);
		app.setAttribute("userSet", userSet);
		
//		响应重定向
		resp.sendRedirect("WorkAfter/LoginSuccess.jsp");  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
