<%@page import="java.util.ArrayList"%>
<%@page import="com.study.java.UserInfo"%>
<%@page import="java.util.List"%>
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
		List<UserInfo> uList = new ArrayList<UserInfo>();
		uList.add(new UserInfo("11", "小明"));
		uList.add(new UserInfo("22", "小红"));
		uList.add(new UserInfo("33", "小强"));
		uList.add(new UserInfo("44", "小军"));
		request.setAttribute("uList", uList);
	%>
	${requestScope.uList}<br>
	
	<%
		for(UserInfo u:uList){
			request.setAttribute("user", u);
	%>
		${requestScope.user}<br>
	<%
		}
	%>
	
	
</body>
</html>