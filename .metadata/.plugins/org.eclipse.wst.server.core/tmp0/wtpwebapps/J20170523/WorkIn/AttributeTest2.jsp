<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 默认请求目录为当前目录  -->
<body>
	<%
		System.out.println(request.getAttribute("aaa"));
		//request.getRequestDispatcher("AttributeTest3.jsp").forward(request, response);
		response.sendRedirect("AttributeTest3.jsp");
	%>
</body>
</html>