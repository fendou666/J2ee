package com.chinasofti.eecuser.model.service;

import java.util.List;

import com.chinasofti.eecuser.model.javabean.UserInfo;

public interface IAdminService {
	public List<UserInfo> queryDataByCondition(int roleId, int classId, 
			int eecId, String eecName);
}
