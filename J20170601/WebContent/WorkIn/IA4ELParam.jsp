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
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
	%>
	post id : ${param.id } <br>
	post name : ${param.name } <br>
	post checkBox : ${paramValues.ck} <br>
	post checkBox1 : ${paramValues.ck[0]} <br>
	post checkBox2 : ${paramValues.ck[1]} <br>
	post checkBox3 : ${paramValues.ck[2]} <br>
</body>
</html>