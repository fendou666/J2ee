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
	<!--第一种  -->
	<a href="MyFirstServlet">first</a>
	<a href="ServletSecond">seconde</a>
	<form action="MyFirstServlet">
		<input type="button" value="按钮提交F" onclick="hrefChangeF()" />
		<input type="submit" value="form提交" />
		<button onclick="hrefChangeF()" >按钮提交FF</button>
	</form>	
	<form action="ServletSecond">
		<input type="button" value="按钮提交S" onclick="hrefChangeS()" />
		<input type="submit" value="form提交" />
		<button onclick="hrefChangeS()"  >按钮提交SS</button>
	</form>
</body>
</html>