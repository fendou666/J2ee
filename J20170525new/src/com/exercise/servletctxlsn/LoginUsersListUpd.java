package com.exercise.servletctxlsn;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.exercise.java.UserInfo;

public class LoginUsersListUpd implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ArrayList<UserInfo> userInfoAry = new ArrayList<UserInfo>();
		sc.setAttribute("LoginUsers", userInfoAry);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.removeAttribute("LoginUsers");
	}

}
