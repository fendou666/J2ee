<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function hrefChangeF(){
		location.href="MyFirstServlet";
	}
	function hrefChangeS(){
		location.href="ServletSecond";
	}
</script>
<body>
	<form>
		<button onclick="hrefChangeF()" >按钮提交FF</button>
	</form>	
	<form>
		<button onclick="hrefChangeS()"  >按钮提交SS</button>
	</form>
</body>
</html>