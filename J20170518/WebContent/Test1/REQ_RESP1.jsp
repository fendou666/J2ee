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
	
		// requst页面回将当前页面作为默认位置，请求其他位置会加上链接(在前面不加/的时候), 默认/即当前项目下的/目录
		//request.getRequestDispatcher("Test2/REQ_RESP2.jsp").forward(request, response);
		//request.getRequestDispatcher("/Test2/REQ_RESP2.jsp").forward(request, response);
		
		// resp 不加/ 只在当前目录基础上加和req一样, 加/会把它当做直接项目名
		//response.sendRedirect("Test2/REQ_RESP2.jsp");
		// 正确的请求
		//request.getRequestDispatcher("/Test2/REQ_RESP2.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/Test2/REQ_RESP2.jsp");
		System.out.println("请求2");
	%>
</body>
</html>