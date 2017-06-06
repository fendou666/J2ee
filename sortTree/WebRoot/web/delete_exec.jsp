<html>
	<head>
		<title>删除分类</title>
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
  parentName="顶级分类";
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
<br>您要删除的分类:『<%=name%>』,属『<%=parentName%>』,
<%
   if(children==0){
%>
不存在子分类！
<%
   }
  else {
%>
存在<%=children%>个子分类！
<%}%>
<br>确认删除？<br>
<table>
<tr>
<td>	
<form action="delete_exec_conf.jsp" method="post">
	<input type="hidden" name="Id" value="<%=Id%>">
	<input type="submit" value="删除">
</form>
</td>
<td>
	<form action="main.jsp" method="post">
	<input type="submit" value="取消">
</form>
</td>
</tr>
</table>
</center>
</body>
</html>