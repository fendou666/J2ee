/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-05-27 07:15:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WorkAfter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title></title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<script  type=\"text/javascript\">\n");
      out.write("\t\tfunction checkUser(){\r\n");
      out.write("\t\t\tvar xmlHttp = null;\r\n");
      out.write("\t\t\tif(window.ActiveXObject){\r\n");
      out.write("\t\t\t\txmlHttp = new ActiveXObject(\"Msxlm2.XMLHTTP\"); // 为什么?\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\txmlHttp = new XMLHttpRequest();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\txmlHttp.onreadystatechange = function(){\r\n");
      out.write("\t\t\t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"请求结果是\"+xmlHttp.responseText);\r\n");
      out.write("\t\t\t\t\tif(xmlHttp.responseText==\"true\"){\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"showErrInfo\").innerText = \"用户名已存在\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"设置用户检测信息\");\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"showErrInfo\").innerText = \"这个用户名可以注册\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"showErrInfo\").style.display = \"inline\"; \r\n");
      out.write("\t\t\t\t}\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar sendInfo = \"user=\"+ document.getElementById(\"user\").value;\r\n");
      out.write("\t\t\txmlHttp.open(\"post\", \"");
      out.print(request.getContextPath() );
      out.write("/ALoginServlet\");\r\n");
      out.write("\t\t\t// xmlHttp.open(\"get\", \"");
      out.print(request.getContextPath() );
      out.write("/ALoginServlet?\"+sendInfo);\r\n");
      out.write("\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\r\n");
      out.write("\t\t\t//var sendInfo = \"user=\"+ document.getElementById(\"user\").value;\r\n");
      out.write("\t\t\t// 这里定义不是String\r\n");
      out.write("\t\t\tconsole.log(sendInfo);\r\n");
      out.write("\t\t\txmlHttp.send(sendInfo);\r\n");
      out.write("\t\t\t//xmlHttp.send(null);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t <!-- action=\"#\" -->\r\n");
      out.write("\t\t<form action=\"https://www.baidu.com\" method=\"get\" target=\"_self\">\r\n");
      out.write("\t\t\t<p>用户名：\r\n");
      out.write("\t\t\t\t<input type=\"text\" \r\n");
      out.write("\t\t\t\t\t\tsize=\"20\" \r\n");
      out.write("\t\t\t\t\t\tvalue=\"11\" \r\n");
      out.write("\t\t\t\t\t\tname=\"user\"\r\n");
      out.write("\t\t\t\t\t\tid = \"user\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"只能是纯字母的最长30\" \r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"30\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"on\"\r\n");
      out.write("\t\t\t\t\t\t/>\r\n");
      out.write("\t\t\t\t\t<span id=\"showErrInfo\" style=\"color:red;display:none\">*</span>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" onclick=\"checkUser()\" value=\"检查用户\" >\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t<!-- <p>性别：\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"sex\"  checked=\"checked\" value=\"man\" />男\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"sex\"  checked=\"checked\" value=\"women\" />女\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>爱好：\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobby\" checked=\"checked\" value=\"sing\" /> 唱歌\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobby\"  value=\"dance\" /> 跳舞\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobby\"  value=\"basketball\" /> 打篮球\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobby\"  checked=\"checked\" value=\"football\" /> 踢足球\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>户籍所在地：\r\n");
      out.write("\t\t\t\t<select name=\"province\">\r\n");
      out.write("\t\t\t\t\t<option >海南省</option>\r\n");
      out.write("\t\t\t\t\t<option selected=\"selected\">陕西省</option>\r\n");
      out.write("\t\t\t\t\t<option>上海省</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"area\">\r\n");
      out.write("\t\t\t\t\t<option>渭南市</option>\r\n");
      out.write("\t\t\t\t\t<option selected=\"selected\">西安市</option>\r\n");
      out.write("\t\t\t\t\t<option>宝鸡市</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"county\">\r\n");
      out.write("\t\t\t\t\t<option>莲湖区</option>\r\n");
      out.write("\t\t\t\t\t<option>未央区</option>\r\n");
      out.write("\t\t\t\t\t<option>雁塔区</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>现在居住地：\r\n");
      out.write("\t\t\t\t<select name=\"nowProvince\">\r\n");
      out.write("\t\t\t\t\t<option>海南省</option>\r\n");
      out.write("\t\t\t\t\t<option selected=\"selected\">陕西省</option>\r\n");
      out.write("\t\t\t\t\t<option>上海省</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"nowArea\">\r\n");
      out.write("\t\t\t\t\t<option>渭南市</option>\r\n");
      out.write("\t\t\t\t\t<option selected=\"selected\">西安市</option>\r\n");
      out.write("\t\t\t\t\t<option>宝鸡市</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"nowCounty\">\r\n");
      out.write("\t\t\t\t\t<option>莲湖区</option>\r\n");
      out.write("\t\t\t\t\t<option>未央区</option>\r\n");
      out.write("\t\t\t\t\t<option>雁塔区</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>自我评价：\r\n");
      out.write("\t\t\t\t<textarea name=\"selfAssessment\">\r\n");
      out.write("\t\t\t\t</textarea>\r\n");
      out.write("\t\t\t</p> -->\r\n");
      out.write("\t\t\t<input type=\"\" name=\"\" id=\"\" value=\"111\" />\r\n");
      out.write("\t\t\t<p>设置密码：<input type=\"password\" /></p>\r\n");
      out.write("\t\t\t<p>确认密码：<input type=\"password\" name=\"pwd\" /></p>\r\n");
      out.write("\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"submit\" value=\"提交\"   />\r\n");
      out.write("\t\t\t\t<input type=\"reset\" name=\"reset\" value=\"重置\"  />\r\n");
      out.write("\t\t\t\t<!-- <input type=\"image\" name=\"submit\" src=\"img/submit_32px.png\" width=\"40\"  />\r\n");
      out.write("\t\t\t\t<input type=\"image\" name=\"reset\"  src=\"img/reset_32px.png\" width=\"40\" onclick=\"reset();return false;\" /> -->\t\t\t\t\r\n");
      out.write("\t\t\t\t<!--<input type=\"image\" src=\"img/submit_32px.png\" alt=\"提交\" width=\"40\"  border=\"0\"/>\r\n");
      out.write("\t\t\t\t<input type=\"image\" src=\"img/reset_32px.png\" alt=\"重置\" width=\"40\"  border=\"0\" onclick=\"reset();return false;\" />-->\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
