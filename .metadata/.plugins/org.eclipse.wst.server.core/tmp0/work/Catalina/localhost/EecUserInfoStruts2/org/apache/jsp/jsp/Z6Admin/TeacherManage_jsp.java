/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-06-20 01:11:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP.Z6Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.chinasofti.eecuser.model.javabean.UserInfo;

public final class TeacherManage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link id=\"mycss\" href=\"../../css/add.css\" rel=\"stylesheet\" type=\"text/css\"/> \r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar action = \"AdminTheacherQueryAction\";\r\n");
      out.write("\tfunction getMainQueryHtml(){\r\n");
      out.write("\t\treturn ");
      out.print(session.getAttribute("teacherListJson") );
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getEecUserInfo(action, forward){\r\n");
      out.write("\t\t$.post(\r\n");
      out.write("\t\t\taction,\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tsqlPageMapKey:\"teacherPage\",  \r\n");
      out.write("\t\t\t\tpageIndex: forward, // 页面跳转参数\r\n");
      out.write("\t\t\t\troleId:$(\"#roleId\").val(),\r\n");
      out.write("\t\t\t\tclassId:$(\"#classId\").val(),\r\n");
      out.write("\t\t\t\tid:$(\"#id\").val(),\r\n");
      out.write("\t\t\t\tname:$(\"#name\").val()\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tfunction(data){\r\n");
      out.write("\t\t\t\tvar teacherList = getMainQueryHtml();\r\n");
      out.write("\t\t\t\tvar eecUsers = eval(teacherList);\r\n");
      out.write("\t\t\t\tvar htmlData = \"\";\r\n");
      out.write("\t\t\t\thtmlData +=\t'<tr bgcolor=\"#8FBC8F\">';\r\n");
      out.write("\t\t\t\thtmlData += '<td>序号</td><td>班级</td><td>学号</td><td>姓名</td><td>性别</td>';\r\n");
      out.write("\t\t\t\thtmlData += '<td>年龄</td><td>邮箱</td><td>手机号</td><td>职务</td>';\r\n");
      out.write("\t\t\t\thtmlData += '</tr>';\r\n");
      out.write("\t\t\t\tif(eecUsers == null || eecUsers.length == 0){\r\n");
      out.write("\t\t\t\t\thtmlData += \"<tr >\";\r\n");
      out.write("\t\t\t\t\thtmlData += '<td colspan=\"12\">没有获取到数据</td>';\r\n");
      out.write("\t\t\t\t\thtmlData += \"</tr>\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$.each(eecUsers ,function(i){\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<tr id=\\\"usd\" + (i+1) + \"\\\">\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + (i+1)  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].classId  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].id  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].name  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].sex  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].age  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].email  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].telephone  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].roleName  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\tif(operationType == \"delete\"){\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td><a href=\\\"\" + servlet +\"?action=deleteTheacher&id=\"+ eecUsers[i].id +\"\\\">修改</a></td>\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tif(operationType == \"update\"){\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td><a href=\\\"\" + servlet +\"?action=deleteTheacher&id=\"+ eecUsers[i].id +\"\\\">删除</a></td>\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"</tr>\";\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getEecUserInfo(\\''+servlet +'\\',\\'first\\')\" value=\"首页\" ></td>';\r\n");
      out.write("\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getEecUserInfo(\\''+servlet +'\\',\\'pre\\')\" value=\"前页\" ></td>';\r\n");
      out.write("\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getEecUserInfo(\\''+servlet +'\\',\\'next\\')\" value=\"次页\" ></td>';\r\n");
      out.write("\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getEecUserInfo(\\''+servlet +'\\',\\'last\\')\" value=\"尾页\" ></td>';\r\n");
      out.write("\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"number\" id=\"pageIndex\">';\r\n");
      out.write("\t\t\t\t\thtmlData +=  '<input type=\"button\" onclick=\"getEecUserInfo(getCustomPageIndex())\" value=\"指定页\" ></td>';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#t2\").html(htmlData);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t)\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#query\").click(function(){\r\n");
      out.write("\t\t\tgetEecUserInfo(action, \"first\");\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		final int ADMIN_ROLEID = 3006;
		
		// 登录信息暂时没有的情况，自己先做一个数据保证程序运行
		UserInfo stu = new UserInfo(20170207, 170000002, "管理员", "男",
				88,  "4437074544@qq.com", 11593239991L, 3006);
		session.setAttribute("userInfo", stu);
		UserInfo admin = (UserInfo)session.getAttribute("userInfo");
		if(admin==null){
			//request.getRequestDispatcher("NoLogin.jsp").forward(request, response);
			return;
		}
		// 这一步判断可以去掉，肖梦娜使用过滤器做， 对应的权限只能访问对应的目录
		if(admin.getRoleId()!=ADMIN_ROLEID){
			//request.getRequestDispatcher("NoLogin.jsp").forward(request, response);
			return;	
		}
	
      out.write("\r\n");
      out.write("\t<div id=\"d0\">\r\n");
      out.write("\t\t<h1>学生信息综合管理系统</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"d1\">\r\n");
      out.write("\t\t<div id=\"d2\">&nbsp;&nbsp;&nbsp;当前用户:学生\r\n");
      out.write("\t\t<div id=\"d21\">\r\n");
      out.write("\t\t\t<a href=\"#\">首页</a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<a href=\"#\">退出登录</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"d3\">\r\n");
      out.write("\t\t\t<div id=\"d31\"><a href=\"#\">个人信息</a></div>\r\n");
      out.write("\t\t\t<div id=\"d32\"><a href=\"#\">班级管理</a></div>\r\n");
      out.write("\t\t\t<div id=\"d33\"><a href=\"#\">教师信息查看</a></div>\r\n");
      out.write("\t\t\t<div id=\"d34\"><a href=\"#\">添加教师</a></div>\r\n");
      out.write("\t\t\t<div id=\"d35\"><a href=\"#\">罢免教师</a></div>\r\n");
      out.write("\t\t\t<div id=\"d36\"><a href=\"#\">教师信息更改</a></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"d4\">\r\n");
      out.write("\t\t\t<div id=\"d41\">教师信息查询</div>\r\n");
      out.write("\t\t\t<table id=\"t1\" >\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>职位：\r\n");
      out.write("\t\t\t\t\t\t<select name=\"roleId\" id=\"roleId\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"postAll\">全部</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"3004\">任课老师</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"3005\">班主任</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>班级：\r\n");
      out.write("\t\t\t\t\t\t<select name=\"classId\" id=\"classId\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"classAll\">全部</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"20170207\">java0207</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"20170208\">java0208</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;学号：<input type=\"text\"  name=\"id\" value=\"\"></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;姓名：<input type=\"text\" name=\"name\" value=\"\"></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;<input type=\"button\" id=\"query\" name=\"query\" value=\"查 询\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<table id=\"t2\" border=\"1\">\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#8FBC8F\">\r\n");
      out.write("\t\t\t\t\t<td>序号</td><td>班级</td><td>学号</td><td>姓名</td><td>性别</td>\r\n");
      out.write("\t\t\t\t\t<td>年龄</td><td>邮箱</td><td>手机号</td><td>职务</td><td>操作</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}