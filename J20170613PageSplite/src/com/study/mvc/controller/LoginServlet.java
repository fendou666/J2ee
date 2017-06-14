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
		//0 ������
		String UserInfo = null;
		String userName = null;
		String pwd = null;
		int ret = 0;		
		//1. ת����
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//2. ��ȡ������������ �Լ�����ֵ������
		userName = req.getParameter("userName");
		pwd = req.getParameter("pwd");
		PrintWriter out = resp.getWriter();
		String msg = "";
		System.out.println("userName:" + userName);
		
		//3. ������֤��
		if(userName==null||userName.equals("") || pwd==null || pwd.equals("")){
			msg = "�û����������벻��Ϊ��";
		}else{
			ILoginService loginService = new LoginServiceImp();
			StudentInfo stu = new StudentInfo();
			stu.setName(userName);
			stu = loginService.checkLoginInfo(stu, pwd);
			System.out.println(stu);
			if(stu!=null && userName.equals(stu.getName())){
				msg = "��½�ɹ�";
				req.getSession().setAttribute("stu", stu);
			}else{
				msg = "�û����������벻��";
			}
		}
		
		//4. ����ת����
		out.write(msg);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}