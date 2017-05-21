package com.chinasofti.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbdStore {
	private String jdbcConfFile;
	private String jdbcLib;
	private String url;
	private String user;
	private String pwd;
	
	
	public JdbdStore(String jdbcConfFile){
		this.jdbcConfFile = jdbcConfFile; 
		getJdbcConfFromPro();
	}
	
	public void getJdbcConfFromPro(){
		Properties pro = new Properties();
		try {
//			pro.load(new FileInputStream(jdbcConfFile));
//			jdbcLib = pro.getProperty("jdbcLib");
//			user = pro.getProperty("user");
//			pwd = pro.getProperty("pwd");
			jdbcLib = "oracle.jdbc.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:orcl";
			user = "scott";
			pwd = "tiger";
			
//			1. 加载驱动，只需要加载一次就可以了
			Class.forName(jdbcLib);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public  Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(conn);
		return conn;
	}
	
	public void closeConn(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	仅仅查询语句
	public ResultSet queryData(Connection conn, String sql){
		ResultSet rs = null;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
//	仅仅DML语句
	public int update(Connection conn, String sql){
		int rs= 0;
		try {
			Statement st = conn.createStatement();
			rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
//	除过增删改查的语句
	public boolean executeOthers(Connection conn, String sql){
		boolean rs = false;
		
		try {
			Statement st = conn.createStatement();
			rs = st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
//	查询测试
	public void testQuery(){
		Connection conn = getConn();
		String sql = "SELECT id, name, sex FROM student";
		ResultSet rs = queryData(conn, sql);
		
		try {
			while(rs.next()){
				System.out.print(rs.getInt(1));
				System.out.print("\t");
				System.out.print(rs.getString(2));
				System.out.print("\t");
				System.out.print(rs.getString(2));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	快速生成sql语句
	public void testUpdate(){
		
	}
	
	public void testOthers(){
		
	}
	
	public static void main(String[] args) {
		JdbdStore store = new JdbdStore("./jdbc.properties");
		store.testQuery();
	}
}