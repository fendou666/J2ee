/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-05-24 00:52:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WorkAfter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashSet;
import com.chinasofti.study.*;
import java.util.Iterator;
import java.util.Date;

public final class LoginSuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"d1\">\r\n");
      out.write("\t\t<table border=\"1px\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>在线用户</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				HashSet<UserInfo> userSet = (HashSet<UserInfo>)application.getAttribute("userSet");
				if(userSet==null){
					out.write("<tr><td>用户登陆服务端设置属性失败</td></tr>");
				}else{
					Iterator<UserInfo> iterator = userSet.iterator();
					while(iterator.hasNext()){
						out.write("<tr><td>" + iterator.next().getName() + "</td></tr>");
					}				
				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<!-- TODO 关于几种请求与href的区别 -->\r\n");
      out.write("\t\t<a href=\"Logout.jsp\">注销</a>\r\n");
      out.write("\t\t<a href=\"Login.jsp\">退出</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"d2\">\r\n");
      out.write("\t\t<!-- 这里既可以更改为服务端记录，也可以在当前页面记录 -->\r\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/AMsgServlet\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>留言标题</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"title\"  /></td>\r\n");
      out.write("\t\t\t\t</tr>\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>用户名</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(((UserInfo)application.getAttribute("user")).getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>留言内容</td>\r\n");
      out.write("\t\t\t\t\t<td><textarea name=\"msgContent\" rows=\"20\" cols=\"50\">111</textarea>  </td>\r\n");
      out.write("\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>留言时间</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"time\" value=\"");
      out.print((new Date().toString()) );
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" align=\"center\"> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"提交\" />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"reset\" value=\"重置\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t</table>\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
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