<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String str1 = "1111";
		String str2 = "ssaf111";
		String str3 = null;
		String str4 = "";
		request.setAttribute("str1", str1);
		request.setAttribute("str2", str2);
		request.setAttribute("str3", str3);
		request.setAttribute("str4", str4);
	%>
	${requestScope.str1 + 2 }; <br>
	<%-- ${requestScope.str2 + 2 };  --%> <!-- 这种情况直接报错 -->
	[${requestScope.str3}]; <br>
	
	判断空1：${empty requestScope.str1}; <br>
	判断空2：${empty requestScope.str2}; <br>
	判断空3：${empty requestScope.str3}; <br>
	判断空4：${empty requestScope.str4}; <br>
	<%-- 判断空4：${requestScope.str4 empty}; <br> --%> <!-- empty必须放在表达式前面,不然报错 -->
	${requestScope.str1 eq 1111 }; <br>
	
	
</body>
</html>