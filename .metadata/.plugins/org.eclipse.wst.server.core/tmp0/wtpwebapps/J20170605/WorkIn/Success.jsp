<%@page import="java.util.Iterator"%>
<%@page import="com.study.mvc.model.javabean.StudentInfo"%>
<%@page import="java.util.List"%>
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
			<% 
				List<StudentInfo> stuList = (List<StudentInfo>)session.getAttribute("stuList");
				if(stuList==null){
					%>
					<tr>
						<td colspan="6">没有获取到信息</td>
					</tr>
					<% 
				}else{
					Iterator<StudentInfo> iterator = stuList.iterator();
					StudentInfo tmp = null;
					while(iterator.hasNext()){
						tmp = iterator.next();
							out.write("<tr><td>"+tmp.getId()+"</td>"
							+"<td>"+tmp.getNum()+"</td>"
							+ "<td>"+tmp.getName()+"</td>"
							+ "<td>"+tmp.getSex()+"</td>"
							+ "<td>"+tmp.getAge()+"</td>"
							+ "<td>"+tmp.getSchool()+"</td>"
							+ "<td><a href="+ request.getContextPath() + "/OracleOperationServlet?action=cg>修改</a></td>"
							+ "<td><a href="+ request.getContextPath() + "/OracleOperationServlet?action=del&delNum="+ tmp.getId() + ">删除</a></td></tr>");
					}
				}
			%>
		</table>
	</div>
	
</body>
</html>