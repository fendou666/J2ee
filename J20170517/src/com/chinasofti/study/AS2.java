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
 * Servlet implementation class MyA1Servlet
 */
@WebServlet("/AS2")
public class AS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AS2() {
    	count = 0;
    	System.out.println("A1======构造方法");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("A1======init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("A1=====destroy");
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
		
//		请求解析
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		user = new String(user.getBytes("ISO-8859-1"), "UTF-8");
		pwd = new String(pwd.getBytes("ISO-8859-1"), "UTF-8");
		
		
//		请求响应
//		ServletOutputStream outputStream = response.getOutputStream();
		PrintWriter writer = response.getWriter();
		count++;
		writer.write(user + pwd + "您是第" + count + "位访问myA1Servlet");
		System.out.println("A1=====doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
