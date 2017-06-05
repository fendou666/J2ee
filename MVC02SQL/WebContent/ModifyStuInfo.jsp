<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学员信息</title>
</head>
<body>
	<%
		//获取需要修改的对象
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String gradeFrom=request.getParameter("gradeFrom");
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("sex:"+sex);
		sex=new String(sex.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("age:"+age);
		System.out.println("gradeFrom:"+gradeFrom);
		gradeFrom=new String(gradeFrom.getBytes("ISO-8859-1"),"UTF-8");
		if(id==null||name==null||sex==null||age==null||gradeFrom==null){
			response.sendRedirect("UserList.jsp");
			return;
		}
	%>
	<form action="UpdateServlet?action=stu_upd" method="post">
		学号:<%=id%><br><input type="hidden" name="id" value="<%=id%>"><!-- 隐藏元素 -->
		姓名：<input type="text" name="name" value="<%=name%>"><br>
		<%
		    System.out.println("sex000000:"+sex);
			if(sex.equals("男")){
				%>
				性别：<input type="radio" name="sex" value="0" checked="checked">男
				      <input type="radio" name="sex" value="1">女<br>
				
				<%
			}
			else{
				%>
				性别：<input type="radio" name="sex" value="0">男
				      <input type="radio" name="sex" value="1" checked="checked">女<br>
				
				<%
			}
		%>
		年龄：<input type="number" name="age" value="<%=age%>"><br>
		毕业院校：<input type="text" name="gradeFrom" value="<%=gradeFrom%>"><br>
		<input type="submit" value="保存">
	</form>
</body>
</html>