<html>
	<head>
		<title>�޸ķ���</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%request.setCharacterEncoding("gb2312");%>  <%--�˲���ǳ��ؼ�����������ã�����MySQL�����ݽ����������--%>
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
<br>���޸ķ�����Ϣ��<br>
<center>
<form action="update_exec_conf.jsp" method="post">
<table width="400">
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">�������ƣ�</font></td>
		<td><input type="text" name="name" value="<%=name%>"  size="10" maxlength="6" >(6���ַ�����)</td>
	</tr>
	<tr>
		<td bgcolor=#9900FF><font color="#ffffff">�������ࣺ</font></td>
		<td>
			<select name="parentId">
				<option value="0">��������</option>
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
		<td align="middle"><input type="submit" value="ȷ��"></td>
		<td><input type="reset" value="����"></td>
	</tr>	
</table>	
</form>	
</center>
</body>
</html>
