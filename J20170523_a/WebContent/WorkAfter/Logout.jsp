<%@ page language="java" import="java.util.HashSet,com.chinasofti.study.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserInfo u = (UserInfo)application.getAttribute("user");
		HashSet<UserInfo> userSet = (HashSet<UserInfo>)application.getAttribute("userSet");
		userSet.remove(u);
		application.removeAttribute("user");
		out.write("当前用户注销成功");
		System.out.println("当前用户注销成功");
		response.sendRedirect("Login.jsp");
	%>
		
</body>
</html>