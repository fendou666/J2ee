<%@ page language="java" import="java.util.ArrayList,com.chinasofti.study.*,java.util.Iterator" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<td>留言标题</td>
			<td>留言用户</td>
			<td>留言内容</td>
			<td>留言时间</td>
		</tr>
		
			<%
				ArrayList<Message> msgList = (ArrayList<Message>)application.getAttribute("msg");
				if(msgList==null){
					out.write("<tr><td clospan='4'>用户提交留言服务端设置属性失败</td></tr>");
				}else{
					/* Iterator<Message> iterator = msgList.iterator();
					while(iterator.hasNext()){
						out.write("<td>" + iterator.next().getTitle() + "</td>");
						out. write("<td>" + iterator.next().getUser().getName() + "</td>");
						out.write("<td>" + iterator.next().getContent() + "</td>");
						out.write("<td>" + iterator.next().getMsgTime() + "</td>");
					}	 */
					System.out.println(msgList.size());
					for(Message m: msgList){
						out.write("<tr><td>" + m.getTitle() + "</td>");
						out. write("<td>" + m.getUser().getName() + "</td>");
						out.write("<td>" + m.getContent() + "</td>");
						out.write("<td>" + m.getMsgTime() + "</td></tr>");
					}
				}
			%>
		
		
	</table>
</body>
</html>