package com.chinasofti.eecuser.model.service;

import java.util.List;

import com.chinasofti.eecuser.model.javabean.SqlDataPage;
import com.chinasofti.eecuser.model.javabean.UserInfo;

public interface IAdminService {
//	仅仅用户表
//	仅仅获取没有班级的学员
	public UserInfo queryDataById(String otherCondition, int eecId);
	
	
	// 最全获取班级信息表
	public List<UserInfo> queryEecUserOnlyByCondition(int roleId, int classId,
			int id, String name, SqlDataPage teacherPage);

	
//	班级信息表
	
//	关联权限昵称的表（教师）
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int id, String name, SqlDataPage teacherPage);
}
