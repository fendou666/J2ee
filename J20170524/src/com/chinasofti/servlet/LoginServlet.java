package com.chinasofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String userName = request.getParameter("userName");
		System.out.println("�û����ǣ�|" +userName+"|");
		if(!userName.equals("")){
			System.out.println("�û�����tom");
			request.getSession().setAttribute("uname", userName);
			
			request.getRequestDispatcher("LoginSuccessFilter/Success.jsp").forward(request, response);
			//response.sendRedirect("LoginSuccessFilter/Success.jsp");
		}else{
			System.out.println("�û�������tom");
			response.sendRedirect("WorkIn/Error.jsp");
		}
		
		
		//String userName = (String)request.getAttribute("uname");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}