package tree;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * 实现无限级分类目录树的Servlet
 * 完成数据库的连接
 * 完成分类的查询，增加，删除等操作
 * 编写日期：2007-10-05
 * @author 何裕浩 *
 */
public class MySort extends HttpServlet{
	public int Id;
	public String name;
	public int parentId;
	
	private Connection conn;
	private Statement stmt;
	public ResultSet rs;
	
	int level=0;
	
	PrintWriter out;

/*覆盖doPost方法*/
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  String dsn=request.getParameter("dsn");
  String user=request.getParameter("user");
  String password="";
  String sql=request.getParameter("sql");
	
	request.setCharacterEncoding("gb2312");
	response.setCharacterEncoding("gb2312");
	out=response.getWriter();
	
	OpenConn(dsn,user,password);  //建立连接
	show(sql,0);
	closeConn();
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

//用递归算法,获得某一个分类的等级,0为顶级分类
public int getLevel(String sql,int Id){
	try{
		String sql2=sql+" where Id="+Id;
		ResultSet result=executeQuery(sql2);
		while(result.next()){
			parentId=result.getInt("parentId");
		}
	}catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	}
	while(parentId!=0){
		level++;                   //level为全局变量,其他函数使用完后都应清零
		getLevel(sql,parentId);    ////递归
	}
	return level;
}

//检测当前分类是否为最底层的分类
public boolean isLast(String sql,int Id){
	boolean last=false;
	try{
		String sql2=sql+" where parentId="+Id;
		ResultSet result=executeQuery(sql2);
		rs.next();
		if(rs.getRow()==0)
		  last=true;
		else
		  last=false; 
	}catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	}	
	return last;
}	

//用递归算法，显示分类之间的父子关系
public void show(String sql,int parentId){
	int printCount=0;
	String li="";
	try{
	String sql2=sql+" where parentId="+parentId;
	ResultSet result=executeQuery(sql2);
	while(result.next()){
		Id=result.getInt("Id");
		name=result.getString("name");
		printCount=getLevel(sql,Id);
		out.print("<html>\n<body>");
		for(int i=0;i<printCount;i++)
			out.print("&nbsp;&nbsp;&nbsp;");
		if(level==0)
		     li="<img src=\"web/images/close.gif\"/>";
		else if(isLast(sql,Id)) 
		          li="<img src=\"web/images/lastnodeline.gif\"/>";  
		     else
		          li="<img src=\"web/images/midopenedfolder.gif\"/>";
		
		out.println(li+"<a href=\"show.jsp?Id="+Id+"\" target=\"main\">"+name+"</a><br>");
		out.print("\n</body>\n</html>");
		level=0;                       //level为全局变量,其他函数使用完后都应清零
		
		show(sql,Id);                  //递归
	}
	}catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	}
}

//关闭连接
public void closeConn(){
	try{
		conn.close();
	}catch(SQLException e){
		System.err.println("aq.closeConn:"+e.getMessage());
	}
}

/*覆盖doGet方法*/
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
}

