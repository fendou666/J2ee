<html>
	<head>
		<title>ɾ������</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<%
int Id=Integer.parseInt(request.getParameter("Id"));
%>
<%
int deleteCount=SortBean.delete("mysort",Id);   //���ü���ɾ������,����Ϊ���ݱ��ID
SortBean.closeConn();	
%>
<br>ɾ������ɹ���һ��ɾ��<%=deleteCount%>����������࣡
</body>
</html>