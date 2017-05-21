package com.chinasofti.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySecondServlet extends HttpServlet {

	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("second=======init config");
		
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		System.out.println("second=====doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("second=====doPost");
	}


	
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("+++serverc");
//		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		System.out.println("second=====destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("second=====init");
	}

}
