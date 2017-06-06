<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<html>
	<head>
		<title>增加分类</title>
	</head>
<body>
<br>请输入分类信息：<br>
<center>
<form action="add_exec.jsp" method="post">
<table width="400">
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">分类名称：</font></td>
		<td><input type="text" name="name"  size="10" maxlength="6" >(6个字符以内)</td>
	</tr>
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">所属分类：</font></td>
		<td>
			
			<select name="parentId">
				<option value="0" selected="selected">顶级分类</option>
				<%
				 ResultSet rs=SortBean.executeQuery("select * from mysort"); 
				 while(rs.next())
				 {
				   int Id=rs.getInt("Id");
				   String name=rs.getString("name");
				   %>
				   <option value="<%=Id%>"><%=name%></option>
				   <%
				 }
				%>
			</select>
			
		</td>
	</tr>
	<tr>
		<td align="middle"><input type="submit" value="确认"></td>
		<td><input type="reset" value="重置"></td>
	</tr>	
</table>	
</form>	
</center>
</body>
</html>