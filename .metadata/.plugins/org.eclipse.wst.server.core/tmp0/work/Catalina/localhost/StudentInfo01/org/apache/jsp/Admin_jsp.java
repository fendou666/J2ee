/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-06-14 15:12:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.chinasofti.eecuser.model.javabean.UserInfo;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fitems.release();
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
      out.write("<link id=\"mycss\" href=\"css/add.css\" rel=\"stylesheet\" type=\"text/css\"/> \r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction getCustomPageIndex(){\r\n");
      out.write("\t\t// TODO \r\n");
      out.write("\t\t//return $('pageIndex').val(); // 为什么这种不可以\r\n");
      out.write("\t\treturn document.getElementById(\"pageIndex\").value;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction showInfo(){\r\n");
      out.write("\t\tconsole.log(\"roleId :\" + $(\"#roleId\").val());\r\n");
      out.write("\t\tconsole.log(\"classId :\" + $(\"#classId\").val());\r\n");
      out.write("\t\tconsole.log(\"eecId :\" + $(\"#eecId\").val());\r\n");
      out.write("\t\tconsole.log(\"eecName :\" + $(\"#eecName\").val());\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction showHtml(id){\r\n");
      out.write("\t\tconsole.log(document.getElementById(id).innerHTML);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getEecUserInfo(forward){\r\n");
      out.write("\t\tshowInfo();\r\n");
      out.write("\t\t$.post(\r\n");
      out.write("\t\t\t\t\"");
      out.print(request.getContextPath());
      out.write("/AdminServlet\",\t\t\t\t\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\taction:forward,\r\n");
      out.write("\t\t\t\t\troleId:$(\"#roleId\").val(),\r\n");
      out.write("\t\t\t\t\tclassId:$(\"#classId\").val(),\r\n");
      out.write("\t\t\t\t\teecId:$(\"#eecId\").val(),\r\n");
      out.write("\t\t\t\t\teecName:$(\"#eecName\").val()\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tfunction(data){\r\n");
      out.write("\t\t\t\t\t//console.log(\"数据解析支持成功\");\r\n");
      out.write("\t\t\t\t\tvar eecUsers = eval(data);\r\n");
      out.write("\t\t\t\t\tvar htmlData = \"\";\r\n");
      out.write("\t\t\t\t\thtmlData +=\t'<tr bgcolor=\"#8FBC8F\">';\r\n");
      out.write("\t\t\t\t\thtmlData += '<td>序号</td><td>班级</td><td>学号</td><td>姓名</td><td>性别</td>';\r\n");
      out.write("\t\t\t\t\thtmlData += '<td>年龄</td><td>邮箱</td><td>手机号</td><td>职务</td><td colspan=\"3\">操作</td>';\r\n");
      out.write("\t\t\t\t\thtmlData += '</tr>';\r\n");
      out.write("\t\t\t\t\tif(eecUsers == null || eecUsers.length == 0){\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"<tr >\";\r\n");
      out.write("\t\t\t\t\t\thtmlData += '<td colspan=\"12\">没有获取到数据</td>';\r\n");
      out.write("\t\t\t\t\t\thtmlData += \"</tr>\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$.each(eecUsers ,function(i){\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<tr id=\\\"usd\" + (i+1) + \"\\\">\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + (i+1)  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].classId  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].id  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].name  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].sex  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].age  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].email  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].telephone  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td>\" + eecUsers[i].roleName  +\"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\t//htmlData += '<td><a href=\"#\" onclick=\"showHtml(\\'usd' +(i+1)+ '\\')\">增加</a></td>';\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += '<td><a href=\"#\" onclick=\"showHtml(\\'t2\\')\">增加</a></td>';\r\n");
      out.write("\t\t\t\t\t\t\t//htmlData += \"<td><a href=\\\"");
      out.print(request.getContextPath() );
      out.write("/OracleOperationServlet?action=seachById&id=\"+ eecUsers[i].id +\"\\\">增加</a></td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td><a href=\\\"");
      out.print(request.getContextPath() );
      out.write("/OracleOperationServlet?action=seachById&id=\"+ eecUsers[i].id +\"\\\">修改</a></td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"<td><a href=\\\"");
      out.print(request.getContextPath() );
      out.write("/OracleOperationServlet?action=del&delNum=\"+ eecUsers[i].id +\"\\\">删除</a></td>\";\r\n");
      out.write("\t\t\t\t\t\t\thtmlData += \"</tr>\";\r\n");
      out.write("\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getStuInfo(\\'first\\')\" value=\"首页\" ></td>';\r\n");
      out.write("\t\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getStuInfo(\\'pre\\')\" value=\"前页\" ></td>';\r\n");
      out.write("\t\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getStuInfo(\\'next\\')\" value=\"次页\" ></td>';\r\n");
      out.write("\t\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"button\"  onclick=\"getStuInfo(\\'last\\')\" value=\"尾页\" ></td>';\r\n");
      out.write("\t\t\t\t\t\thtmlData +=  '<td colspan=\"2\"><input type=\"number\" id=\"pageIndex\">';\r\n");
      out.write("\t\t\t\t\t\thtmlData +=  '<input type=\"button\" onclick=\"getEecUserInfo(getCustomPageIndex())\" value=\"指定页\" ></td>';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$(\"#t2\").html(htmlData);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"JSON\"\r\n");
      out.write("\t\t\t);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#query\").click(function(){\r\n");
      out.write("\t\t\tgetEecUserInfo(\"getQuery\");\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
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
      out.write("\t\t\t<div id=\"d31\"><a href=\"#\">个人基本信息管理</a></div>\r\n");
      out.write("\t\t\t<div id=\"d32\"><a href=\"#\">权限管理</a></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"d4\">\r\n");
      out.write("\t\t\t<div id=\"d41\">学生信息查询</div>\r\n");
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
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;学号：<input type=\"text\"  name=\"eecId\" value=\"\"></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;姓名：<input type=\"text\" name=\"eecName\" value=\"\"></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;<input type=\"button\" id=\"query\" name=\"query\" value=\"查 询\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<table id=\"t2\" border=\"1\">\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#8FBC8F\">\r\n");
      out.write("\t\t\t\t\t<td>序号</td><td>班级</td><td>学号</td><td>姓名</td><td>性别</td>\r\n");
      out.write("\t\t\t\t\t<td>年龄</td><td>邮箱</td><td>手机号</td><td>职务</td><td colspan=\"3\">操作</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td><td></td><td></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<!-- <tr id=\"usd3\">\r\n");
      out.write("\t\t\t\t\t<td>3</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3classId\" id=\"usd3classId\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3id\" id=\"usd3id\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3name\" id=\"usd3name\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3sex\" id=\"usd3sex\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3age\" id=\"usd3age\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3email\" id=\"usd3email\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3telephone\" id=\"usd3telephone\"></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usd3roleName\" id=\"usd3roleName\"></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">添加</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">删除</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\">修改</a></td>\r\n");
      out.write("\t\t\t\t</tr> -->\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /Admin.jsp(142,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems("");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
