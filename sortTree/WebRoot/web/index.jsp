<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无限级分类目录树管理</title>
</head>
<frameset rows="50,*,20" framespacing="1" frameborder="yes" border="0" bordercolor="#666666">
	<frame src="top.jsp"  frameborder="1" bordercolor="#cccccc" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" />
<frameset rows="*" cols="200,*" id="frame">	
	<frame src="left.jsp" frameborder="1" bordercolor="#cccccc" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="yes" />
	<frame src="main.jsp" frameborder="1" bordercolor="#cccccc" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="yes" />
</frameset>  
  <frame src="bottom.jsp" frameborder="1" bordercolor="#cccccc" noresize="noresize" frameborder="0" name="bottomFrame" scrolling="no" marginwidth="0" marginheight="0" />
<noframes>
	<body></body>
</noframes>
</frameset>

</html>