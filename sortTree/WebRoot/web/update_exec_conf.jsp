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
name=request.getParameter("name");
parentId=Integer.parseInt(request.getParameter("parentId"));
if(name.equals("")){
   out.print("<BR>�������Ʋ���Ϊ�գ�");
   out.print("<br><a href=\"update_exec.jsp\">����</a>"); 
   }
else{
	 SortBean.executeUpdate("update mysort set name='"+name+"',parentId="+parentId+" where Id="+Id+"");
	 out.print("<br>�޸ķ���ɹ���");
	 }
SortBean.closeConn();		 
%>
</body>
</html>