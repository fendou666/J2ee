package com.exercise.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.exercise.javaneed.CatchFileManage;

public class ListenerLoginCount implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext app = sce.getServletContext();
		String path = app.getRealPath("/LocalCatch") + "/countCatchFile.txt";
		String loginCount = new CatchFileManage().getCatchFromLocalFile(path);
		app.setAttribute("LoginCount", loginCount);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext app = sce.getServletContext();
		String path = app.getRealPath("/LocalCatch") + "/countCatchFile.txt";
		String loginCount = (String)app.getAttribute("LoginCount");
		new CatchFileManage().updataCatchToFile(path, loginCount);
	}

}
