package com.chinasofti.study;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AMsgServlet")  // 此处名字可更改？
public class AMsgServlet  extends HttpServlet{

	private static final long serialVersionUID = 2L; // 这个不可以重复
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		获取参数
		ServletContext app = getServletContext();
		String title = req.getParameter("title");
		String msgContent = req.getParameter("msgContent");
		UserInfo u = (UserInfo)app.getAttribute("user");
		String msgTime = req.getParameter("time");
		Message msg = new Message(title, u, msgContent, msgTime);
		System.out.println("提交的留言是"+msg);
//		参数验证(客户端做参数基本检查)
		// TODO
		
		
//		逻辑操作
		
		ArrayList<Message> msgList =  (ArrayList<Message>)app.getAttribute("msg");
		if(msgList==null){
			msgList = new ArrayList<Message>();
		}
		msgList.add(msg);
		app.setAttribute("msg", msgList);
		
//		响应重定向
		resp.sendRedirect("WorkAfter/MessageShow.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
	
	
	
}
