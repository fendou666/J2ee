package com.chinasofti.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
    	count = 0;
    	System.out.println("first======构造方法");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("first======init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("first=====destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("======service");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		第一步乱码处理
		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		System.out.println(request.getCharacterEncoding());
//		请求解析
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
//		user = new String(user.getBytes("ISO-8859-1"), "UTF-8");
//		pwd = new String(pwd.getBytes("ISO-8859-1"), "UTF-8");
		
		
//		请求响应
//		ServletOutputStream outputStream = response.getOutputStream();
		PrintWriter writer = response.getWriter();
		count++;
		writer.write(user + pwd + "您是第" + count + "位访问myFirstServlet");
		System.out.println("first=====doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
