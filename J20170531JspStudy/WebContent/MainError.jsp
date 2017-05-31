<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	exception
	<%=exception %> <br>
	exception.getLocalizedMessage()
	<%=exception.getLocalizedMessage() %> <br>
	exception.getMessage()
	<%=exception.getMessage() %> <br>
	<%-- <%=exception.printStackTrace() %> --%> <!-- 这个设置后会将整个页面覆盖-->  
	
	<%=exception.getStackTrace() %>
</body>
</html>