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
			out.write("������Ҫ�в���");
		}
		if(action.equals("cg")){
			request.getRequestDispatcher("WorkIn/UpdateInfo.jsp").forward(request, response);
		}
		if(action.equals("del")){
			String num = request.getParameter("delNum");
			if(num == null){
				out.write("������Ҫ��delNum����");
			}else{
				studentService.deleteStudentInfo(Integer.parseInt(num));
				
				// ��������sql��ȡѧ����Ϣ
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