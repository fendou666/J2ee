package bean;

import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * ʵ�����޼�����Ŀ¼����JavaBean
 * ������ݿ������
 * ��ɷ���Ĳ�ѯ�����ӣ�ɾ���Ȳ���
 * ��д���ڣ�2007-10-05
 * @author ��ԣ�� *
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
	
//�����������򣬽������ݿ������
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
 * @param name Ҫ���õ� name
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
 * @param parentId Ҫ���õ� parentId
 */
public void setParentId(int parentId) {
	this.parentId = parentId;
}

//��ѯ
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

//����
public void executeUpdate(String sql){
	try{
		stmt=null;
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	}catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	}
}

//����ɾ������ĳһ��������ӷ���ʱ���ݹ�ɾ�����������Լ����������,���ҷ���һ��ɾ���˶��ٸ�����
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
	   	  int Id2=rs.getInt("Id");   //��ֹ�ݹ��û���ӷ����ˣ�rs.next()Ϊfalse��Ҫ��֤��ID����
	   	  delete(table,Id2);         //�ݹ�
     }
  rs.next();
	children=rs.getRow();
	if(children==0){
	   	  executeUpdate("delete from "+table+" where Id="+Id);     //�˲��豣֤��rs.next()Ϊfalseʱ�ܵ��ƻ�����ɾ����ID
	   	  deleteCount++;
	    }   
  }
 }catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	} 
  return deleteCount;
}	


//�ر�����
public void closeConn(){
	try{
		conn.close();
	}catch(SQLException e){
		System.err.println("aq.closeConn:"+e.getMessage());
	}
}

}

