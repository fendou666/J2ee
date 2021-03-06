package com.chinasofti.study;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("执行 doGet");

		ServletContext sc = getServletContext(); // sc不可能为null, 所以不需要判断
		String count = (String)sc.getAttribute("loginCount");
		if(count==null){
//			value值必须为引用类型
			sc.setAttribute("loginCount", "1");
		}else{
			sc.setAttribute("loginCount", Integer.parseInt(count) + 1 + "");
		}
		
//		URL重定向
//		resp.sendRedirect("WorkIn/Login.jsp");
//		req.getRequestDispatcher("WorkIn/Success.jsp");
		resp.sendRedirect("WorkIn/Success.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		
	}


}
