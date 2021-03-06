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
		//0 定义区
		String userid=null; //用户编号
		String pwd=null;      //用户密码
		UserInfo userInfo =null;
		String dataMsg = "";
		
		
		//1 设置解码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//2 接收画面给的请求情报
		userid=request.getParameter("userid");
		pwd=request.getParameter("pwd");
				
		
		//3.1 数据验证---合法性验证  Ajax
		if(userid==null||pwd==null||userid.equals("")||pwd.equals("")){
			out.write(dataMsg);
			return;
		}
		
		//2 正确性验证  Service完成用户的正确性数据验证
		ILoginService loginService=new LoginServiceImp();
		if(userid.matches("[0-9]+")){
			userInfo = loginService.checkUserInfo(Integer.parseInt(userid), pwd);
		}
		else{
			dataMsg = "用户编号或密码错误！！";
			System.out.println("用户编号或密码错误！！1111");
			out.write(dataMsg);
			return;
		}
		
		//控制
		if(userInfo==null){
			//用户情报认证未通过
			dataMsg = "用户编号或密码错误！！";
			System.out.println("用户编号或密码错误！！2222");
			out.write(dataMsg);
		}
		else{
			request.getSession().setAttribute("userinfo", userInfo);
			dataMsg = "成功登陆";
			out.write(dataMsg);
		}
	}

}
