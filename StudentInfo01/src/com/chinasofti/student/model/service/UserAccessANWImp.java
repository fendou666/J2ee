package com.chinasofti.student.model.service;

import com.chinasofti.student.javabean.UserAceessANW;
import com.chinasofti.student.model.dao.DAOUserAccessANWImp;
import com.chinasofti.student.model.dao.IDAOUserAccessANW;

public class UserAccessANWImp implements ISVCAccessSafeANS {
	private IDAOUserAccessANW userAccessDAO = null;
	
	public UserAccessANWImp(){
		userAccessDAO = new DAOUserAccessANWImp();
	}
	
	@Override
	public boolean accessAnswer(UserAceessANW UA, String answer3) {
		return userAccessDAO.accessAnswer(UA, answer3);
	}

}