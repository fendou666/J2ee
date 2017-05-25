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

@WebServlet("/AMsgServlet")  // �˴����ֿɸ��ģ�
public class AMsgServlet  extends HttpServlet{

	private static final long serialVersionUID = 2L; // ����������ظ�
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		��ȡ����
		ServletContext app = getServletContext();
		String title = req.getParameter("title");
		String msgContent = req.getParameter("msgContent");
		UserInfo u = (UserInfo)app.getAttribute("user");
		String msgTime = req.getParameter("time");
		Message msg = new Message(title, u, msgContent, msgTime);
		System.out.println("�ύ��������"+msg);
//		������֤(�ͻ����������������)
		// TODO
		
		
//		�߼�����
		
		ArrayList<Message> msgList =  (ArrayList<Message>)app.getAttribute("msg");
		if(msgList==null){
			msgList = new ArrayList<Message>();
		}
		msgList.add(msg);
		app.setAttribute("msg", msgList);
		
//		��Ӧ�ض���
		resp.sendRedirect("WorkAfter/MessageShow.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
	
	
	
}