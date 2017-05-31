<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="com.study.jspJava.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		//List<Message> msgList = (List<Message>)getServletContext().getAttribute("msgInfo");
		List<Message> msgList = null; 
		public synchronized void addMsg(Message msg){
			ServletContext sc = getServletContext();
			List<Message> msgList = (List<Message>)sc.getAttribute("msgInfo");
			if(msgList==null){
				msgList = new ArrayList<Message>();
			}
			msgList.add(msg);
			sc.setAttribute("msgInfo", msgList);
		}
	%>
	<%
		String title 	= 	request.getParameter("title");
		String name 	= 	request.getParameter("name");
		String content 	= 	request.getParameter("content");
		if(title==null || name==null || content==null ){
			request.setAttribute("reqRst", "信息不完整！");
			request.getRequestDispatcher("SetMsg.jsp").forward(request, response);
			return;
		}
		//Message msg = new Message(title, name, content, (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())));
		Message msg = new Message(title, name, content, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
		addMsg(msg);
		request.setAttribute("reqRst", "请求成功");
		System.out.println("请求成功");
		request.getRequestDispatcher("SetMsg.jsp").forward(request, response);
		//response.sendRedirect("SetMsg.jsp");
		// sesstion重定向+++
	%>
</body>
</html>