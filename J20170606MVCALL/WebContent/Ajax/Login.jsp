<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	#login {
		position: absolute;
		left: 50%;
		top: 35%;
		width:600px;
		height:100px;
		margin-left:-300px;
		/* margin-top:-50px; */
		
	}
	table {
		width: 300px;
		margin: auto;
		border: 2px solid blue;
	}
</style>
<script type="text/javascript" src="../Myjs/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#submitB").click(function(){
			$.get(){
				
			}			
			
		})
		
	})
</script>

<body>
	<div id="login">
		<form id="myFM" action="<%=request.getContextPath() %>/LoginServlet" method="post">
			<table >
				<tr>
					<td>用户名:</td>
					<td>
						<input type="text" required="required" name="userName" id="userName" placeholder="输入用户名" >
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
						<input type="password" required="required" name="pwd" id="pwd" placeholder="输入密码" >
					</td>
				</tr>	
				<tr>
					<td colspan="2" align="center">
						<input type="button" id="submitB" value="登陆"  >
						<input type="button" value="重置" onclick="myFM.reset()"  >
						<button onclick="" >注册</button>
					</td>
				</tr>
			</table>
		</form>	
	</div>
	<div>
		<p style="color:red"></p>
	</div>
	
</body>
</html>