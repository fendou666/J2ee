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
	welcome :${sessionScope.username}
	<br /> welcome:
	<br />
	<s:property value="uname" />
	<br />
	<s:property value="sex" />
	<br />
	<s:property value="age1" />
	<br /> ${sex} ${age1}
	<br />
	<%=request.getAttribute("sex")%><br />
	<%=request.getAttribute("age1")%><br />
	<hr />
	${sessionScope.loginuser}
	<br />
	<s:property value="#session.loginuser" />
	<br />
	<s:property value="loginuser" />
	<br />
	<s:debug></s:debug>

</body>
</html>