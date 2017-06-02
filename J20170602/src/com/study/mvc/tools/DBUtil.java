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
	
	// ����connӦ����static�г�ʼ������
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
			url = pro.getProperty("url", "jdbc:oracle:thin:@175.3.13.254:1521:orcl");
			user = pro.getProperty("user", "scott");
			pwd = pro.getProperty("pwd", "tiger");
			if(driver==null){
				System.out.println("��ȡ����ʧ��");
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
	private static HashMap checkStudentInfo(StudentInfo stu,String pwd){
		HashMap mp = null;
		StudentInfo sti = null;
		PreparedStatement ps = null;
		String sql = "select t.studentid, t.name, t.sex, t.age, t.school, t.pwd "
				+ "from STUDENTINFO t "
				+ "WHERE t.studentid=? AND t.pwd=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, stu.getName());
			ps.setObject(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("���ݿ� ѧ��ID" + rs.getString("studentid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return mp;
	}
	
	
}