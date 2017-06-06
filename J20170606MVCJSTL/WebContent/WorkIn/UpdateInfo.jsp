<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	div{
		position:absolute;
		width:400px;
		left:50%;
		top:20%;
		margin-left:-200px;
	}
	table{
		margin:auto;
		width:400px;
		border:2px solid blue;
	}
	tr{
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
	
	<c:if test="${empty requestScope.stu }">
		<c:set var="msg" value="没有获取到参数" scope="request"></c:set>
		<jsp:forward page="Success.jsp"></jsp:forward>
	</c:if>
	
	<%=request.getContextPath() %>
	<%-- <div>
		<form action="/OracleOperationServlet?action=cg" method="post">
			<table>
				<tr>
					<td>序号</td>
					<td><input type="text" name="id" value="${sessionScope.stu.id}" /></td>
				</tr>
				<tr>
					<td>学号</td>
					<td><input type="text" name="num" value="${sessionScope.stu.num}" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name" value="${sessionScope.stu.name}" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<c:if test="${sessionScope.stu.sex eq '男'}">
							男<input type="radio" name="sex" checked="checked" value="男" />
							女<input type="radio" name="sex" value="女" />
						</c:if>
						<c:if test="${sessionScope.stu.sex eq '女'}">
							男<input type="radio" name="sex"  value="男" />
							女<input type="radio" name="sex" checked="checked" value="女" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" value="${sessionScope.stu.age}" /></td>
				</tr>
				<tr>
					<td>毕业学校</td>
					<td><input type="text" name="school" value="${sessionScope.stu.school}" /></td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" value="更新数据"  >
						<input type="reset" value="重置数据"  >
					</td>
				</tr>
			</table>
		</form>
	</div> --%>
	
</body>
</html>