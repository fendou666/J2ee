package com.chinasofti.eecuser.model.dao;

import java.util.List;

import com.chinasofti.eecuser.model.javabean.UserInfo;

public interface IAdminDAO {
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int eecId, String eecName);
}
