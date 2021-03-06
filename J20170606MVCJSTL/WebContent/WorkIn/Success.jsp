<%@page import="java.util.Iterator"%>
<%@page import="com.study.mvc.model.javabean.StudentInfo"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	div {
		width:800px;
		position:absolute;
		left: 50%;
		margin-left:-400px;
	}
	table {
		width: 800px;
		margin: auto;
		border: 2px solid blue;
		border-collapse: collapse;
	}
	td {
		border: 1px solid blue;
	}
</style>
<body>
	<c:if test="${empty sessionScope.stu}">
		<jsp:forward page="NoLogin.jsp"></jsp:forward>	
	</c:if>
	<c:if test="${not empty sessionScope.stu}">
		用户名:<c:out value="${sessionScope.stu.name }"></c:out>
	</c:if>
	<c:if test="${not empty sessionScope.msg}">
		<div style="color:red">${sessionScope.msg}</div>
		<jsp:forward page="Login.jsp"></jsp:forward>	
	</c:if>
	<c:if test="${not empty requestScope.msg}">
		<div style="color:red">${requestScope.msg}</div>
		<c:remove var="msg" scope="request"/>
	</c:if>
	
	<div>
		<table id="tb">
			<tr>
				<td>序号</td>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>毕业院校</td>
				<td colspan="2">操作</td>
			</tr>
			<c:if test="${empty sessionScope.stuList}">
				<tr>
					<td colspan="6">没有获取到信息</td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.stuList}">
				<c:forEach var="tmp" items="${sessionScope.stuList}" varStatus="iid">
					<tr>
						<td>${tmp.id}</td>
						<td>${tmp.num}</td>
						<td>${tmp.name}</td>
						<td>${tmp.sex}</td>
						<td>${tmp.age}</td>
						<td>${tmp.school}</td>
						<td><a href="<%=request.getContextPath() %>/OracleOperationServlet?action=seachById&id=${tmp.id}">修改</a></td>
						<td><a href="<%=request.getContextPath() %>/OracleOperationServlet?action=del&delNum=${tmp.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
	
</body>
</html>