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

import org.apache.catalina.connector.Request;

import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.ILoginService;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.LoginServiceImp;
import com.study.mvc.model.service.StudentServiceImp;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//0 定义区
		String UserInfo = null;
		String userName = null;
		String pwd = null;
		int ret = 0;		
		//1. 转码区
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		//2. 获取参数数据区
		userName = req.getParameter("userName");
		pwd = req.getParameter("pwd");
		//3. 参数验证区
		if(userName==null||userName.equals("") || pwd==null || pwd.equals("")){
			req.getSession().setAttribute("errInfo", "用户名或者密码不能为空");
			ret = 1;
		}else{
			ILoginService loginService = new LoginServiceImp();
			StudentInfo stu = new StudentInfo();
			stu.setName(userName);
			stu = loginService.checkLoginInfo(stu, pwd);
			System.out.println(stu);
			if(stu!=null && userName.equals(stu.getName())){
				ret = 0;
				req.getSession().setAttribute("stu", stu);
				
				// 这里请求sql获取学生信息
				IStudentService studentService = new StudentServiceImp();
				List<StudentInfo> stuList = studentService.getStudentByCondition(11, "", "", 20, 21, "");
				if(stuList!=null){
					// req.getSession().setAttribute("errInfo", "没有获取到数据"); 这个不算错误信息所以不区设置 
					Iterator<StudentInfo> iterator = stuList.iterator();
					req.getSession().setAttribute("stuList", stuList);
				}
			}else{
				req.getSession().setAttribute("errInfo", "用户名或者密码不对");
				ret = 2;
			}
		}
		
		//4. 控制转发区
		if(ret==0){
			resp.sendRedirect("WorkIn/Success.jsp");
		}else{
			resp.sendRedirect("WorkIn/Login.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
