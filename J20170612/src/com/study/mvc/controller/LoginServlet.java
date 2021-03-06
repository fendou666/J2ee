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
		
		//2. 获取参数数据区， 以及返回值定义区
		userName = req.getParameter("userName");
		pwd = req.getParameter("pwd");
		PrintWriter out = resp.getWriter();
		String msg = "";
		System.out.println("userName:" + userName);
		
		//3. 参数验证区
		if(userName==null||userName.equals("") || pwd==null || pwd.equals("")){
			msg = "用户名或者密码不能为空";
		}else{
			ILoginService loginService = new LoginServiceImp();
			StudentInfo stu = new StudentInfo();
			stu.setName(userName);
			stu = loginService.checkLoginInfo(stu, pwd);
			System.out.println(stu);
			if(stu!=null && userName.equals(stu.getName())){
				msg = "登陆成功";
				req.getSession().setAttribute("stu", stu);
			}else{
				msg = "用户名或者密码不对";
			}
		}
		
		//4. 控制转发区
		out.write(msg);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
