<%@page import="com.study.java.UserInfo"%>
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
		String str1 = "adsfasdf";
		int num1 = 10;
		boolean flag = false;
		UserInfo u = new UserInfo();
		u.setId("11111111");
		u.setName("小明");
		
		String [] strAry = new String[]{"aaa", "bbb", "ccc", "ddd"};
		request.setAttribute("str", str1);
		request.setAttribute("num", num1);
		request.setAttribute("String", flag);
		request.setAttribute("userInfo", u);
		request.setAttribute("strAry", strAry);
	%>
	str : ${requestScope.str} <br>
	num : ${requestScope.num} <br>
	<!-- 属性名不可以是关键字， 这里写成boolean会报错-->
	boolean : ${requestScope.String} <br>
	UserInfo : ${requestScope.userInfo} <br>
	UserInfo_id : ${requestScope.userInfo.id} <br>
	UserInfo_name : ${requestScope.userInfo.name} <br>
	UserInfo_id : ${requestScope.userInfo["id"]} <br>
	UserInfo_name : ${requestScope.userInfo["name"]} <br>
	
	strAry : ${requestScope.strAry} <br>
	strAry0 : ${requestScope.strAry[0]} <br>
	strAry1 : ${requestScope.strAry[1]} <br>
	strAry2 : ${requestScope.strAry[2]} <br>
	strAry3 : ${requestScope.strAry[3]} <br>
	
</body>
</html>