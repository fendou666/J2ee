<%@page import="java.util.Enumeration"%>
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
	/* function getAllCookies(){
		setCookie("user", "aaa");
		console.log("user cookie为：" + getCookie("user"));
		console.log("其他不存在 cookie为：[" + getCookie("usera") + "]");
		console.log("所有cookie信息" + document.cookie);
		console.log("id cookie为：" + getCookie("id"));
		
	} */
	function requestServlet(){
		<%
			request.getRequestDispatcher("TestServlet2").forward(request, response);
		%>
		//location.href = "TestServlet2"; (两种请求结果不一样？？？)
	}
</script>
<body onload="getAllCookies(),requestServlet()">
	<%-- <%
		Cookie ck = new Cookie("id", "1111");
		ck.setMaxAge(20*24*60*60);
		response.addCookie(ck);
	%>

	<%
		pageContext.setAttribute("page2", "我是page2");
	%>
	
	<%
		System.out.println("page2页面");
		System.out.println("page1" + pageContext.getAttribute("page1"));
		System.out.println("page2" + pageContext.getAttribute("page2"));
	%>
	
	<% 
		String noLoginIP = request.getServletContext().getInitParameter("noLoginIP");
		System.out.println("noLoginIp:" + noLoginIP);
	%>
	 --%>
	<% 
	
		Enumeration<String> abt = application.getAttributeNames();
		while (abt.hasMoreElements()) {
		   String attribute = (String) abt.nextElement();
		   System.out.println("page2  attribute Name:" + attribute);
		}
	%>
	
</body>
</html>