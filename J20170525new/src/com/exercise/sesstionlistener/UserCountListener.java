package com.exercise.sesstionlistener;

import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.exercise.java.UserInfo;

public class UserCountListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建不做任何事情");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁将用户信息注销");
		ServletContext app = (ServletContext)se.getSession().getAttribute("app");
		// 防止其他session起作用
		if(app!=null || !app.equals("")){
			HashSet<UserInfo> userAry = (HashSet<UserInfo>)app.getAttribute("userSet");
			userAry.remove(se.getSession().getAttribute("user"));
			app.setAttribute("userSet", userAry);
			System.out.println("当前用户sesstion结束，在线用户被remove");
		}
	}

}
