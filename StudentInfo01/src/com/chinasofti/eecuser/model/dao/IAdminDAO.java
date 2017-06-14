package com.chinasofti.eecuser.model.dao;

import java.util.List;

import com.chinasofti.eecuser.model.javabean.UserInfo;

public interface IAdminDAO {
	public UserInfo queryDataById(int eecId);
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int eecId, String eecName);
	public boolean insertEecuserData(UserInfo u);
	public boolean deleteEecuserDataById(int id);
	public boolean updateEecuserData(UserInfo u);
}
