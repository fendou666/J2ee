<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%	
	String a = "我是java";
	out.write("<script type=\"text/javascript\">var i ='" + a +"';</script>");
	String[] b= {"1","2","3","4"};
	request.setAttribute("strAry", b);
%>
<script type="text/javascript">
	console.log(i);
	function aa(){
		return "我是js";
	}
	var y = <%="'aaa'"%>;
	console.log(y);
</script>




<body>
	<c:forEach var="tmp" items="${requestScope.strAry }">
		<script type="text/javascript">
			console.log(tmp);
		</script>
	</c:forEach>


</body>
</html>