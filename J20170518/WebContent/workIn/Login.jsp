<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<% 
		Cookie [] ck = request.getCookies();
		String user = null;
		String pwd = null;
		String errInfo = null;
		for (Cookie c: ck) {
			if(c.getName().equals("user")){
				user = URLDecoder.decode(c.getValue(), "UTF-8") ;
				System.out.println(user);
				System.out.println("cookie用户名 :" +new String(user.getBytes("ISO-8859-1"), "UTF-8"));
			}
			if(c.getName().equals("pwd")){
				pwd = URLDecoder.decode(c.getValue(), "UTF-8") ;
				System.out.println("cookiepwd:" +pwd);
			}
			if(c.getName().equals("errInfo")){
				errInfo = URLDecoder.decode(c.getValue(), "UTF-8") ;
				System.out.println("cookie错误信息 :" +errInfo);
			}
		}
		/* if(user!=null || (user!=null&& !user.equals(""))){
			
			if(pwd!=null || (pwd!=null&& !pwd.equals(""))){
				out.write("<script type='text/javascript'>document.getElementById('user').value =" 
						+ user +";document.getElementById('pwd').value =" 
						+ pwd + ";document.getElementById('errInfo').innerText="
						+ errInfo
						+ ";document.getElementById('errInfo').style.display = 'inline';</script>");
				out.write("document.getElementById('user').value ='" 
						+ user +"'"); 
				System.out.println("进入。。。。。。");
			}else {
				out.write("<script type='text/javascript'>document.getElementById('errInfo').innerText='"
						+ errInfo
						+ "';document.getElementById('errInfo').style.display = 'inline';</script>");
			}
		} */
	%> 
	<%
			/* else {
				out.write("function errInfoAdd(){document.getElementById('errInfo').innerText='"
						+ errInfo
						+ "';document.getElementById('errInfo').style.display = 'inline';}");
			} */
	%>

	<div id="errInfo"></div>
	<form action="<%=request.getContextPath() %>/MyServlet" method="get">
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="user" id="user" />
					<span id="checkUser" style="color:red; display:none">*</span>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="text" name="pwd" id="pwd" />
					<span id="checkPwd" style="color:red; display:none">*</span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交" />
				</td>
				<td>
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>