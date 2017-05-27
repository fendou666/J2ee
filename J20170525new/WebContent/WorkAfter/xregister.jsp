<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var users={}
	users.$=function(id){
		return document.getElementById(id);
	}
	users.check=function(){
		console.log("0000000");
		users.$("mess").style.display="none";
		if(users.$("user").value==null||users.$("user").value==""){
			users.$("mess").innerText="用户名不能为空";
			users.$("mess").style.display="block";
			users.$("user").focus();
			console.log("11111");
			return false;
		}
		else{
			console.log("22222222");
			return true;
		}
	}
	users.checkSub=function(){
		console.log("我是users.checkSub");
	}
	var xmlhttp;
	function checkUser(){
		if(window.ActiveXObject){
			xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
		else{
			xmlhttp=new XMLHttpRequest();
		}
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4||xmlhttp.status==200){
				alert("==========================");
				console.log("444444444:"+xmlhttp.responseText);
				users.$("mess").style.display="block";
				if(xmlhttp.responseText=="exists"){
					users.$("mess").innerText="该用户名已存在，请重新输入";
				}
				else{
					users.$("mess").innerText="该用户名不存在，可以正常使用";
				}
			}
		}
		var username=users.$("user").value;
		console.log("请求前user:"+username);
		xmlhttp.open("GET","<%=request.getContextPath() %>/CheckUserServlet?user="+username);
		xmlhttp.send(null);
	}
	
	function checkUserSub(){
		console.log("页面请求提交后 user的值"+users.$("user").value);
		console.log("我是checkUserSub");
	}
	function checkUserSuba(){
		alert("3333333");
	}
</script>
<style>
	#bt{
		background-image: url(../img/4.jpg);
		background-size: cover;
		height: 30px;
		width:150px;
		color: blue;
	}
</style>
</head>
<body>
<!-- <div id="mess" style="color:red;display:none"></div> -->
<span id="mess" style="color:red;display:none" >adsf</span>
<form action="" method="post" name="myform">
<!-- <form action="https://www.baidu.com" method="post" name="myform">	 -->		
			用户名：<input type="text" id="user" name="user" /><br>
			<input id="bt" type="submit" name="checkname" value="*检查return true" onclick="return true"/><br>
			<input id="bt" type="submit" name="checkname" value="*检查return submit" onclick="return true,checkUserSuba()"/><br>
			<!-- <input id="bt" type="button" name="checkname" value="*检查button" onclick="users.check(),checkUser()"/><br> -->
			<!-- <input id="bt" type="submit" name="checkname" value="*检查submit" onclick="users.check(),checkUser()"/><br> -->
			<!-- <input id="bt" type="submit" name="checkname" value="*检查return submit" onclick="return users.check(),checkUser(), checkUserSuba()"/><br> -->
			<!-- <input id="bt" type="submit" name="checkname" value="*检查测试" onclick="return users.checkSub(),checkUserSuba(),checkUserSub()"/> -->
			
	</form>
</body>
</html>