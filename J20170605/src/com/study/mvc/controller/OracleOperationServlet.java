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
