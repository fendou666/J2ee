<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="info" class="com.study.java.UserInfo" scope="page" ></jsp:useBean>
	<jsp:setProperty property="id" name="info" value="0001"/>
	<jsp:setProperty property="name" name="info" value="小明"/>
	id <jsp:getProperty property="id" name="info"/>
	name <jsp:getProperty property="name" name="info"/>
</body>
</html>