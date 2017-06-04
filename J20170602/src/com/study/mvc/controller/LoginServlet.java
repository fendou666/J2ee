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
		//0 ������
		String UserInfo = null;
		String userName = null;
		String pwd = null;
		int ret = 0;		
		//1. ת����
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		//2. ��ȡ����������
		userName = req.getParameter("userName");
		pwd = req.getParameter("pwd");
		//3. ������֤��
		if(userName==null||userName.equals("") || pwd==null || pwd.equals("")){
			req.getSession().setAttribute("errInfo", "�û����������벻��Ϊ��");
			ret = 1;
		}else{
			ILoginService loginService = new LoginServiceImp();
			StudentInfo stu = new StudentInfo();
			stu.setName(userName);
			stu = loginService.checkLoginInfo(stu, pwd);
			System.out.println(stu);
			/*if(userName.indexOf("С")!=-1){
				
			}else{
				req.getSession().setAttribute("errInfo", "�û�����ʽ����");
				ret = 2;
			}*/
		}
		
		//4. ����ת����
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
