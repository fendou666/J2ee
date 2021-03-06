<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function changeImg(){
		// 这里最后必须加上math.random， 不然只会请求一次，系统认为访问过的属性不会再次访问
		// 就可那个纸牌设置了反转属性一样，没有变就只有效一次
		document.getElementById("authImg").src = "<%=request.getContextPath() %>/CreateImg?rand="+Math.random();
	}

	function checkAuthCode(){
		var xmlHttp;
		if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}else{
			xmlHttp = new XMLHttpRequest();
		}
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
				// 返回值0代表验证不通过，1代表通过
				if(xmlHttp.responseText=="0"){
					document.getElementById("showErrInfo").style.display="inline";
					document.getElementById("showErrInfo").style.color="red";
					document.getElementById("showErrInfo").innerText="认证不通过";
				}else{
					document.getElementById("showErrInfo").style.display="inline";
					document.getElementById("showErrInfo").style.color="green";
					document.getElementById("showErrInfo").innerText="认证通过";
				}				
			}
		}
		var authCode = document.getElementById("authCode").value;
		xmlHttp.open("get", "<%=request.getContextPath() %>/CheckImgAuthCode?authCode=" + authCode);
		xmlHttp.send(null);
	}
</script>
<body>
	<p>
		<span>验证码:</span>
		<input type="text" name="authCode" id="authCode" />
		<img src="../CreateImg" id="authImg" onclick="changeImg()" />
		<span id="showErrInfo" style="display: none">*</span>
		<input type="button" value="验证码检查" onclick="checkAuthCode()" />
	</p>
</body>
</html>