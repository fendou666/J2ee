/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-05-24 06:25:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WorkAfter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\tdiv {\r\n");
      out.write("\t\twidth:300px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv form {\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*\r\n");
      out.write("INSERT INTO userInfo VALUES(1, '小明', 'aaaa');\r\n");
      out.write("INSERT INTO userInfo VALUES(2, '小红', 'bbbb');\r\n");
      out.write("INSERT INTO userInfo VALUES(3, '小强', 'cccc');\r\n");
      out.write("INSERT INTO userInfo VALUES(4, '小李', 'dddd');\r\n");
      out.write("INSERT INTO userInfo VALUES(5, '小军', 'eeee');\r\n");
      out.write("*/\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar ls\t=\t{};\r\n");
      out.write("\tvar errMsg = \"\";\r\n");
      out.write("\tvar userElmt\t= null;\r\n");
      out.write("\tvar pwdElmt\t\t= null;\r\n");
      out.write("\tvar cUserElmt\t= null;\r\n");
      out.write("\tvar cPwdElmt\t= null;\r\n");
      out.write("\tvar showErrElmt = null;\r\n");
      out.write("\tfunction dataInit(){\r\n");
      out.write("\t\tuserElmt\t= ls.$(\"userName\");\r\n");
      out.write("\t\tpwdElmt\t\t= ls.$(\"pwd\");\r\n");
      out.write("\t\tcUserElmt\t= ls.$(\"checkUser\");\r\n");
      out.write("\t\tcPwdElmt\t= ls.$(\"checkPwd\");\r\n");
      out.write("\t\tshowErrElmt = ls.$(\"showErr\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tls.$\t=\tfunction(id){\r\n");
      out.write("\t\treturn document.getElementById(id);\r\n");
      out.write("\t}\r\n");
      out.write("\tls.checkData = function(elmt){\r\n");
      out.write("\t\tvar rec = true;\r\n");
      out.write("\t\tvar eValue = elmt.value;\r\n");
      out.write("\t\tif(eValue==null || eValue==\"\"){\r\n");
      out.write("\t\t\trec = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn rec;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tls.addErrorInfo = function(crtElmt, warnElmt, errInfoElmt, crtName){\r\n");
      out.write("\t\tvar rec = false;\r\n");
      out.write("\t\tif(!ls.checkData(crtElmt)){\r\n");
      out.write("\t\t\terrMsg += crtName+\"不能为空   \";\r\n");
      out.write("\t\t\twarnElmt.style.display = \"inline\";\r\n");
      out.write("\t\t\terrInfoElmt.style.display = \"block\";\r\n");
      out.write("\t\t\trec = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn rec;\r\n");
      out.write("\t}\r\n");
      out.write("\tls.checkAllInit = function(){\r\n");
      out.write("\t\terrMsg\t= \"\";\r\n");
      out.write("\t\tcUserElmt.style.display\t\t= \"none\";\r\n");
      out.write("\t\tcPwdElmt.style.display\t\t= \"none\";\r\n");
      out.write("\t\tshowErrElmt.style.display\t= \"none\";\r\n");
      out.write("\t}\r\n");
      out.write("\tls.checkAllData = function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar rec\t= true;\r\n");
      out.write("\t\tls.checkAllInit();\r\n");
      out.write("\t\tif(ls.addErrorInfo(userElmt, cUserElmt, showErrElmt, \"用户名\") | \r\n");
      out.write("\t\t\t\tls.addErrorInfo(pwdElmt, cPwdElmt, showErrElmt, \"密码\")\r\n");
      out.write("\t\t\t){\r\n");
      out.write("\t\t\tshowErrElmt.innerText = errMsg;\r\n");
      out.write("\t\t\trec = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn rec;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- <script type='text/javascript'>\r\n");
      out.write("\tfunction initPageInfo(){\r\n");
      out.write("\t\tdocument.getElementById('userName').value = \" + userName +\";\r\n");
      out.write("\t\tdocument.getElementById('pwd').value = \" + pwd + \"\r\n");
      out.write("\t}\r\n");
      out.write("</script> -->\r\n");
      out.write("\r\n");
      out.write("<body onload=\"dataInit(), initPageInfo()\">\r\n");
      out.write("\t");

		Cookie [] cks = request.getCookies();
		if(cks!=null){
			String userName = null;
			String pwd = null;
			for(Cookie c:cks){
				if(c.getName().equals("user")){
					userName = URLDecoder.decode(c.getValue());
				}
				if(c.getName().equals("pwd")){
					pwd = c.getValue();
				}
			}
			out.write("<script type='text/javascript'>function initPageInfo(){document.getElementById('userName').value = '"
						+ userName +"';document.getElementById('pwd').value = '" 
						+ pwd + "'}</script>");			
		} 
	
      out.write("\r\n");
      out.write("\t<div id=\"divfm\">\r\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/ALoginServlet\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>用户名：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"userName\" id=\"userName\" />\r\n");
      out.write("\t\t\t\t\t\t<span id=\"checkUser\" style=\"color:red; display:none\">*</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>密码：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"pwd\" id=\"pwd\" />\r\n");
      out.write("\t\t\t\t\t\t<span id=\"checkPwd\" style=\"color:red; display:none\">*</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"提交\" onclick=\"return ls.checkAllData()\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"reset\" value=\"重置\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"showErr\" style=\"display:none;color:red\"></div>\r\n");
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