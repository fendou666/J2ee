<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*,java.util.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
</head>
<body>
<%
String year;
String month;
String day;
String week;
Calendar thisMonth=Calendar.getInstance();  //��ʼ��һ����������ǰ�£�����
year=String.valueOf(thisMonth.get(Calendar.YEAR));
month=String.valueOf(thisMonth.get(Calendar.MONTH)+1);
day=String.valueOf(thisMonth.get(Calendar.DATE));
int weekNum=thisMonth.get(Calendar.DAY_OF_WEEK);
switch(weekNum)
{
  case 1:{week="��";break;}
  case 2:{week="һ";break;}
  case 3:{week="��";break;}
  case 4:{week="��";break;}
  case 5:{week="��";break;}
  case 6:{week="��";break;}
  case 7:{week="��";break;}
  default:week="error";
};
%>	
<br>��ӭʹ�ñ�ϵͳ��
<br><br>������ <%=year%>��<%=month%>��<%=day%>�� ����<%=week%>
</body>
</html>
