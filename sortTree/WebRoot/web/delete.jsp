<html>
	<head>
		<title>ɾ������</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<br>ѡ��Ҫɾ���ķ��ࣺ<br>
<center>
<form action="delete_exec.jsp" method="post">
<table width="400">
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">�������ƣ�</font></td>
		<td>
			
			<select name="Id">
				<option value="0" selected="selected">--��ѡ��--</option>
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
		<td align="middle"><input type="submit" value="��һ��"></td>
	</tr>
</table>	
</form>	
</center>
</body>
</html>