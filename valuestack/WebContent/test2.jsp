<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	静态属性值为：
	<s:property value="@chinasofti.commons.MyStatic@PI" />
	<br> 调用静态方法
	<s:set name="aaa" value="@chinasofti.commons.MyStatic@a()" />
	<s:property value="#aaa"/>
	<s:debug></s:debug>
</body>
</html>