<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>留言板</title>
	</head>
	<script type="text/javascript">
		var msgList = [
			{
				title:'111',
				headImg: 'img/1.jpg',
				name:'小明',
				content:'我是留言1',
				time: '2017-06-07 8:00'
			},
			{
				title:'111',
				name:'小红',
				headImg: 'img/2.jpg',
				content:'我是留言2',
				time: '2017-06-07 8:11'
			},
			{
				title:'111',
				name:'小强',
				headImg: 'img/3.jpg',
				content:'我是留言2',
				time: '2017-06-07 8:22'
			},
			{
				title:'111',
				name:'小芳',
				headImg: 'img/4.jpg',
				content:'我是留言3',
				time: '2017-06-07 8:33'
			}
		]
		
		var ls = {};
		ls.$ = function(id){
			return document.getElementById(id);
		}
		ls.forLength = msgList.length>10?10:msgList.length;
		ls.initImgInfo = function(){
			var imgId = "";
			for(var i=1; i<=ls.forLength;i++){
				imgId = "img_0" + i;
				if(i>9){
					imgId = "img_" + i;
				}
				console.log(imgId);
				if(ls.$(imgId)==null || ls.$(imgId) == ""){
					return;
				}
				ls.$(imgId).src = msgList[i-1].headImg;
				console.log(ls.$(imgId).src);
			}
		}
		ls.initNameInfo = function(){
			var nameId = "";
			for(var i=1; i<=ls.forLength;i++){
				nameId = "name_0" + i;
				if(i>9){
					nameId = "name_" + i;
				}
				if(ls.$(nameId)==null || ls.$(nameId) == ""){
					return;
				}
				ls.$(nameId).innerText = msgList[i-1].name;
			}
		}
		ls.initFloorInfo = function(){
			var floorId = "";
			for(var i=1; i<=ls.forLength;i++){
				floorId = "floor_0" + i;
				if(i>9){
					floorId = "floor_" + i;
				}
				if(ls.$(floorId)==null || ls.$(floorId) == ""){
					return;
				}
				ls.$(floorId).innerText = '第'+i+'楼';
			}
		}
		
		ls.initContentInfo = function(){
			var contentId = "";
			for(var i=1; i<=ls.forLength;i++){
				contentId = "content_0" + i;
				if(i>9){
					contentId = "content_" + i;
				}
				if(ls.$(contentId)==null || ls.$(contentId) == ""){
					return;
				}
				ls.$(contentId).innerText = msgList[i-1].content;
			}
		}
		
		ls.initTimeInfo = function(){
			var timeId = "";
			for(var i=1; i<=ls.forLength;i++){
				timeId = "time_0" + i;
				if(i>9){
					timeId = "time_" + i;
				}
				if(ls.$(timeId)==null || ls.$(timeId) == ""){
					return;
				}
				ls.$(timeId).innerText = msgList[i-1].time;
			}
		}
		
		ls.initInfo = function(){
			ls.initImgInfo();
			ls.initNameInfo();
			ls.initFloorInfo();
			ls.initContentInfo();
			ls.initTimeInfo();
		}
		function testShow(elmt){
			elmt.style.display="block";
		}
		function testHide(elmt){
			elmt.style.display="none";
		}
		function showAllMsg(){
			for(var i=0; i<msgList.length;i++){
				console.log("name为:" + msgList[i].name);
			}
		}
		function deltInfo(id){
			var num =  id.indexOf('msgMain_');
			console.log("num为" + num);
			if(num!=-1){
				var msgIndex = parseInt(id.substring(num+'msgMain_'.length, id.length));
				console.log("msg index 为" + msgIndex);
				if(msgList[msgIndex-1]){
					//msgList.splice(msgIndex,1);
					msgList[msgIndex-1] = null;
				}
				//showAllMsg();
				ls.$(id).style.display="none";
			}
			return false;
		}
		function changeContent(sourceContentId, editeDivId, editeContentId){
			var value = ls.$(sourceContentId).innerText;
			ls.$(editeContentId).value = value;
			ls.$(editeDivId).style.display = 'block';
			ls.$(sourceContentId).style.display = 'none';
		}
		function submitValue(sourceContentId, editeDivId, editeContentId){
			var value = ls.$(editeContentId).value;
			ls.$(sourceContentId).innerText = value;
			ls.$(sourceContentId).style.display = 'block';
			ls.$(editeDivId).style.display = 'none';
			return false;
		}
	
	</script>
	<link rel="stylesheet" type="text/css" href="css/content.css"/>
	<body onload="ls.initInfo()">
		<div id="show">
			<!-- <div class="c1" id="msgMain_01">
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
			</div> -->
			<%-- <c:import url="msgOne.jsp" >
				<c:param name="index" value="img_01"></c:param>
			</c:import> --%>
			<%-- <c:import url="msgOne1.jsp" >
				<c:param name="index" value="img_01"></c:param>
			</c:import> --%>
			<%-- <jsp:include page="msgOne.jsp"></jsp:include> --%>
			<%-- <jsp:include page="msgOne1.jsp"></jsp:include> --%>
			<%-- <%@ include file="msgOne.jsp" %> --%>
			<%@ include file="msgOne1.jsp" %>
			<div class="c1" id="msgMain_10">
				<hr style="width: 1000px; height: 1px; background-color: grey; border:0px">
				<div class="imgd">
					<img id="img_10" alt="headImg" width="100px" height="100px" />
				</div>
				<div class="content">
					<p>
						<span class="name" id="name_10"></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="time" id="floor_10" ></span>
					</p>
					<div class="option">
						<ul style="list-style-type: none; ">
							<li  onmouseleave="testHide(ls.$('hide_10'))" onmouseover="testShow(ls.$('hide_10'))">
								<a href="" >▼</a>
								<ul  class="hide" id="hide_10" style="display: none;text-align:center;list-style-type: none; margin-left: -60px;border: 1px solid;">
									<li><a  onclick="return deltInfo('msgMain_10')">删除</a></li>
									<li><a  onclick="return changeContent('content_10', 'editeDiv_10', 'editContent_10')">更改</a></li>
								</ul>
							</li>
						</ul>	
					</div>
					<div class="edit" id="editeDiv_10">
						<form action="" method="post">
							<textarea id="editContent_10" name="" rows="10" cols="75">
								
							</textarea>
							<p>
								<input type="submit" value="确认"  onclick="return submitValue('content_10', 'editeDiv_10', 'editContent_10')" />
								<input type="reset" value="取消" />
							</p>
						</form>
					</div>
					<div class="innerContern" id="content_10">
						
					</div>
					<p class="time" id="time_10"></p>
				</div>
				<hr style="width: 1000px; height: 3px; background-color: gainsboro; border:0px">
			</div>
				
		</div>
	</body>
</html>