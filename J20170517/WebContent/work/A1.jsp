<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var ls = {};
	ls.errInfo = "";
	
	ls.$ = function(id){
		return document.getElementById(id);
	}
	ls.init = function(){
		ls.$("checkUser").style.display = none;
		ls.$("checkPwd").style.display = none;
		ls.$("errInfo").style.display = none;
	}
	ls.checkData = function(element, checkElement, errInfoElement, inputText){
		var rec = true;
		if(element.value==null || element.value==""){
			checkElement.style.display = "inline";
			errInfoElement.style.display = "block";
			ls.errInfo += inputText + "不可以为空";
			rec = false;			
		}
		return rec;
	}
	ls.checkAllData = function(){
		var rec = true;
		ls.errInfo = "";
		if(!ls.checkData(ls.$("user"), ls.$("checkUser"), ls.$("errInfo"), "用户名")
			| !ls.checkData(ls.$("pwd"), ls.$("checkPwd"), ls.$("errInfo"), "密码")){
			rec = false;
			ls.$("errInfo").innerText = ls.errInfo;
		}
		return rec;
	}
	ls.sendRequest = function(){
		if(!ls.checkAllData()){
			<%-- location.href = "<%=request.getContextPath() %>/AS1"; --%>
			/* 总结：当是a标签的时候与是否有返回值无关，至于是否定义location.href有关 */
			return false;
		}else {
			var user = ls.$("user").value;
			var pwd = ls.$("pwd").value;
			location.href = "<%=request.getContextPath() %>/AS1?user="
							+ user + "&pwd=" + pwd;
			return true;
		}
	}
	
	/* a标签方式只能通过get超级连接方式传值否则值不可传递 */
	ls.sendRequestA = function(){
		if(!ls.checkAllData()){
			<%-- location.href = "<%=request.getContextPath() %>/AS1"; --%>
			/* 总结：当是a标签的时候与是否有返回值无关，与是否定义location.href有关 */
			/* 如果是href赋值方式跳转 
				1. 无return 一直会跳转
				2. 有return return false不跳转， return true跳转
			*/
			<%-- document.getElementById("ar").href = "<%=request.getContextPath() %>/AS1";
			document.getElementById("a").href = "<%=request.getContextPath() %>/AS1"; --%>
			return false;
		}else {
			var user = ls.$("user").value;
			var pwd = ls.$("pwd").value;
			<%-- location.href = "<%=request.getContextPath() %>/AS1"; --%>
			document.getElementById("ar").href = "<%=request.getContextPath() %>/AS1?user="
												+ user + "&pwd=" + pwd;
			document.getElementById("a").href = "<%=request.getContextPath() %>/AS1?user="
												+ user + "&pwd=" + pwd;
			return true;
		}
	}
	
	ls.sendRequestB = function(){
		/*button标签的与renturn有关  */
		if(!ls.checkAllData()){
			return false;
		}else {
			var user = ls.$("user").value;
			var pwd = ls.$("pwd").value;
			document.forms["myFM"].action = "<%=request.getContextPath() %>/AS1?user="
											+ user + "&pwd=" + pwd;
			document.forms["myFM"].submit();
			return true;
		}
	}

</script>


<body>
	<form id="myFM" action="<%=request.getContextPath() %>/AS1" method="get">
	
		<span>用户名：</span>
		<input type="text" name="user"  id="user" /> 
		<span id="checkUser" style="color:red;display:none">*</span>
		<br>
		<span>密码：</span>
		<input type="password" name="pwd" id="pwd" /> 
		<span id="checkPwd" style="color:red;display:none">*</span>
		<br>
		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
		<a id="ar"  onclick="return ls.sendRequestA()">超级链接提交return</a>
		<a id="a"  onclick="ls.sendRequestA()">超级链接提交</a>
		<button onclick="return ls.sendRequestB()"> 按钮提交return </button>
		<button onclick="ls.sendRequestB()"> 按钮提交</button>
		<br>
		<p id="errInfo" style="color:red;display:none"></p>
	</form>
</body>
</html>