<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	111111
	<%
		System.out.println("请求2前");
		request.getRequestDispatcher("REQ_RESP2.jsp").forward(request, response);
		//response.sendRedirect("REQ_RESP2.jsp");
		System.out.println("请求2");
	%>
</body>
</html>