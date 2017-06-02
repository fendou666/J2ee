<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.study.jspJava.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		jsp表达式：
		<%=request.getContextPath() %>
		<%=getTestInfo() %>
	</p>
	
	<p>
		jsp代码块：
		<%
			u = new UserInfo();
			u.setName("小明");
			u.setId(2134);
		%>
	</p>
	
	<p>
		jsp声明：
		<%!
			UserInfo u;
			public String getTestInfo(){
				return "我是一个全局函数";
			}
		%>
	</p>

</body>
</html>