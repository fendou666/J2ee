<html>
	<head>
		<title>修改分类</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<br>选择要修改的分类：<br>
<center>
<form action="update_exec.jsp" method="post">
<table width="400">
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">分类名称：</font></td>
		<td>
			
			<select name="Id">
				<option value="0" selected="selected">--请选择--</option>
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
		<td align="middle"><input type="submit" value="下一步"></td>
	</tr>
</table>	
</form>	
</center>
</body>
</html>