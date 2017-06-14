package com.chinasofti.eecuser.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.eecuser.model.javabean.UserInfo;
import com.chinasofti.eecuser.tools.jdbc.DBUtil;

public class AdminDAOImp implements IAdminDAO {
	
	@Override
	public UserInfo queryDataById(int eecId) {
		
		return null;
	}
	
	
	// ����ƴ�ӣ� �������ֵΪ""�� ȷ��û���κ����ݣ� Ȼ��sql��ѯֱ�ӷ���Ϊnull
//	private String getConditionString(int roleId, int classId,
//			int eecId, String eecName){
//		String conditionStr = "";
//		conditionStr += " AND u.role_id=" +roleId;
//		conditionStr += " AND u.class_id=" +roleId;
//		conditionStr += " AND u.eec_id=" +roleId;
//		if(eecName != null){
//			conditionStr += " AND u.eec_name='" +eecName +"'";
//		}
//		return conditionStr;
//	}
	
	private String getConditionString(int roleId, int classId,
			int eecId, String eecName,  ArrayList<Object> objList){
		
		String conditionStr = "";
		if(roleId!=-1 && roleId!=0){
			conditionStr += " AND u.role_id=?";
			objList.add(roleId);
		}
		if(classId!=-1 && classId!=0){
			conditionStr += " AND u.class_id=?";
			objList.add(classId);
		}
		if(eecId!=-1){
			conditionStr += " AND u.eec_id=?";
			objList.add(eecId);
		}
		if(eecName != null){
			conditionStr += " AND u.eec_name=?";
			objList.add(eecName);
		}
		return conditionStr;
	}
	
	@Override
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int eecId, String eecName) {
		ArrayList<Object> objList = new ArrayList<Object>();
		// TODO  java.sql.SQLException: ��ֻת�����������Ч����: first
		String conditionStr = getConditionString(roleId, classId, eecId, eecName,  objList);
		List<UserInfo> userList = null;
		
		if(conditionStr.equals("")){
//			return null; // Ĭ��Ҳ��Ҫ���Ҳ��ܷ���
		}
		
		String sql="select u.class_Id,u.EEC_Id,u.EEC_Name,u.sex,u.age,u.email,u.telephone,r.role_name from eecuser u,eecrole r";
		sql += " WHERE 1='1' AND u.role_id = r.role_id AND u.role_id >=3004  AND u.role_id <=3005";
		sql += conditionStr;
		System.out.println("ִ�е�sql�����" + sql);
		
		ResultSet rs = DBUtil.getJDBC().queryDate(sql, objList);
		if(rs!=null){
			try {
				userList = new ArrayList<UserInfo>();
				while(rs.next()){
					// TODO java.sql.SQLException: ��ֻת�����������Ч����: first
//					if(rs.first()){
//						userList = new ArrayList<UserInfo>();
//					}
					userList.add(new UserInfo(
							Integer.parseInt(rs.getString("class_Id")),
							Integer.parseInt(rs.getString("EEC_Id")),
							rs.getString("EEC_Name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("email"),
							Long.parseLong(rs.getString("telephone")),
							rs.getString("role_name")
					));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (userList.size() == 0){
			userList = null;
		}
		return userList;  
	}

	@Override
	public boolean insertEecuserData(UserInfo u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEecuserDataById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEecuserData(UserInfo u) {
		// TODO Auto-generated method stub
		return false;
	}

	

}