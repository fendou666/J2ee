<html>
	<head>
		<title>ɾ������</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<%
int Id;
String name;
int parentId;
int children;
String parentName;
%>
<%
Id=Integer.parseInt(request.getParameter("Id"));

ResultSet rs=SortBean.executeQuery("select * from mysort where Id="+Id+"");
rs.next();
name=rs.getString("name");
parentId=rs.getInt("parentId");
rs.close();

ResultSet rs1=SortBean.executeQuery("select * from mysort where Id="+parentId+"");
rs1.next();
if((rs1.getRow())==0)
  parentName="��������";
else{    
  parentName=rs1.getString("name");
}
rs1.close();

ResultSet rs2=SortBean.executeQuery("select * from mysort where parentId="+Id+"");
rs2.last();
children=rs2.getRow();
rs2.close();
%>
<center>
<br>��Ҫɾ���ķ���:��<%=name%>��,����<%=parentName%>��,
<%
   if(children==0){
%>
�������ӷ��࣡
<%
   }
  else {
%>
����<%=children%>���ӷ��࣡
<%}%>
<br>ȷ��ɾ����<br>
<table>
<tr>
<td>	
<form action="delete_exec_conf.jsp" method="post">
	<input type="hidden" name="Id" value="<%=Id%>">
	<input type="submit" value="ɾ��">
</form>
</td>
<td>
	<form action="main.jsp" method="post">
	<input type="submit" value="ȡ��">
</form>
</td>
</tr>
</table>
</center>
</body>
</html>