<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
	display: table-row;
}

.row div {
	display: table-cell;
}

.col1 {
	width: 100px;
}

.col2 {
	width: 200px;
}

.col3 {
	width: 300px;
}
</style>
</head>
<body>
	<form action="login">
		<div class="row">
			<div class="col1">username:</div>
			<div class="col2">
				<input type="text" name="uname" />
			</div>
		</div>
		<div class="row">
			<div class="col1">password:</div>
			<div class="col2">
				<input type="password" name="psd" />
			</div>
		</div>
		<div class="col3">
			<div align="right">
				<input type="submit" name="method:login" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="method:login" value="取消" />
			</div>
		</div>
	</form>
</body>
</html>