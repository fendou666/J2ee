<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/ALoginServlet" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="userName" id="user" />
					<span id="checkUser" style="color:red; display:none">*</span>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="pwd" id="pwd" />
					<span id="checkPwd" style="color:red; display:none">*</span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交" />
				</td>
				<td>
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>