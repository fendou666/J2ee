<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String ret = (String)request.getAttribute("reqRst");
		System.out.println("提交留言信息结果"+ret);
		if(ret!=null){
			out.write("<div style=\"color:red;\">" + ret +"</div>");
		}
	%>
	<form action="Msg.jsp" method="post">
		<p>
			<span>留言标题</span>
			<input type="text" name="title" id="title" required="required" />
		</p>
		<p>
			<span>用户</span>
			<input type="text" name="name" id="name" required="required" />
		</p>
		<p>
			<span>留言内容</span>
			<textarea rows="20" cols="50" name="content" id="content">
			
			</textarea>
		</p>
		<p>
			<input type="submit" value="提交留言" />
		</p>
	</form>
	<a href="GetMsg.jsp">查看留言</a>
</body>
</html>