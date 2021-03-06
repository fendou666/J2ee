package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet("/AJAX")
public class AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AJAX() {
    	
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
		out.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
