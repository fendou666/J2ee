package com.study.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.bean.StudentInfo;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;

/**
 * Servlet implementation class GetDataRowsByCondtion
 */
@WebServlet("/GetDataRowsByCondtion")
public class GetDataRowsByCondtion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataRowsByCondtion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========doGet============");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========doPost============");
		//1 设置解码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//请求数据获得
		String findCondition="";
		
		//2 被Ajax请求的流返回  XML
		PrintWriter out = response.getWriter();
		
		findCondition=request.getParameter("stuname");
		if(findCondition!=null){
			IStudentService setudentService=new StudentServiceImp();
			List<StudentInfo> studentAll = setudentService.getStudentsByName(findCondition);
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.write("<students>");
			if(studentAll!=null){
				if(studentAll.size()>0){
					for(StudentInfo x: studentAll){
						out.write("<student>");
						out.write(x.getId() + "#");
						out.write(x.getName() + "#");
						out.write(x.getSex() + "#");
						out.write(x.getAge() + "#");
						out.write(x.getGradeFrom());
						out.write("</student>");
					}
				}
				else{
					out.write("<student>没有符合条件的学员！！</student>");
				}
			}
			else{
				out.write("<student>没有符合条件的学员！！</student>");
			}
			out.write("</students>");
		}
		else{
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.write("<students>");
			out.write("<student>没有符合条件的学员！！</student>");
			out.write("</students>");
		}
	}

}
