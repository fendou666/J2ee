<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	function ajaxTest(){
		// 创建ajax组件
		var xmlHttp;
		if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}else{
			xmlHttp = new XMLHttpRequest();			
		}
		// 绑定ajax触发函数
		xmlHttp.onreadystatechange = function(){
			document.getElementById("cg").innerText = xmlHttp.responseText;
		}
		// 打开请求
		xmlHttp.open("post", "AJAX");
		// 请求发送
		xmlHttp.send(null);
		
		//xmlHttp.open("post", "new.jsp");
		// 请求发送
		//xmlHttp.send(null);
	}
	window.onload = function(){
		window.setInterval(ajaxTest, 1000)
	}
	
</script>
<body>
	<form action="https://www.baidu.com" method="get">
		<input type="text" name="userName" id="userName" />
		<p id="cg">aaa</p>
		<input type="submit" value="提交1" onclick="ajaxTest()" />
	</form>
	<input type="submit"  value="提交2" onclick="ajaxTest()" />
</body>
</html>