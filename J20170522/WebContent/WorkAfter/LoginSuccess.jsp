<%@ page language="java" import="java.util.HashSet,com.chinasofti.study.*,java.util.Iterator,java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		<!-- TODO 关于几种请求与href的区别 -->
		<a href="Logout.jsp">注销</a>
		<a href="Login.jsp">退出</a>
	</div>
	<div id="d2">
		<!-- 这里既可以更改为服务端记录，也可以在当前页面记录 -->
		<form action="<%=request.getContextPath() %>/AMsgServlet" method="post">
			<table>
				<tr>
					<td>留言标题</td>
					<td><input type="text" name="title"  /></td>
				</tr>		
				<tr>
					<td>用户名</td>
					<td><%=((UserInfo)application.getAttribute("user")).getName() %></td>
				</tr>	
				<tr>
					<td>留言内容</td>
					<td><textarea name="msgContent" rows="20" cols="50">111</textarea>  </td>
				</tr>	
				<tr>
					<td>留言时间</td>
					<td><input type="text" name="time" value="<%=(new Date().toString()) %>" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" value="提交" />
						<input type="reset" value="重置" />
					</td>
				</tr>	
			</table>	
		</form>
	</div>
	
</body>
</html>