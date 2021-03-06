package com.chinasofti.study;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcStore {
	private static String driverPath;
	private static String url;
	private static String user;
	private static String pwd;
	private static Connection conn;
	static {
		initInfo();
		try {
			Class.forName(driverPath);
			System.out.println("driver is ok");
			getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private JdbcStore() {

	}

	private static void initInfo(){
		Properties pro = new Properties();
		InputStream rs = JdbcStore.class.getResourceAsStream("jdbcConf.properties");
		try {
			pro.load(rs);
			driverPath = pro.getProperty("driver", "oracle.jdbc.OracleDriver");
			url =  pro.getProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
			user = pro.getProperty("user", "scott");
			pwd = pro.getProperty("pwd", "tiger");
			System.out.println("get info sucess");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("conn is ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static ResultSet queryData(String sql){
		
		ResultSet rs = null;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static void main(String[] args) {
		String sql = "SELECT userName, pwd FROM userInfo WHERE id=1";
		ResultSet rs = JdbcStore.queryData(sql);
		try {
			if(rs.next()){
				System.out.println(rs.getString("userName"));
				System.out.println(rs.getString("pwd"
						+ ""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
