package com.chinasofti.student.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sun.security.pkcs11.Secmod.DbMode;

import com.chinasofti.student.javabean.UserAceessANW;
import com.chinasofti.student.tools.jdbc.DBUtil;

public class DAOUserAccessANWImp implements IDAOUserAccessANW {
	private String errInfo;
	
	public String getErrInfo() {
		return errInfo;
	}
	
	@Override
	public boolean accessAnswer(UserAceessANW UA, String answer3) {
		boolean ret = false;
		String sql = "select answer1, answer2, answer3 from QSTVerify "
				+ "WHERE QSTVerify_id="
				+ "(SELECT QSTVerify_id FROM EECUSER WHERE eec_id=?)";
		ArrayList objList = new ArrayList();
		objList.add(UA.getEec_id());
		ResultSet rs = DBUtil.getJDBC().queryDate(sql, objList);
		if(DBUtil.getJDBC().getErrInfo()==null){
			if(rs!=null){
				try {
					while(rs.next()){
						if(rs.getString("answer1").equals(UA.getAnswer1())
							&&	rs.getString("answer2").equals(UA.getAnswer1())
							&&	rs.getString("answer3").equals(answer3)
								){
							ret = true;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
}
