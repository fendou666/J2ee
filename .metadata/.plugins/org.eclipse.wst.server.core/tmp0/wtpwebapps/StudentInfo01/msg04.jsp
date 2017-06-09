<%@page import="com.chinasofti.student.javabean.MsgListNeed"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.chinasofti.student.javabean.MsgList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
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
		var ls = {};
		ls.$ = function(id){
			return document.getElementById(id);
		}
		function testShow(elmt){
			elmt.style.display="block";
		}
		function testHide(elmt){
			elmt.style.display="none";
		}
		function deltInfo(id){
			ls.$(id).style.display="none";
			return false;
		}
		function changeContent(sourceContentId, editeDivId, editeContentId){
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
	<body>
		<%
			ArrayList<MsgListNeed> msgList = new ArrayList<MsgListNeed>();
			
			msgList.add(new MsgListNeed(1, 170000002, "老师1", "01.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(2, 170000003, "老师2", "02.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(3, 170000004, "老师3", "03.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(4, 170000001, "老师4", "04.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(5, 170000001, "老师4", "05.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(6, 170000001, "老师4", "06.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(7, 170000001, "老师4", "07.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(8, 170000001, "老师4", "08.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(9, 170000001, "老师4", "09.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(10, 170000001, "老师4", "10.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			msgList.add(new MsgListNeed(11, 170000001, "老师4", "11.jpg",
					"标题1", "对于你，我始终只能以陌生人的身份去怀念", new Date()));
			request.setAttribute("msgList", msgList);
			request.setAttribute("msgListLength", msgList.size());
			String indexStr = request.getParameter("index");
			int index = 0;
			System.out.println("index 为" +indexStr);
			if(indexStr!=null){
				index = Integer.parseInt(indexStr);
			}
			request.setAttribute("msgIndex", index);
		%>
	
		<div id="show">
			
			<c:forEach var="tmp" items="${requestScope.msgList}" varStatus="iid" begin="${requestScope.msgIndex }" end="${requestScope.msgIndex +9}">
				<div class="c1" id="msgMain_${iid.index +1}">
					<hr style="width: 1000px; height: 1px; background-color: grey; border:0px">
					<div class="imgd">
						<img id="img_0${iid.index +1}" src="img/${tmp.img }"  alt="headImg" width="100px" height="100px" />
					</div>
					<div class="content">
						<p>
							<span class="name" id="name_${iid.index +1}">${tmp.name }</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span class="time" id="floor_${iid.index +1}" >第${tmp.msgId }楼</span>
						</p>
						<div class="option">
							<ul style="list-style-type: none; ">
								<li  onmouseleave="testHide(ls.$('hide_${iid.index +1}'))" onmouseover="testShow(ls.$('hide_${iid.index +1}'))">
									<a href="" >▼</a>
									<ul  class="hide" id="hide_${iid.index +1}" style="display: none;text-align:center;list-style-type: none; margin-left: -60px;border: 1px solid;">
										<li><a  onclick="return deltInfo('msgMain_${iid.index +1}')">删除</a></li>
										<li><a  onclick="return changeContent('content_${iid.index +1}', 'editeDiv_${iid.index +1}', 'editContent_${iid.index +1}')">更改</a></li>
									</ul>
								</li>
							</ul>	
						</div>
						<div class="edit" id="editeDiv_${iid.index +1}">
							<form action="" method="post">
								<textarea id="editContent_${iid.index +1}" name="" rows="10" cols="75">
									${tmp.msgContent  }
								</textarea>
								<p>
									<input type="submit" value="确认"  onclick="return submitValue('content_${iid.index +1}', 'editeDiv_${iid.index +1}', 'editContent_${iid.index +1}')" />
									<input type="reset" value="取消" />
								</p>
							</form>
						</div>
						<div class="innerContern" id="content_${iid.index +1}">
							${tmp.msgContent  }
						</div>
						<p class="time" id="time_${iid.index +1}"></p>
					</div>
					
					<c:if test="${ iid.index == requestScope.msgListLength-1}">
						<hr style="width: 1000px; height: 3px; background-color: gainsboro; border:0px">
					</c:if>
					 
					<c:if test="${requestScope.msgIndex < requestScope.msgListLength && iid.index%10 == 9 }">
						<hr style="width: 1000px; height: 3px; background-color: gainsboro; border:0px">
					</c:if>
				</div>
			</c:forEach>
			<c:if test="${requestScope.msgListLength > requestScope.msgIndex +10}">
				<a href="msg04.jsp?index=${requestScope.msgIndex +10}">下一页</a>
			</c:if>
		</div>
		
	</body>
</html>