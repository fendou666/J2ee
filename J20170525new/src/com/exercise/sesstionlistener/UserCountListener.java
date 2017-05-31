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
		System.out.println("session���������κ�����");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session���ٽ��û���Ϣע��");
		ServletContext app = (ServletContext)se.getSession().getAttribute("app");
		// ��ֹ����session������
		if(app!=null || !app.equals("")){
			HashSet<UserInfo> userAry = (HashSet<UserInfo>)app.getAttribute("userSet");
			userAry.remove(se.getSession().getAttribute("user"));
			app.setAttribute("userSet", userAry);
			System.out.println("��ǰ�û�sesstion�����������û���remove");
		}
	}

}
