package com.chinasofti.eecuser.model.service;

import java.util.List;

import com.chinasofti.eecuser.model.dao.AdminDAOImp;
import com.chinasofti.eecuser.model.dao.IAdminDAO;
import com.chinasofti.eecuser.model.javabean.UserInfo;

public class AdminServiceImp implements IAdminService {
	private IAdminDAO adminDAO;
	
	public AdminServiceImp(){
		adminDAO = new AdminDAOImp();
	}
	
	@Override
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int eecId, String eecName) {
		return adminDAO.queryDataByCondition(roleId, classId, eecId, eecName);
	}

}
