<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<% 
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String school = request.getParameter("school");
		if(id==null||num==null||name==null||sex==null||age==null||school==null){
			out.write("没有获取到参数");
		}else{
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			sex = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
			school =  new String(school.getBytes("ISO-8859-1"), "UTF-8");
	%>
		<div>
			<form action="<%=request.getContextPath() %>/OracleOperationServlet?action=cg" method="post">
				<table>
					<tr>
						<td>序号</td>
						<td><input type="text" name="id" value="<%=Integer.parseInt(id) %>" /></td>
					</tr>
					<tr>
						<td>学号</td>
						<td><input type="text" name="num" value="<%=Integer.parseInt(num) %>" /></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" value="<%=name %>" /></td>
					</tr>
					<tr>
						<td>性别</td>
						<td>
							<%
								if(sex.equals("男")){
							%>
									男<input type="radio" name="sex" checked="checked" value="男" />
									女<input type="radio" name="sex" value="女" />
							<% 
								}else{
							%>
									男<input type="radio" name="sex" value="男" />
									女<input type="radio" name="sex" checked="checked"  value="女" />
							<%
								}
							%>
						</td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input type="text" name="age" value="<%=Integer.parseInt(age) %>" /></td>
					</tr>
					<tr>
						<td>毕业学校</td>
						<td><input type="text" name="school" value="<%=school %>" /></td>
					</tr>
					<tr>
						<td align="center">
							<input type="submit" value="更新数据"  >
							<input type="reset" value="重置数据"  >
						</td>
					</tr>
				</table>
			</form>
		</div>
	<%
		}
	%>
	
	
</body>
</html>