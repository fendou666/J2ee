<html>
	<head>
		<title>���ӷ���</title>
	</head>
<body>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<%request.setCharacterEncoding("gb2312");%>  <%--�˲���ǳ��ؼ�����������ã�����MySQL�����ݽ����������--%>
<%@ include file="conn.jsp"%>
<%
String name;
int parentId;
%>
<%
name=request.getParameter("name");
parentId=Integer.parseInt(request.getParameter("parentId"));
if(name.equals("")){
   out.print("<BR>�������Ʋ���Ϊ�գ�");
   out.print("<br><a href=\"add.jsp\">����</a>"); 
   }
else{
	 SortBean.executeUpdate("insert into mysort(name,parentId) values('"+name+"',"+parentId+")");
	 out.print("<br>��ӷ���ɹ���");
	 }
SortBean.closeConn();	 
%>
</body>
</html>