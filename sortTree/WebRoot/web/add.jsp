<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<html>
	<head>
		<title>���ӷ���</title>
	</head>
<body>
<br>�����������Ϣ��<br>
<center>
<form action="add_exec.jsp" method="post">
<table width="400">
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">�������ƣ�</font></td>
		<td><input type="text" name="name"  size="10" maxlength="6" >(6���ַ�����)</td>
	</tr>
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">�������ࣺ</font></td>
		<td>
			
			<select name="parentId">
				<option value="0" selected="selected">��������</option>
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
		<td align="middle"><input type="submit" value="ȷ��"></td>
		<td><input type="reset" value="����"></td>
	</tr>	
</table>	
</form>	
</center>
</body>
</html>