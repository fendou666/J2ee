<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.study.mvc.model.javabean.StudentInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	div#main {
		width:800px;
		position:absolute;
		top:300px;
		left: 50%;
		margin-left:-400px;
	}
	table {
		margin: auto;
	}
	div#main table {
		width: 800px;
		border: 2px solid blue;
		border-collapse: collapse;
	}
	
	td {
		border: 1px solid blue;
	}
</style>

<script type="text/javascript" src="../Myjs/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function getCustomPageIndex(){
		return $('pageIndex').val(); // 为什么这种不可以
		//return document.getElementById("pageIndex").value;
	}
	function getStuInfo(forword){
		$.post(
			"<%=request.getContextPath()%>/PageServlet",
			{
				action:"seachByNameJSONPage",
				sqlPageHashMap:"stuPage",
				pageIndex: forword,
				name:$("#stuName").val()
			},
			function(data){
				var students = eval(data);
				var htmlData = "";
				var student = "";
				var stuInfo = null;
				htmlData +="<caption>学员信息一览</caption>";
				htmlData += "<tr><td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>毕业院校</td><td colspan=\"2\">操作</td></tr>"
				// 这里null判断一定要注意
				if(students == null || students.length == 0){
					htmlData += "<tr >";
					htmlData += "<td colspan=\"7\">没有获取到数据</td>";
					htmlData += "</tr>";
				}else{
					$.each(students ,function(i){
						htmlData += "<tr>"
						htmlData += "<td>" + students[i].id  +"</td>";
						htmlData += "<td>" + students[i].num  +"</td>";
						htmlData += "<td>" + students[i].name  +"</td>";
						htmlData += "<td>" + students[i].age  +"</td>";
						htmlData += "<td>" + students[i].sex  +"</td>";
						htmlData += "<td>" + students[i].school  +"</td>";
						htmlData += "<td><a href=\"<%=request.getContextPath() %>/OracleOperationServlet?action=seachById&id="+ students[i].id +"\">修改</a></td>";
						htmlData += "<td><a href=\"<%=request.getContextPath() %>/OracleOperationServlet?action=del&delNum="+ students[i].id +"\">删除</a></td>";
						htmlData += "</tr>";
					})
					htmlData +=  '<td colspan="2"><input type="button"  onclick="getStuInfo(\'first\')" value="首页" ></td>';
					htmlData +=  '<td colspan="1"><input type="button"  onclick="getStuInfo(\'pre\')" value="前页" ></td>';
					htmlData +=  '<td colspan="1"><input type="button"  onclick="getStuInfo(\'next\')" value="次页" ></td>';
					htmlData +=  '<td colspan="2"><input type="button"  onclick="getStuInfo(\'last\')" value="尾页" ></td>';
					htmlData +=  '<td colspan="2"><input type="number" id="pageIndex">';
					//htmlData +=  '<input type="button" onclick="getStuInfo($(\'pageIndex\').val())" value="指定页" ></td>';
					htmlData +=  '<input type="button" onclick="getStuInfo(getCustomPageIndex())" value="指定页" ></td>';
					//htmlData +=  '<input type="button" onclick="getStuInfo(\'adsfadsf\')" value="指定页" ></td>';
				}
				
				$("#tb").html(htmlData);
			},
			"JSON"
		)
	}
	
 	$(function(){
		$("#subB").click(function(){
			getStuInfo('first');
		})
	})

</script>
<body>
	<%-- <c:if test="${empty sessionScope.stu}">
		<jsp:forward page="NoLogin.jsp"></jsp:forward>
	</c:if>	
	<c:if test="${not empty sessionScope.stu}">
		<div>用户名：${sessionScope.stu.name}</div>
	</c:if>	 --%>
	<div >
		<form id="seachFm">
			<table>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="stuName" id="stuName" ></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="button" value="查找" id="subB">
						<input type="button" value="重置" onclick="seachFm.reset()" >
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="main">
		<table id="tb">
			<caption>学员信息表</caption>
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
				<tr id="dataCg">
					<td colspan="7">没有获取到信息</td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.stuList}">
				<c:forEach var="tmp" items="${sessionScope.stuList}" varStatus="iid">
					<tr >
						<td>${tmp.id}</td>
						<td>${tmp.num}</td>
						<td>${tmp.name}</td>
						<td>${tmp.sex}</td>
						<td>${tmp.age}</td>
						<td>${tmp.school}</td>
						<td><a href="<%=request.getContextPath() %>/OracleOperationServlet?action=seachById&id=${tmp.id}">修改</a></td>
						<td><a href="<%=request.getContextPath() %>/OracleOperationServlet?action=del&delNum=${tmp.id}">删除</a></td>
						<td colspan="2"><input type="button"  onclick="getStuInfo('first')" value="首页" ></td>
						<td colspan="1"><input type="button"  onclick="getStuInfo('pre')" value="前页" ></td>
						<td colspan="1"><input type="button"  onclick="getStuInfo('next')" value="次页" ></td>
						<td colspan="2"><input type="button"  onclick="getStuInfo('last')" value="尾页" ></td>
						<td colspan="2">
							<input type="number" id="pageIndex">
							<input type="button" onclick="getStuInfo($('pageIndex').val())" value="指定页" >
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>