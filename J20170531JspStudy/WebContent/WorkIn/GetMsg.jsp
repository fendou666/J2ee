<%@page import="java.util.Iterator"%>
<%@page import="com.study.jspJava.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>标题</td>
			<td>用户名</td>
			<td>内容</td>
			<td>时间</td>
		</tr>
		<%
			List<Message> msgList = (List<Message>)application.getAttribute("msgInfo");
			System.out.println("msgList" + msgList);
			if(msgList!=null){
				/* Iterator<Message> iterator = msgList.iterator();
				while(iterator.hasNext()){
					Message msg = iterator.next();
					out.write("<tr><td>"
					+msg.getTitle() + "</td><td>"
					+msg.getName() + "</td><td>"
					+msg.getContent() +"</td><td>"
					+msg.getDate() +"</td></tr>");
				} */
				for(int i=0; i<msgList.size(); i++){
					Message msg = msgList.get(i);
					out.write("<tr><td>"
					+msg.getTitle() + "</td><td>"
					+msg.getName() + "</td><td>"
					+msg.getContent() +"</td><td>"
					+msg.getDate() +"</td></tr>");
				}
				
			}else{
				out.write("<tr><td clospan='4'>没有收到留言</td></tr>");
			}
			
		%>
	</table>
</body>
</html>