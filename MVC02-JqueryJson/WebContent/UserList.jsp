<%@page import="com.study.mvc.model.bean.StudentInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.study.mvc.model.bean.UserInfo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- uri:标签库描述文件所在位置 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>具体功能页面</title>
<script type="text/javascript" src="Myjs/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function delArm(){
		if(confirm("确认要删除吗？")){
			return true;
		}	
		else{
			return false;
		}
	}
</script>
<script type="text/javascript">
	$(function(){
		$("#search").click(function(){
			$.post(
				"GetDataRowsByCondtion",
				{
					stuname:$("#stuname").val()
				},
				function(data){	
					//将Json转换为Js数组对象
					var students=eval(data);
					var htmStr="";
					htmStr+="<table border=\"3\">";
					htmStr+="<caption>学员信息一览</caption>";
					htmStr+="<tr><td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>毕业院校</td><td colspan=\"2\">操作</td></tr>";
					
					//如何使用Jquery解析XML中的数据
					//用Jquery方法each遍历该数组对象，尤其注意遍历规则函数的写法
					$.each(students,function(i){
						if(students[i].id==""){
							htmStr+="<tr>";
							htmStr+="<td colspan=\"8\">没有符合条件的数据</td>";
							htmStr+="</tr>";
							return;
						}
						htmStr+="<tr>";
						htmStr+="<td>"+(i+1)+"</td>";
						htmStr+="<td>"+students[i].id+"</td>";
						htmStr+="<td>"+students[i].name+"</td>";
						htmStr+="<td>"+students[i].sex+"</td>";
						htmStr+="<td>"+students[i].age+"</td>";
						htmStr+="<td>"+students[i].gradeFrom+"</td>";
						htmStr+="<td><a href=\"QueryServlet?action=getStuByID&id="+students[i].id+"\">修改</a></td>";
						htmStr+="<td><a href=\"UpdateServlet?action=stu_del&id="+students[i].id+"\" onclick=\"return delArm()\">删除</a></td>";
						htmStr+="</tr>";
					});
					htmStr+="</table>";
					//alert(htmStr)
					$("#tbl").html(htmStr);					
				},
				"JSON"
			);
		});
	});
</script>
</head>
<body>
	<%-- <c:if test="${empty sessionScope.userInfo}">
		<jsp:forward page="LoginServlet"></jsp:forward>
	</c:if> --%>
	<c:if test="${not empty requestScope.msg}">
		<div style="color: red">${requestScope.msg}</div>
	</c:if>
	欢迎您，${sessionScope.userInfo.name}
	<hr>
    <form action="" >
	<table border="3">
	    <caption>学员信息查询处理</caption>
	    <!-- <tr>
	       <td>学号：</td>
	       <td><input type="number" name="stuid" id="stuid"></td>
	    </tr> -->
	    <tr>
	       <td>姓名：</td><!--模糊查询-->
	       <td><input type="text" name="stuname" id="stuname"></td>
	    </tr>
	    <tr>
	       <td colspan="2" style="text-align: center;">
	       		<input type="button" id="search" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       		<input type="button" id="clear" value="重置查询">
	       	</td>
	    </tr>
	</table>
    </form>
    <!-- Ajax需要刷新的区域 -->
    <div id="tbl">
    
    </div>
	<%-- <table border="3">
	    <caption>学员信息一览</caption>
		<tr>
			<td>序号</td>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>毕业院校</td>
			<td colspan="2">操作</td>
		</tr>
		<c:if test="${not empty requestScope.stus}">
			<c:forEach var="stu" items="${requestScope.stus}" varStatus="iid">
				<tr>
					<td>${iid.index+1}</td>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.sex}</td>
					<td>${stu.age}</td>
					<td>${stu.gradeFrom}</td>
					<td><a href="QueryServlet?action=getStuByID&id=${stu.id}">修改</a></td>
					<td><a href="UpdateServlet?action=stu_del&id=${stu.id}" onclick="return delArm()">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.stus}">
			<tr>
				<td colspan="8">没有找到数据</td>
			</tr>
		</c:if>
	</table> --%>
</body>
</html>