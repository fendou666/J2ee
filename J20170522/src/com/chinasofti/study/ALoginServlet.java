package com.chinasofti.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofiti.jdbc.Store;

@WebServlet("/ALoginServlet")  // �˴����ֿɸ��ģ�
public class ALoginServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private void setCharset(HttpServletRequest req, HttpServletResponse resp){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		���ñ����ʽ
		setCharset(req, resp);
		PrintWriter out = resp.getWriter();
//		��ȡ����
		String userName = null;
		String pwd = null;
		if(req.getMethod().equalsIgnoreCase("get")){
			userName 	= new String(req.getParameter("userName")
								.getBytes("ISO-8859-1"), "UTF-8");
			pwd 		= new String(req.getParameter("pwd")
								.getBytes("ISO-8859-1"), "UTF-8");
		}else{
			userName = req.getParameter("userName");
			pwd = req.getParameter("pwd");
		}
		UserInfo u = new UserInfo(userName, pwd);
		System.out.println("��½���û���Ϣ�ǣ�" + u);
//		������֤(�ͻ����������������)
		// TODO
		if(!Store.queryData(u, pwd)){
			out.write("�û��������������");
		}else{
//			�߼�����
			ServletContext app = getServletContext();
			app.setAttribute("user", u);
			HashSet<UserInfo> userSet = (HashSet<UserInfo>)app.getAttribute("userSet");
			if(userSet==null){
				userSet = new HashSet<UserInfo>();
			}
			userSet.add(u);
			app.setAttribute("userSet", userSet);
//			cookie���� 
			Cookie userC = new Cookie("user", URLEncoder.encode(u.getName()));
			Cookie pwdC = new Cookie("pwd", pwd);
			userC.setMaxAge(10*24*60*60);
			pwdC.setMaxAge(10*24*60*60);
			resp.addCookie(userC);
			resp.addCookie(pwdC);
//			��Ӧ�ض���
			resp.sendRedirect("WorkAfter/LoginSuccess.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}