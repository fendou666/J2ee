<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%session.setAttribute("aaa", "神马都是浮云"); %>
	<form action="<%=request.getContextPath() %>/AS3" method="get">
		<span>用户名：</span>
		<input type="text" name="user" id="user"> <br>
		<span>密码：</span>
		<input type="password" name="pwd" id="pwd"> <br>
		<input type="submit" name="submit" value="提交">
		<input type="reset" name="reset" value="重置">
	</form>
</body>
</html>