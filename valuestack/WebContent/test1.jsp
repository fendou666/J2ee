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
<%
	//request.getSession().setAttribute("www", "chinasofti");
	pageContext.setAttribute("www", "chinasofti");
	request.setAttribute("wwwrequest", "wwwrequest");
%>
	<s:set name="uname" value="'Tom1'" />
	<s:property value="#uname" />
	<br />
	<s:property value="uname" />
	<br />
	<s:property value="'account'" />
	<br />
	<s:property value="'7+8'" />
	<br />
	<s:property value="7+8" />
	<br />
	<hr />
	${www}	<br />
	<s:property value="#attr.www" />
	<br />
	<s:property value="#request.wwwrequest" />
	
	<s:debug></s:debug>
</body>
</html>