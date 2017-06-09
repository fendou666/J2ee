<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function initImgId(){
		document.getElementsByTagName("img").id = "img_02";
		//console.log("img 的图片" + document.getElementById("img_02").scr);
	}
</script>
<body onload="initImgId()">
	<div class="c1" id="msgMain_01">
		<hr style="width: 1000px; height: 1px; background-color: grey; border:0px">
		<div class="imgd">
			<img id="img_01" alt="headImg" width="100px" height="100px" />
		</div>
		<div class="content">
			<p>
				<span class="name" id="name_01"></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="time" id="floor_01" ></span>
			</p>
			<div class="option">
				<ul style="list-style-type: none; ">
					<li  onmouseleave="testHide(ls.$('hide_01'))" onmouseover="testShow(ls.$('hide_01'))">
						<a href="" >▼</a>
						<ul class="hide" id="hide_01" style="display: none;text-align:center;list-style-type: none; margin-left: -60px;border: 1px solid;">
							<li><a  onclick="return deltInfo('msgMain_01')">删除</a></li>
							<li><a  onclick="return changeContent('content_01', 'editeDiv_01', 'editContent_01')">更改</a></li>
						</ul>
					</li>
				</ul>	
			</div>
			<div class="edit" id="editeDiv_01">
				<form action="" method="post">
					<textarea id="editContent_01" name="" rows="10" cols="75">
						
					</textarea>
					<p>
						<input type="submit" value="确认"  onclick="return submitValue('content_01', 'editeDiv_01', 'editContent_01')" />
						<input type="reset" value="取消" />
					</p>
				</form>
			</div>
			<div class="innerContern" id="content_01">
				
			</div>
			<p class="time" id="time_01"></p>
		</div>
	</div>
</body>
</html>

	

