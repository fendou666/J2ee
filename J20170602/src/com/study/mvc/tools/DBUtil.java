package com.study.mvc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.study.mvc.model.javabean.StudentInfo;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	private static Connection conn;
	
	// 关于conn应该在static中初始化还是
	static{
		getDBPropertiesInfo();
		try {
			Class.forName(driver);
			getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private DBUtil(){
		
	}
	private static void getDBPropertiesInfo(){
		Properties pro = new Properties();
		try {
			pro.load(DBUtil.class.getResourceAsStream("oracleInfo.properties"));
			driver = pro.getProperty("driver", "oracle.jdbc.OracleDriver");
			url = pro.getProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
			user = pro.getProperty("user", "scott");
			pwd = pro.getProperty("pwd", "tiger");
			if(driver==null){
				System.out.println("获取驱动失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static HashMap checkStudentInfo(StudentInfo stu, String pwd){
		System.out.println("进入数据库");
		HashMap<String, StudentInfo> mp = null;
		StudentInfo sti = null;
		PreparedStatement ps = null;
		String sql = "select t.studentid, t.name, t.sex, t.age, t.school, t.pwd "
				+ "from STUDENTINFO t "
				+ "WHERE t.name=? AND t.pwd=?";
		System.out.println("conn对象:" +conn);
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, stu.getName());
			ps.setObject(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sti = new StudentInfo();
				sti.setNum(Integer.parseInt(rs.getString("studentid")));
				sti.setName(rs.getString("name"));
				sti.setSex(rs.getString("sex"));
				sti.setAge(Integer.parseInt(rs.getString("age")));
				sti.setSchool(rs.getString("school"));
				mp = new HashMap<String, StudentInfo>();
				mp.put("stuInfo", sti);
				System.out.println("数据库 学生ID" + rs.getString("studentid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return mp;
	}
	
	public static void main(String[] args) {
		StudentInfo stu = new StudentInfo();
		stu.setName("小明");
		DBUtil.checkStudentInfo(stu, "123");
	}
	
}
