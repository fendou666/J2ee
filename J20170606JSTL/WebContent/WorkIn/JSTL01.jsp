<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:out value="JSTL取代JAVA代码"></c:out>
<c:set value="10" var="age" scope="request" ></c:set>

<%
	out.write("我是JAVA的输出");
%>
<!-- var 存储表达式test的值, 表达式写法？？？, 表达式暂时EL表达式  -->
<c:if test="" var="result" scope="session">
</c:if>

<!-- 就是switch ... case语句  -->
<c:choose>
	<c:when test="">
	</c:when>
	<c:when test="">
	</c:when>
	<!-- 与choose配合使用 -->
	<c:otherwise>
	
	</c:otherwise>
</c:choose>

<%
	Date date = new Date();
	pageContext.setAttribute("date", date);
%>
<fmt:formatDate value="" type="both"/>
<fmt:formatDate value="" type="time"/>
<fmt:formatDate value="" type="date"/>



<!-- 循环,当做小白，好多东西是试出来的  -->
<c:forEach var="numberN" begin="0" end="5" step="2">
	<c:out value="${numberN}"></c:out>
</c:forEach>
<!--  varStatus="" 变量状态， 集合中会使用 -->
<!-- 只能从小往大走， 不方便,step不可以设置为赋值, 主要用于集合遍历 -->
<!--  items对应 setAttribute设置的key, begin对应从第一个开始， step对应 -->
<!-- items中的值对于如果不是page空间的，如何引用  -->
<!-- 不设置begin end 会默认输出所有 -->
<!-- varStatus变量状态 index 索引, count第几条, first: boolean判断第一条   -->
<!-- items:集合对象的名字  -->
<!-- 一会做个集合测试  -->
<!-- if 条件判断总结与EL结合 -->


<!-- 当有不稳定代码块的时候使用，特殊场景采用，一般不使用  -->
<c:catch var="errmsg">
	<%=20/0 %>
</c:catch>
err:${errmsg}

</body>
</html>