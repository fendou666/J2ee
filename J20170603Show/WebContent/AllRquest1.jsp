<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//request.getRequestDispatcher("TestServlet1").forward(request, response);
		//response.sendRedirect("TestServlet1");
	%>

	<form action="TestServlet1">
			<span>用户名</span>
			<input type="text" name="userId" id="userid" /> <br>
			<input type="submit" value="提交" >
	</form>
	
	
	<%-- <%
		pageContext.setAttribute("page1", "我是page1");
	%>
	
	<%
		System.out.println("page1页面");
		System.out.println("page1" + pageContext.getAttribute("page1"));
		System.out.println("page2" + pageContext.getAttribute("page2"));
	%>
	
	<% 
		String noLoginIP = request.getServletContext().getInitParameter("noLoginIP");
		System.out.println("noLoginIp:" + noLoginIP);
	%>
	 --%>
	
	<% 
	
		Enumeration<String> abt = application.getAttributeNames();
		while (abt.hasMoreElements()) {
		   String attribute = (String) abt.nextElement();
		   System.out.println("page1 attribute Name:" + attribute);
		}
	%>
</body>
</html>