package com.exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofiti.jdbc.Store;
import com.exercise.java.UserInfo;

/**
 * Servlet implementation class ALoginServlet
 */
@WebServlet("/ALoginServlet")
public class ALoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ALoginServlet() {
    	
    }

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
			userName 	= new String(req.getParameter("user")
								.getBytes("ISO-8859-1"), "UTF-8");
		}else{
			userName = req.getParameter("user");
		}
		UserInfo u = new UserInfo(userName);
		System.out.println("��½���û���Ϣ�ǣ�" + u);
//		������֤(�ͻ����������������)
		// TODO
		if((u=Store.queryData(u))==null){
			out.write("false");
			System.out.println("�û���������");
		}else{
			out.write("true");
			System.out.println("�û�������");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}