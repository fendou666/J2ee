<%@ page contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<script language=javascript> 
setTimeout("document.form1.submit()",0) 
</script>
</head>

<body>

<form id="form1" name="form1" method="post" action="../menu">
  <input type="hidden" name="dsn" value="//127.0.0.1/heyuhao" />
  <input type="hidden" name="user" value="root" />
  <input type="hidden" name="password" value="" />
  <input type="hidden" name="sql" value="select * from mysort" />
</form>
</body>
</html>
