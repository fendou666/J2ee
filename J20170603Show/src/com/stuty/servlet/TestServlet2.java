package com.stuty.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie[] cks = request.getCookies();
//		if(cks!=null){
//			for(Cookie c: cks){
//				System.out.println("key :" + c.getName() + " value:" + c.getValue());
//			}
//		}
//		request.getSession().setMaxInactiveInterval(30*60);
//		System.out.println("当前session id:" + request.getSession().getId());
//		System.out.println("当前session 有效时长:" + request.getSession().getMaxInactiveInterval());
		//response.getWriter().write("我是TestServlet2的返回值"); //response结束当次请求，并且将session重新设置)
		
		ServletContext sc = request.getServletContext();
		String servlet1Str = (String)sc.getAttribute("servlet1");
		System.out.println("servlet1Str" + servlet1Str);
		Enumeration<String> abt = sc.getAttributeNames();
		while (abt.hasMoreElements()) {
		   String attribute = (String) abt.nextElement();
		   System.out.println("servlet2 attribute Name:" + attribute);
		}
		// 获取初始化参数
//		String noLoginIP = request.getServletContext().getInitParameter("noLoginIP");
//		System.out.println("servlet2 noLoginIp:" + noLoginIP);
		
		response.getWriter().write("我是TestServlet2的返回值");
		//request.getRequestDispatcher("AllRquest1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
