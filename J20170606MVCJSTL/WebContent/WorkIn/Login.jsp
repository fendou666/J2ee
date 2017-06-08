<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	#login {
		position: absolute;
		left: 50%;
		top: 35%;
		width:600px;
		height:100px;
		margin-left:-300px;
		/* margin-top:-50px; */
		
	}
	table {
		width: 300px;
		margin: auto;
		border: 2px solid blue;
	}
</style>
<body>
	
	<div id="login">
		<form action="<%=request.getContextPath() %>/LoginServlet" method="post">
			<table >
				<tr>
					<td>用户名:</td>
					<td>
						<input type="text" required="required" name="userName" id="userName" placeholder="输入用户名" >
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
						<input type="password" required="required" name="pwd" id="pwd" placeholder="输入密码" >
					</td>
				</tr>	
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="登陆"  >
						<input type="reset" value="重置"  >
						<button onclick="" >注册</button>
					</td>
				</tr>
			</table>
		</form>	
	</div>
	<c:if test="${not empty  sessionScope.errInfo}">
		<div>
			<p style="color:red">${sessionScope.errInfo }</p>
		</div>
		<c:remove var="errInfo" scope="session"/>
	</c:if>
</body>
</html>