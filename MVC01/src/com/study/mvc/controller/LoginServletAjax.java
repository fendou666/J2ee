package com.study.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.bean.UserInfo;
import com.study.mvc.model.service.ILoginService;
import com.study.mvc.model.service.LoginServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServletAjax")
public class LoginServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletAjax() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0 ������
		String userid=null; //�û����
		String pwd=null;      //�û�����
		UserInfo userInfo =null;
		String dataMsg = "";
		
		
		//1 ���ý���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//2 ���ջ�����������鱨
		userid=request.getParameter("userid");
		pwd=request.getParameter("pwd");
				
		
		//3.1 ������֤---�Ϸ�����֤  Ajax
		if(userid==null||pwd==null||userid.equals("")||pwd.equals("")){
			out.write(dataMsg);
			return;
		}
		
		//2 ��ȷ����֤  Service����û�����ȷ��������֤
		ILoginService loginService=new LoginServiceImp();
		if(userid.matches("[0-9]+")){
			userInfo = loginService.checkUserInfo(Integer.parseInt(userid), pwd);
		}
		else{
			dataMsg = "�û���Ż�������󣡣�";
			System.out.println("�û���Ż�������󣡣�1111");
			out.write(dataMsg);
			return;
		}
		
		//����
		if(userInfo==null){
			//�û��鱨��֤δͨ��
			dataMsg = "�û���Ż�������󣡣�";
			System.out.println("�û���Ż�������󣡣�2222");
			out.write(dataMsg);
		}
		else{
			request.getSession().setAttribute("userinfo", userInfo);
			dataMsg = "�ɹ���½";
			out.write(dataMsg);
		}
	}

}