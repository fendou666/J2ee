package com.chinasofti.eecuser.model.service;

import java.util.List;

import com.chinasofti.eecuser.model.dao.AdminDAOImp;
import com.chinasofti.eecuser.model.dao.IAdminDAO;
import com.chinasofti.eecuser.model.javabean.SqlDataPage;
import com.chinasofti.eecuser.model.javabean.UserInfo;

public class AdminServiceImp implements IAdminService {
	
	private IAdminDAO adminDAO;
	
	public AdminServiceImp(){
		adminDAO = new AdminDAOImp();
	}	
	
	@Override
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int id, String name, SqlDataPage teacherPage) {
		return adminDAO.queryDataByCondition(roleId, classId, id, name, teacherPage);
	}

	@Override
	public UserInfo queryDataById(String otherCondition, int eecId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> queryEecUserOnlyByCondition(int roleId, int classId,
			int id, String name, SqlDataPage teacherPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
