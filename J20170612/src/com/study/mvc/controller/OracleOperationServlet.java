package com.study.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;

/**
 * Servlet implementation class GetStudentInfoServlet
 */
@WebServlet("/OracleOperationServlet")
public class OracleOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OracleOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		IStudentService studentService = new StudentServiceImp();
		
		if(action==null){
			out.write("请求需要有参数");
		}
		if(action.equals("seachAll")){
			List<StudentInfo> stuList = studentService.getStudentByCondition(11, "", "", 20, 21, "");
			if(stuList!=null){
				// req.getSession().setAttribute("errInfo", "没有获取到数据"); 这个不算错误信息所以不区设置 
				Iterator<StudentInfo> iterator = stuList.iterator();
				request.getSession().setAttribute("stuList", stuList);
			}
			request.getRequestDispatcher("WorkIn/UserList.jsp").forward(request, response);
		}
		
		if(action.equals("seachById")){
			String id = request.getParameter("id");
			if(id==null){
				out.write("没有获取到部分参数");
			}else{
				studentService.getStudentByNum(Integer.parseInt(id));
				// 这里请求sql获取学生信息
				List<StudentInfo> stuList = studentService.getStudentByCondition(11, "", "", 20, 21, "");
				if(stuList==null){
					out.write("没有获取到数据");
					return;
				}
				Iterator<StudentInfo> iterator = stuList.iterator();
				StudentInfo tmp = null;
				request.getSession().setAttribute("stuList", stuList);
				request.getRequestDispatcher("WorkIn/UserList.jsp").forward(request, response);
			}
		}
		if(action.equals("seachByNameXML")){
			System.out.println("进入seachByNameXML");
			String name = request.getParameter("name");
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.write("<students>");
			if(name!=null){
				List<StudentInfo> stuList = studentService.getStudentByName(name);
				if(stuList!=null){
					Iterator<StudentInfo> iterator = stuList.iterator();
					StudentInfo tmp = null;
					while(iterator.hasNext()){
						tmp = iterator.next();
						out.write("<student>");
						out.write(tmp.getId()
								+ "#" + tmp.getNum()
								+ "#" + tmp.getName()
								+ "#" + tmp.getAge()
								+ "#" + tmp.getSex()
								+ "#" + tmp.getSchool()
								);
						out.write("</student>");
					}
				}else{
					out.write("<student>没有获取到数据</student>");
				}
			}else{
				out.write("<student>用户名为空</student>");
			}
			out.write("</students>");
		}
		if(action.equals("seachByNameJSON")){
			System.out.println("进入seachByNameJSON");
			String name = request.getParameter("name");
			out.write("[");
			if(name!=null){
				List<StudentInfo> stuList = studentService.getStudentByName(name);
				if(stuList!=null && stuList.size()>0){
					Iterator<StudentInfo> iterator = stuList.iterator();
					StudentInfo tmp = null;
					while(iterator.hasNext()){
						tmp = iterator.next();
						out.write("{");
						out.write("\"id\":\""+ tmp.getId() +"\"," );
						out.write("\"num\":\""+ tmp.getNum() +"\"," );
						out.write("\"name\":\""+ tmp.getName() +"\"," );
						out.write("\"age\":\""+ tmp.getAge() +"\"," );
						out.write("\"sex\":\""+ tmp.getSex() +"\"," );
						out.write("\"school\":\""+ tmp.getSchool() +"\"" );
						if(!iterator.hasNext()){
							out.write("}");
						}else{
							out.write("},");
						}
					}
				}else{
					System.out.println("没有获取到数据");
				}
			}else{
				System.out.println("用户名为空");
			}
			out.write("]");
		}
		
		
		if(action.equals("cg")){
			out.write("请求删除servlet成功");
			String id = request.getParameter("id");
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String age = request.getParameter("age");
			String school = request.getParameter("school");
			if(id==null||num==null||name==null||sex==null||age==null||school==null){
				out.write("没有获取到部分参数");
			}else{
				StudentInfo stu = new StudentInfo(Integer.parseInt(id), Integer.parseInt(num), name, 
												sex, Integer.parseInt(age), school);
				studentService.saveStudentInfo(stu);
				// 这里请求sql获取学生信息
				List<StudentInfo> stuList = studentService.getStudentByCondition(11, "", "", 20, 21, "");
				Iterator<StudentInfo> iterator = stuList.iterator();
				StudentInfo tmp = null;
				request.getSession().setAttribute("stuList", stuList);
				
				request.getRequestDispatcher("WorkIn/Success.jsp").forward(request, response);
			}
		}
		if(action.equals("del")){
			String num = request.getParameter("delNum");
			if(num == null){
				out.write("请求需要有delNum参数");
			}else{
				studentService.deleteStudentInfo(Integer.parseInt(num));
				
				// 这里请求sql获取学生信息
				List<StudentInfo> stuList = studentService.getStudentByCondition(11, "", "", 20, 21, "");
				Iterator<StudentInfo> iterator = stuList.iterator();
				StudentInfo tmp = null;
				request.getSession().setAttribute("stuList", stuList);
				
				request.getRequestDispatcher("WorkIn/Success.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
