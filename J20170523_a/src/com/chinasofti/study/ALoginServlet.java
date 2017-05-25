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

@WebServlet("/ALoginServlet")  // �˴����ֿɸ��ģ�
public class ALoginServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		��ȡ����
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		UserInfo u = new UserInfo(userName, pwd);
		System.out.println("��½���û���Ϣ�ǣ�" + u);
//		������֤(�ͻ����������������)
		// TODO
		
		
//		�߼�����
		ServletContext app = getServletContext();
		app.setAttribute("user", u);
		HashSet<UserInfo> userSet = (HashSet<UserInfo>)app.getAttribute("userSet");
		if(userSet==null){
			userSet = new HashSet<UserInfo>();
		}
		userSet.add(u);
		app.setAttribute("userSet", userSet);
		
//		��Ӧ�ض���
		resp.sendRedirect("WorkAfter/LoginSuccess.jsp");  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
