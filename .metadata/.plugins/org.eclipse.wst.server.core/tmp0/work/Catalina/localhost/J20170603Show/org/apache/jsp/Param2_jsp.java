/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-06-05 02:13:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class Param2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/cookie.js\" ></script>\r\n");
      out.write("<!-- 更改浏览器的network disable catche true  -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t/* function getAllCookies(){\r\n");
      out.write("\t\tsetCookie(\"user\", \"aaa\");\r\n");
      out.write("\t\tconsole.log(\"user cookie为：\" + getCookie(\"user\"));\r\n");
      out.write("\t\tconsole.log(\"其他不存在 cookie为：[\" + getCookie(\"usera\") + \"]\");\r\n");
      out.write("\t\tconsole.log(\"所有cookie信息\" + document.cookie);\r\n");
      out.write("\t\tconsole.log(\"id cookie为：\" + getCookie(\"id\"));\r\n");
      out.write("\t\t\r\n");
      out.write("\t} */\r\n");
      out.write("\tfunction requestServlet(){\r\n");
      out.write("\t\t");

			request.getRequestDispatcher("TestServlet2").forward(request, response);
		
      out.write("\r\n");
      out.write("\t\t//location.href = \"TestServlet2\"; (两种请求结果不一样？？？)\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body onload=\"getAllCookies(),requestServlet()\">\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
      out.write('	');
 
	
		Enumeration<String> abt = application.getAttributeNames();
		while (abt.hasMoreElements()) {
		   String attribute = (String) abt.nextElement();
		   System.out.println("page2  attribute Name:" + attribute);
		}
	
      out.write("\r\n");
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
