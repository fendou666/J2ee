package com.study.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import oracle.jdbc.OracleTypes;

import com.study.mvc.model.javabean.SqlDataPage;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.javabean.sqlFuncObj;
import com.study.mvc.tools.DBUtil;
import com.sun.rowset.JdbcRowSetImpl;

public class StudentDAOImp implements IStudentDAO {

	@Override
	public HashMap getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap getStudentByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentByName(String name) {
		HashMap<String, List<StudentInfo>> stuMp = null;
		List<StudentInfo> stuList = null;
		String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA "
				+ " WHERE name like '%" + name +"%'"
				+ " ORDER BY id";
		System.out.println("sql 执行语句是: " + sql);
		ResultSet rs = DBUtil.queryData(sql);
		if(rs!=null){
			try {
				stuMp = new HashMap<String, List<StudentInfo>>();
				stuList = new ArrayList<StudentInfo>();
				while(rs.next()){
					// TODO为什么报错
					/*if(rs.first()){
						System.out.println("rs first");
					}*/
					System.out.println("id 为 "  + rs.getString("id"));
					stuList.add(new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom")));
				}
				stuMp.put("stuList", stuList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuMp;
		//return getStudentByCondition(-1, name, null, -1, -1, null);
	}

	@Override
	public HashMap getStudentByName(String name, SqlDataPage stuPage) {
		
		HashMap stuMp = null;
		List<StudentInfo> stuList = null;
		ArrayList<sqlFuncObj> params = new ArrayList<sqlFuncObj>();
<<<<<<< HEAD
		String sql = "{?=call getOnePageStuInfo(?,?,?,?)}";
		int allRecordRows = 0;
		params.add(new sqlFuncObj("out", 1, new Object(), OracleTypes.CURSOR));
		params.add(new sqlFuncObj("in", 2, stuPage.getPageMaxRows(), OracleTypes.INTEGER));
		params.add(new sqlFuncObj("in", 3, stuPage.getCurrentPage(), OracleTypes.INTEGER));
		params.add(new sqlFuncObj("in", 4, name, OracleTypes.VARCHAR));
		params.add(new sqlFuncObj("out", 5, allRecordRows, OracleTypes.INTEGER));
		params = DBUtil.prepareCallQueryData(sql, params);
		
		ResultSet rs = (ResultSet)params.get(0).getObj();
		stuPage.setAllRows((int)params.get(4).getObj());
		stuPage.setMaxPageIndexByAllRows();
		
		System.out.println("更新后stuPage为" + stuPage);
		if(rs!=null){
			try {
				stuMp = new HashMap<String, List<StudentInfo>>();
				stuList = new ArrayList<StudentInfo>();
				while(rs.next()){
					// TODO为什么报错
					/*if(rs.first()){
						System.out.println("rs first");
					}*/
					System.out.println("id 为 "  + rs.getString("id"));
					stuList.add(new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom")));
				}
				stuMp.put("stuList", stuList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuMp;
		
=======
		String sql = "{? =callgetOnePageStuInfo(?,?,?,?) }";
		Object aa = new JdbcRowSetImpl();
		params.add(new sqlFuncObj("out", 1, new JdbcRowSetImpl(), OracleTypes.CURSOR));
		params.add(new sqlFuncObj("out", 1, , OracleTypes.CURSOR));
>>>>>>> d16740dd4292f616553c1e84c3c9bd999b1127f7
	}
	
	
	@Override
	public HashMap getStudentBySex(String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentByAge(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentBySchool(String schoolName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getOneCondition(String type, String key, int intVal, String strVal){
		String ret = "";
		if(key.equals("number") && intVal!=-1){
			ret = key + "=" + intVal;
		}
		if(key.equals("string") && strVal!=null){
			ret = key + "=" + strVal;
		}
		System.out.println("ret 值为[" + ret + "]");
		return ret;
	}
	private String getAndcoditionStr(String sqlConditionStr){
		System.out.println("当前条件为" + sqlConditionStr);
		return sqlConditionStr==""?"":" AND ";
	}
	
	private String getCondtionStr(int num, String name,
			String sex, int start, int end, String schoolName){
		String sqlConditionStr = "";
		
		sqlConditionStr += getAndcoditionStr(sqlConditionStr) + getOneCondition("number", "stuNum", num, null);
		sqlConditionStr += getAndcoditionStr(sqlConditionStr) + getOneCondition("string", "name", -1, name);
		sqlConditionStr += getAndcoditionStr(sqlConditionStr) + getOneCondition("string", "sex", -1, sex);
		sqlConditionStr += getAndcoditionStr(sqlConditionStr) + getOneCondition("number", "start", start, null);
		sqlConditionStr += getAndcoditionStr(sqlConditionStr) + getOneCondition("number", "end", end, null);
		sqlConditionStr += getAndcoditionStr(sqlConditionStr) + getOneCondition("string", "schoolName", -1, schoolName);
		return sqlConditionStr;
	}
	
	@Override
	public HashMap getStudentByCondition(int num, String name,
			String sex, int start, int end, String schoolName) {
//			String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA WHERE "
//					+ "id = " + num
//					+ " AND name = " + name
//					+ " AND name = " + name
//					+ " AND name = " + name
//					+ " AND name = " + name
//					;
		//String sqlConditionStr = getCondtionStr(num, name, sex, start, end, schoolName);
		
		HashMap<String, List<StudentInfo>> stuMp = null;
		List<StudentInfo> stuList = null;
		String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA ORDER BY id";
		/*if(!sqlConditionStr.equals("")){
			sql += " WHERE " + sqlConditionStr;
		}*/
		System.out.println("sql 执行语句是: " + sql);
		ResultSet rs = DBUtil.queryData(sql);
		if(rs!=null){
			try {
				stuMp = new HashMap<String, List<StudentInfo>>();
				stuList = new ArrayList<StudentInfo>();
				while(rs.next()){
					// TODO为什么报错
					/*if(rs.first()){
						System.out.println("rs first");
					}*/
					System.out.println("id 为 "  + rs.getString("id"));
					stuList.add(new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom")));
				}
				stuMp.put("stuList", stuList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuMp;
	}

	@Override
	public boolean insertStudentInfo(StudentInfo stu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudentInfo(int num) {
		String sql = "DELETE FROM studentInfoA  WHERE id=" + num;
		System.out.println("删除sql为" +sql);
		int changeCount = DBUtil.changeData(sql);
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean saveStudentInfo(StudentInfo stu) {
		String sql = "UPDATE studentInfoA SET "
				+ " stuNum=" + stu.getNum()
				+ ", name='" + stu.getName()
				+ "', sex='" + stu.getSex()
				+ "', age=" + stu.getAge()
				+ ", gradeFrom='" + stu.getSchool()
				+ "' WHERE id=" + stu.getId();
		System.out.println("更新sql语句是" + sql);
		int changeCount = DBUtil.changeData(sql);
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public HashMap getStudentAll() {
		HashMap<String, List<StudentInfo>> stuMp = null;
		List<StudentInfo> stuList = null;
		String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA ORDER BY id";
		ResultSet rs = DBUtil.queryData(sql);
		if(rs!=null){
			try {
				stuMp = new HashMap<String, List<StudentInfo>>();
				stuList = new ArrayList<StudentInfo>();
				while(rs.next()){
					// TODO为什么报错
					/*if(rs.first()){
						System.out.println("rs first");
					}*/
					System.out.println("id 为 "  + rs.getString("id"));
					stuList.add(new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom")));
				}
				stuMp.put("stuList", stuList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuMp;
	}

	public static void main(String[] args) {
		new StudentDAOImp().getStudentByName("刘亦菲");
		
		String name = "ls";
		SqlDataPage stuPage = new SqlDataPage();
		stuPage.setCurrentPage(1);
		stuPage.setPageMaxRows(10);
		new StudentDAOImp().getStudentByName("刘亦菲", stuPage);
	}

	

}
