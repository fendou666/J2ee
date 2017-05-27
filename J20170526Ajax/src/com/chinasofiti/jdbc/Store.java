package com.chinasofiti.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.exercise.java.UserInfo;

public class Store {
	private static String driver;
	private static Connection conn;
	private static String url;
	private static String user;
	private static String pwd;
	private static final String ip = "175.3.13.254";
	private static final String port = "1521";
	static{
		if(initInfo()){
			try {
				Class.forName(driver);
				getConn();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("get properties false");
		}
	}
	// TODO �˴���Ҫ̽��
	private static boolean initInfo(){
		boolean rec = true;
		Properties pro = new Properties();
		try {
			pro.load(Store.class.getResourceAsStream("jdbcConf.properties"));
			driver 	= 	pro.getProperty("driver", "oracle.jdbc.Oracle.OracleDriver");
			url 	= 	pro.getProperty("url", "jdbc:oracle:thin:@" + ip +":" +port+":orcl");
			user 	= 	pro.getProperty("user", "scott");
			pwd 	= 	pro.getProperty("pwd", "tiger");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(driver==null || url==null || user==null ||pwd==null){
			rec = false;
		}
		return rec;
	}
	private static Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static UserInfo queryData(UserInfo u){
		ResultSet rs = null;
		String sql = "SELECT userName, id, pwd, qx from userInfo WHERE userName=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			rs = ps.executeQuery();
			while(rs.next()){
				u.setName(rs.getString("userName"));
				u.setId(rs.getString("id"));
				u.setQx(rs.getString("qx"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(u.getId()!=null){
			return u;
		}else{
			return null;
		}
	}
	
	public static void main(String[] args) {
//		UserInfo u = Store.queryData(new UserInfo("С��", "aaaa"));
		UserInfo u = Store.queryData(new UserInfo("С��", "aaaa' or 1=1'"));
		if(u!=null){
			System.out.println("�鵽���");
		}else{
			System.out.println("û�в鵽���");
		}
	}
}