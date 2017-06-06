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
name=request.getParameter("name");
parentId=Integer.parseInt(request.getParameter("parentId"));
if(name.equals("")){
   out.print("<BR>分类名称不能为空！");
   out.print("<br><a href=\"update_exec.jsp\">返回</a>"); 
   }
else{
	 SortBean.executeUpdate("update mysort set name='"+name+"',parentId="+parentId+" where Id="+Id+"");
	 out.print("<br>修改分类成功！");
	 }
SortBean.closeConn();		 
%>
</body>
</html>