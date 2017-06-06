<html>
	<head>
		<title>修改分类</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%request.setCharacterEncoding("gb2312");%>  <%--此步骤非常关键，如果不设置，传入MySQL的数据将会出现乱码--%>
<%@ include file="conn.jsp"%>
<%
int Id;
String name;
int parentId;
%>
<%
Id=Integer.parseInt(request.getParameter("Id"));
ResultSet rs=SortBean.executeQuery("select * from mysort where Id="+Id+"");
rs.next();
name=rs.getString("name");
parentId=rs.getInt("parentId");
%>
<br>请修改分类信息：<br>
<center>
<form action="update_exec_conf.jsp" method="post">
<table width="400">
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">分类名称：</font></td>
		<td><input type="text" name="name" value="<%=name%>"  size="10" maxlength="6" >(6个字符以内)</td>
	</tr>
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">所属分类：</font></td>
		<td>
			<select name="parentId">
				<option value="0">顶级分类</option>
				<%
				 rs=SortBean.executeQuery("select * from mysort"); 
				 while(rs.next())
				 {
				   int Id2=rs.getInt("Id");
				   name=rs.getString("name");
				   if(Id2==parentId){
				      %>
				      <option value="<%=Id2%>" selected="selected"><%=name%></option>
				      <%}
				   else {  
				   %>
				   <option value="<%=Id2%>"><%=name%></option>
				   <%
				 }
				 }
				%>
			</select>
		</td>
	</tr>
	<tr>
		<input type="hidden" name="Id" value="<%=Id%>">
		<td align="middle"><input type="submit" value="确认"></td>
		<td><input type="reset" value="重置"></td>
	</tr>	
</table>	
</form>	
</center>
</body>
</html>
