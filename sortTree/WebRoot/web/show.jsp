<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<html>
<body>
<%@ include file="conn.jsp"%>
<%
int Id=Integer.parseInt(request.getParameter("Id"));
ResultSet rs=SortBean.executeQuery("select * from mysort where Id="+Id+"");
rs.next();
String name=rs.getString("name");
out.print("\n<table>\n<tr>\n");
out.print("<td bgcolor=\"#9900FF\"><font color=\"#ffffff\">�������ƣ�</font></td>\n");
out.print("<td bgcolor=\"#9900FF\"><font color=\"#ffffff\">"+name+"</font></td>\n");
out.print("<td align=middle><a href=\"update_exec.jsp?Id="+Id+"\">�޸�</a>|<a href=\"delete_exec.jsp?Id="+Id+"\">ɾ��</a></td>\n");
out.print("\n</tr>\n</table>\n");
%>	
<%
out.print("<br>���������Ϣ��������������������");
%>
</body>
</html>	