<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function clickSubmit(){
		var user = document.getElementById("user").value;
		var pwd = document.getElementById("pwd").value;
		location.href = "MyFirstServlet?user="+user + "&pwd="+pwd;
	}
</script>
<body>
	<form action="MyFirstServlet" method="get">
		<span>用户名：</span>
		<input type="text" name="user" id="user" />
		<br>	
		<span>密码：</span>
		<input type="password" name="pwd" id="pwd" />	
		<br>
		<input type="submit" value="提交请求" >	
		<!-- <a id="sub" onclick="clickSubmit()">提交</a> -->
	</form>
</body>
</html>