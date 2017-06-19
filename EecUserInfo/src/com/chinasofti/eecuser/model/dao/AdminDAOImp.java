package com.chinasofti.eecuser.model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import com.chinasofti.eecuser.model.javabean.SqlDataPage;
import com.chinasofti.eecuser.model.javabean.UserInfo;
import com.chinasofti.eecuser.tools.jdbc.DBUtil;

public class AdminDAOImp implements IAdminDAO {

	@Override
	public UserInfo queryDataById(int id) {
		return null;
	}
	// 条件语句整理
	private String getConditionString(int roleId, int classId,
			int id, String name){
		
		String conditionStr = "";
		if(roleId!=-1 && roleId!=0){
			conditionStr += " AND u.role_id=" + roleId;
		}else{
			conditionStr += " AND u.role_id>=3004 AND u.role_id<=3005";
		}
		if(classId!=-1 && classId!=0){
			conditionStr += " AND u.class_id=" + classId;
		}
		if(id!=-1){
			conditionStr += " AND u.eec_id=" + id;
		}
		if(name != null){
			conditionStr += " AND u.eec_name='" + name +"'";
		}
		return conditionStr;
	}
	
	@Override
	public List<UserInfo> queryDataByCondition(int roleId, int classId,
			int id, String name, SqlDataPage teacherPage) {
		// where 需要的条件语句
		String conditionStr = getConditionString(roleId, classId, id, name);
		System.out.println("条件语句是 " + conditionStr);
		// 返回的用户列表
		List<UserInfo> userList = null;
		String sql = "{?=call eecAdminQueryTeacherPageRows(?,?,?,?)}";
		
		try {
			// 函数存储过程通过这中方式调用
			CallableStatement  pc = DBUtil.getJDBC().getConn().prepareCall(sql);
			pc.registerOutParameter(1, OracleTypes.CURSOR);
			pc.setObject(2, teacherPage.getPageMaxRows());
			pc.setObject(3, teacherPage.getCurrentPage());
			pc.setObject(4, conditionStr);
			pc.registerOutParameter(5, OracleTypes.INTEGER);
			
			pc.execute();
			
			ResultSet rs = (ResultSet)pc.getObject(1);
			if(rs!=null){
				// 设置总记录条数
				teacherPage.setAllRows((int)pc.getObject(5));
				// 设置最大页码
				teacherPage.setMaxPageIndexByAllRows();
				userList = new ArrayList<UserInfo>();
				
				while(rs.next()){
					System.out.println("id 为 "  + rs.getString("eec_id"));
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
			}
			System.out.println("获取到sql数量是" + pc.getObject(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (userList!=null && userList.size() == 0){
			userList = null;
		}
		return userList;  
 	}
	
	private void testDBUtilQuery() throws SQLException{
		String sql = "SELECT u.EEC_Id,u.EEC_Name from eecuser u "
				+ "WHERE  u.class_id=? AND u.role_id=?";
		ArrayList<Object> objList = new ArrayList<Object>();
		objList.add(20170207);
		objList.add(3001);
		ResultSet rs = DBUtil.getJDBC().queryDate(sql, objList);
		if(rs!=null){
			while(rs.next()){
				System.out.println("id:" + rs.getObject("EEC_Id")
									+ " name:" + rs.getObject("EEC_Name"));
			}
		}else{
			System.out.println("未获取到数据");
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new AdminDAOImp().testDBUtilQuery();
		} catch (SQLException e) {
			System.out.println("执行失败");
			e.printStackTrace();
		}
	}
}
