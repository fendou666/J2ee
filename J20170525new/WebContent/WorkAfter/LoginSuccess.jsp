<%@ page language="java" import="java.util.HashSet,com.exercise.java.*,java.util.Iterator,java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	sesstionID<%=request.getSession().getId() %>
		<div id="d1">
			<table border="1px">
				<tr>
					<td>在线用户</td>
				</tr>
				<%
					HashSet<UserInfo> userSet = (HashSet<UserInfo>)application.getAttribute("userSet");
					if(userSet==null){
						out.write("<tr><td>用户登陆服务端设置属性失败</td></tr>");
					}else{
						Iterator<UserInfo> iterator = userSet.iterator();
						while(iterator.hasNext()){
							out.write("<tr><td>" + iterator.next().getName() + "</td></tr>");
						}				
					}
				%>
			</table>
		</div>
</body>
</html>