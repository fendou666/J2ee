package bean;

import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * 实现无限级分类目录树的JavaBean
 * 完成数据库的连接
 * 完成分类的查询，增加，删除等操作
 * 编写日期：2007-10-05
 * @author 何裕浩 *
 */
public class SortBean {

	public int Id;
	public String name;
	public int parentId;
	
	private Connection conn;
	private Statement stmt;
	public ResultSet rs;
	
	int deleteCount=0;
	
	public SortBean(){
		
	}
	
//加载驱动程序，建立数据库的连接
public void OpenConn(String dsn,String user,String password){
	try{
	dsn = "jdbc:mysql:" + dsn;
     Class.forName("com.mysql.jdbc.Driver");
     conn = DriverManager.getConnection(dsn,user,password);
	}catch(Exception e){
	System.err.println("aq.executeQuery:"+e.getMessage());
		}
	}

/**
 * @return id
 */
public int getId() {
	return Id;
}

/**
 * @return name
 */
public String getName() {
	return name;
}

/**
 * @param name 要设置的 name
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return parentId
 */
public int getParentId() {
	return parentId;
}

/**
 * @param parentId 要设置的 parentId
 */
public void setParentId(int parentId) {
	this.parentId = parentId;
}

//查询
public ResultSet executeQuery(String sql){
	try{
		stmt=null;
		rs=null;
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
	}catch(SQLException e){
		System.err.println("aq.executeQuery:"+e.getMessage());
	}
	return rs;	
}

//更新
public void executeUpdate(String sql){
	try{
		stmt=null;
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	}catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	}
}

//级联删除，当某一分类存在子分类时，递归删除所有子类以及子类的子类,并且返回一共删除了多少个分类
public int delete(String table,int Id){
	try{
	rs=executeQuery("select * from "+table+" where parentId="+Id);
	rs.next();
	int children=rs.getRow();
	if(children==0){
	   	  executeUpdate("delete from "+table+" where Id="+Id);
	   	  deleteCount++;
	    }
	else{    
	rs.previous();
	while(rs.next()){
	   	  int Id2=rs.getInt("Id");   //防止递归后，没有子分类了，rs.next()为false，要保证父ID不变
	   	  delete(table,Id2);         //递归
     }
  rs.next();
	children=rs.getRow();
	if(children==0){
	   	  executeUpdate("delete from "+table+" where Id="+Id);     //此步骤保证在rs.next()为false时能递推回来，删除父ID
	   	  deleteCount++;
	    }   
  }
 }catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	} 
  return deleteCount;
}	


//关闭连接
public void closeConn(){
	try{
		conn.close();
	}catch(SQLException e){
		System.err.println("aq.closeConn:"+e.getMessage());
	}
}

}

