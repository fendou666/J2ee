<html>
	<head>
		<title>增加分类</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%request.setCharacterEncoding("gb2312");%>  <%--此步骤非常关键，如果不设置，传入MySQL的数据将会出现乱码--%>
<%@ include file="conn.jsp"%>
<%
String name;
int parentId;
%>
<%
name=request.getParameter("name");
parentId=Integer.parseInt(request.getParameter("parentId"));
if(name.equals("")){
   out.print("<BR>分类名称不能为空！");
   out.print("<br><a href=\"add.jsp\">返回</a>"); 
   }
else{
	 SortBean.executeUpdate("insert into mysort(name,parentId) values('"+name+"',"+parentId+")");
	 out.print("<br>添加分类成功！");
	 }
SortBean.closeConn();	 
%>
</body>
</html>