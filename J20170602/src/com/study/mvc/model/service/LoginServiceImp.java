package com.study.mvc.model.service;

import com.study.mvc.model.dao.ILoginDAO;
import com.study.mvc.model.dao.LoginDAOImp;
import com.study.mvc.model.javabean.StudentInfo;

public class LoginServiceImp implements ILoginService {
	private ILoginDAO loginDAO;

	public LoginServiceImp(){
		loginDAO = new LoginDAOImp();
	}
	@Override
	public StudentInfo checkLoginInfo() {
		return loginDAO.cheStudentInfo();
	}

}
