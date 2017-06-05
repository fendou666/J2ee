<%@page import="com.study.mvc.model.bean.StudentInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.study.mvc.model.bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>具体功能页面</title>
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
</head>
<body>
	<%
		UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");
		if(userinfo==null){
			request.getRequestDispatcher("LoginServlet").forward(request, response);
			return;
		}
	%>
	欢迎您，${sessionScope.userInfo.name}
	<hr>
	<table border="3">
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
		
		<%
		    List<StudentInfo> list=(List<StudentInfo>)request.getAttribute("stus");
		    if(list!=null){
		    	for(int i=0;i<list.size();i++){
		    		%>
					<tr>
						<td><%=i+1%></td>
						<td><%=list.get(i).getId()%></td>
						<td><%=list.get(i).getName()%></td>
						<td><%=list.get(i).getSex()%></td>
						<td><%=list.get(i).getAge()%></td>
						<td><%=list.get(i).getGradeFrom()%></td>
						<td><a href="ModifyStuInfo.jsp?id=<%=list.get(i).getId()%>&name=<%=list.get(i).getName()%>&sex=<%=list.get(i).getSex()%>&age=<%=list.get(i).getAge()%>&gradeFrom=<%=list.get(i).getGradeFrom()%>">修改</a></td>
						<td><a href="UpdateServlet?action=stu_del&id=<%=list.get(i).getId()%>" onclick="return delArm()">删除</a></td>
					</tr>
		    		<%
		    	}
		    }
		    else{
	    		%>
				<tr>
					<td colspan="8">没有找到数据</td>
				</tr>
	    		<%
		    }
		%>
		
	</table>
</body>
</html>