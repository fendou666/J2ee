package com.chinasofti.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlets
 */
@WebServlet("/MyFirstServlets")
public class MyFirstServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		user = new String(user.getBytes("ISO-8859-1"), "UTF-8");
		pwd = new String(pwd.getBytes("ISO-8859-1"), "UTF-8");
//		ServletOutputStream outputStream = response.getOutputStream();
		PrintWriter writer = response.getWriter();
		count++;
		writer.write(user + pwd + "���ǵ�" + count + "λ����myFirstServlet");
		System.out.println("first=====doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
