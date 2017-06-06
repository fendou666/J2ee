<html>
	<head>
		<title>删除分类</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<%
int Id=Integer.parseInt(request.getParameter("Id"));
%>
<%
int deleteCount=SortBean.delete("mysort",Id);   //调用级联删除函数,参数为数据表和ID
SortBean.closeConn();	
%>
<br>删除分类成功！一共删除<%=deleteCount%>个相关连分类！
</body>
</html>