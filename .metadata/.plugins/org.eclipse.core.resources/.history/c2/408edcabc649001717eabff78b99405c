package com.study.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.ILoginService;
import com.study.mvc.model.service.LoginServiceImp;

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
			/*if(userName.indexOf("小")!=-1){
				
			}else{
				req.getSession().setAttribute("errInfo", "用户名形式不对");
				ret = 2;
			}*/
		}
		
		//4. 控制转发区
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
