<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<script  type="text/javascript">
		function checkUser(){
			var xmlHttp = null;
			if(window.ActiveXObject){
				xmlHttp = new ActiveXObject("Msxlm2.XMLHTTP"); // 为什么?
			}else{
				xmlHttp = new XMLHttpRequest();
			}
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					console.log("请求结果是"+xmlHttp.responseText);
					if(xmlHttp.responseText=="true"){
						document.getElementById("showErrInfo").innerText = "用户名已存在";
					}else{
						console.log("设置用户检测信息");
						document.getElementById("showErrInfo").innerText = "这个用户名可以注册";
					}
					document.getElementById("showErrInfo").style.display = "inline"; 
				}				
			}
			var sendInfo = "user="+ document.getElementById("user").value;
			xmlHttp.open("post", "<%=request.getContextPath() %>/ALoginServlet");
			// xmlHttp.open("get", "<%=request.getContextPath() %>/ALoginServlet?"+sendInfo);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//var sendInfo = "user="+ document.getElementById("user").value;
			// 这里定义不是String
			console.log(sendInfo);
			xmlHttp.send(sendInfo);
			//xmlHttp.send(null);
		}
	</script>
	<body>
	 <!-- action="#" -->
		<form action="https://www.baidu.com" method="get" target="_self">
			<p>用户名：
				<input type="text" 
						size="20" 
						value="11" 
						name="user"
						id = "user"
						placeholder="只能是纯字母的最长30" 
						maxlength="30"
						autocomplete="on"
						/>
					<span id="showErrInfo" style="color:red;display:none">*</span>
					<input type="button" onclick="checkUser()" value="检查用户" >
						</p>
			<!-- <p>性别：
				<input type="radio" name="sex"  checked="checked" value="man" />男
				<input type="radio" name="sex"  checked="checked" value="women" />女
			</p>
			<p>爱好：
				<input type="checkbox" name="hobby" checked="checked" value="sing" /> 唱歌
				<input type="checkbox" name="hobby"  value="dance" /> 跳舞
				<input type="checkbox" name="hobby"  value="basketball" /> 打篮球
				<input type="checkbox" name="hobby"  checked="checked" value="football" /> 踢足球
			</p>
			<p>户籍所在地：
				<select name="province">
					<option >海南省</option>
					<option selected="selected">陕西省</option>
					<option>上海省</option>
				</select>
				<select name="area">
					<option>渭南市</option>
					<option selected="selected">西安市</option>
					<option>宝鸡市</option>
				</select>
				<select name="county">
					<option>莲湖区</option>
					<option>未央区</option>
					<option>雁塔区</option>
				</select>
			</p>
			<p>现在居住地：
				<select name="nowProvince">
					<option>海南省</option>
					<option selected="selected">陕西省</option>
					<option>上海省</option>
				</select>
				<select name="nowArea">
					<option>渭南市</option>
					<option selected="selected">西安市</option>
					<option>宝鸡市</option>
				</select>
				<select name="nowCounty">
					<option>莲湖区</option>
					<option>未央区</option>
					<option>雁塔区</option>
				</select>
			</p>
			<p>自我评价：
				<textarea name="selfAssessment">
				</textarea>
			</p> -->
			<input type="" name="" id="" value="111" />
			<p>设置密码：<input type="password" /></p>
			<p>确认密码：<input type="password" name="pwd" /></p>
			<p align="center">
				<input type="submit" name="submit" value="提交"   />
				<input type="reset" name="reset" value="重置"  />
				<!-- <input type="image" name="submit" src="img/submit_32px.png" width="40"  />
				<input type="image" name="reset"  src="img/reset_32px.png" width="40" onclick="reset();return false;" /> -->				
				<!--<input type="image" src="img/submit_32px.png" alt="提交" width="40"  border="0"/>
				<input type="image" src="img/reset_32px.png" alt="重置" width="40"  border="0" onclick="reset();return false;" />-->
			</p>
		</form>
	</body>
</html>