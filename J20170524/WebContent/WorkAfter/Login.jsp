<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	div {
		margin:0, auto;
	}
</style>
<script type="text/javascript">
/*
INSERT INTO userInfo VALUES(1, '小明', 'aaaa'); 00
INSERT INTO userInfo VALUES(2, '小红', 'bbbb'); 01
INSERT INTO userInfo VALUES(3, '小强', 'cccc'); 02 
INSERT INTO userInfo VALUES(4, '小李', 'dddd'); 03
INSERT INTO userInfo VALUES(5, '小军', 'eeee'); 02
*/
</script>

<script type="text/javascript">
	var ls	=	{};
	var errMsg = "";
	var userElmt	= null;
	var pwdElmt		= null;
	var cUserElmt	= null;
	var cPwdElmt	= null;
	var showErrElmt = null;
	function dataInit(){
		userElmt	= ls.$("userName");
		pwdElmt		= ls.$("pwd");
		cUserElmt	= ls.$("checkUser");
		cPwdElmt	= ls.$("checkPwd");
		showErrElmt = ls.$("showErr");
	}
	
	ls.$	=	function(id){
		return document.getElementById(id);
	}
	ls.checkData = function(elmt){
		var rec = true;
		var eValue = elmt.value;
		if(eValue==null || eValue==""){
			rec = false;
		}
		return rec;
	}
	
	ls.addErrorInfo = function(crtElmt, warnElmt, errInfoElmt, crtName){
		var rec = false;
		if(!ls.checkData(crtElmt)){
			errMsg += crtName+"不能为空   ";
			warnElmt.style.display = "inline";
			errInfoElmt.style.display = "block";
			rec = true;
		}
		return rec;
	}
	ls.checkAllInit = function(){
		errMsg	= "";
		cUserElmt.style.display		= "none";
		cPwdElmt.style.display		= "none";
		showErrElmt.style.display	= "none";
	}
	ls.checkAllData = function(){
		
		var rec	= true;
		ls.checkAllInit();
		if(ls.addErrorInfo(userElmt, cUserElmt, showErrElmt, "用户名") | 
				ls.addErrorInfo(pwdElmt, cPwdElmt, showErrElmt, "密码")
			){
			showErrElmt.innerText = errMsg;
			rec = false;
		}
		return rec;		
	}
</script>
<!-- <script type='text/javascript'>
	function initPageInfo(){
		document.getElementById('userName').value = " + userName +";
		document.getElementById('pwd').value = " + pwd + "
	}
</script> -->

<body onload="dataInit(), initPageInfo()">
	<%-- <%
		Cookie [] cks = request.getCookies();
		if(cks!=null){
			String userName = null;
			String pwd = null;
			for(Cookie c:cks){
				if(c.getName().equals("user")){
					userName = URLDecoder.decode(c.getValue());
				}
				if(c.getName().equals("pwd")){
					pwd = c.getValue();
				}
			}
			out.write("<script type='text/javascript'>function initPageInfo(){document.getElementById('userName').value = '"
						+ userName +"';document.getElementById('pwd').value = '" 
						+ pwd + "'}</script>");			
		} 
	%> --%>
	<div id="divfm">
		<form action="<%=request.getContextPath() %>/ALoginServlet" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td>
						<input type="text" name="userName" id="userName" />
						<span id="checkUser" style="color:red; display:none">*</span>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td>
						<input type="password" name="pwd" id="pwd" />
						<span id="checkPwd" style="color:red; display:none">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="提交" onclick="return ls.checkAllData()" />
					</td>
					<td>
						<input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="showErr" style="display:none;color:red"></div>
</body>
</html>