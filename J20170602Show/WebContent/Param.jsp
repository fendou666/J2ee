<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="js/cookie.js" ></script>
<!-- 更改浏览器的network disable catche true  -->
<script type="text/javascript">
	function getAllCookies(){
		setCookie("user", "aaa");
		console.log("user cookie为：" + getCookie("user"));
		console.log("其他不存在 cookie为：[" + getCookie("usera") + "]");
		console.log("所有cookie信息" + document.cookie);
		console.log("id cookie为：" + getCookie("id"));
		console.log(""+);
	}
</script>
<body onload="getAllCookies()">
	<%
		Cookie ck = new Cookie("id", "1111");
		ck.setMaxAge(20*24*60*60);
		response.addCookie(ck);
	%>
	
	
	
	
	
	
	
	
</body>
</html>