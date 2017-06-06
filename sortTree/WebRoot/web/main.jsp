<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*,java.util.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<body>
<%
String year;
String month;
String day;
String week;
Calendar thisMonth=Calendar.getInstance();  //初始化一个日历（当前月）对象
year=String.valueOf(thisMonth.get(Calendar.YEAR));
month=String.valueOf(thisMonth.get(Calendar.MONTH)+1);
day=String.valueOf(thisMonth.get(Calendar.DATE));
int weekNum=thisMonth.get(Calendar.DAY_OF_WEEK);
switch(weekNum)
{
  case 1:{week="日";break;}
  case 2:{week="一";break;}
  case 3:{week="二";break;}
  case 4:{week="三";break;}
  case 5:{week="四";break;}
  case 6:{week="五";break;}
  case 7:{week="六";break;}
  default:week="error";
};
%>	
<br>欢迎使用本系统！
<br><br>今天是 <%=year%>年<%=month%>月<%=day%>日 星期<%=week%>
</body>
</html>
