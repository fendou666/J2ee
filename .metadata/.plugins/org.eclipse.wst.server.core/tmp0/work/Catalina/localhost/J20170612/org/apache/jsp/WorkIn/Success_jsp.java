/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-06-12 09:47:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WorkIn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import com.study.mvc.model.javabean.StudentInfo;
import java.util.List;

public final class Success_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\tdiv {\r\n");
      out.write("\t\twidth:800px;\r\n");
      out.write("\t\tposition:absolute;\r\n");
      out.write("\t\tleft: 50%;\r\n");
      out.write("\t\tmargin-left:-400px;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable {\r\n");
      out.write("\t\twidth: 800px;\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t\tborder: 2px solid blue;\r\n");
      out.write("\t\tborder-collapse: collapse;\r\n");
      out.write("\t}\r\n");
      out.write("\ttd {\r\n");
      out.write("\t\tborder: 1px solid blue;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		StudentInfo stu = (StudentInfo)session.getAttribute("stu");
		if(stu!=null){
			out.write("用户名：" + stu.getName());
		}else{
			request.getRequestDispatcher("NoLogin.jsp").forward(request, response);
			return;
		}
		String msg = (String)session.getAttribute("errInfo");
		if(msg!=null){
			session.removeAttribute("errInfo");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table id=\"tb\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>序号</td>\r\n");
      out.write("\t\t\t\t<td>学号</td>\r\n");
      out.write("\t\t\t\t<td>姓名</td>\r\n");
      out.write("\t\t\t\t<td>性别</td>\r\n");
      out.write("\t\t\t\t<td>年龄</td>\r\n");
      out.write("\t\t\t\t<td>毕业院校</td>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\">操作</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 
				List<StudentInfo> stuList = (List<StudentInfo>)session.getAttribute("stuList");
				if(stuList==null){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"6\">没有获取到信息</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
 
				}else{
					Iterator<StudentInfo> iterator = stuList.iterator();
					StudentInfo tmp = null;
					while(iterator.hasNext()){
						tmp = iterator.next();
							out.write("<tr><td>"+tmp.getId()+"</td>"
							+"<td>"+tmp.getNum()+"</td>"
							+ "<td>"+tmp.getName()+"</td>"
							+ "<td>"+tmp.getSex()+"</td>"
							+ "<td>"+tmp.getAge()+"</td>"
							+ "<td>"+tmp.getSchool()+"</td>"
							// 关于这里能不能考虑将指针传过去， 能不能通过设置一个ID然后将一行参数进行传递
							+ "<td><a href="+ request.getContextPath() + "/OracleOperationServlet?action=seachById&id="+ tmp.getId() + ">修改</a></td>"
							+ "<td><a href="+ request.getContextPath() + "/OracleOperationServlet?action=del&delNum="+ tmp.getId() + ">删除</a></td></tr>");
					}
				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
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
