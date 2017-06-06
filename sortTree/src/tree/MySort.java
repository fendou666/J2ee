package tree;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * ʵ�����޼�����Ŀ¼����Servlet
 * ������ݿ������
 * ��ɷ���Ĳ�ѯ�����ӣ�ɾ���Ȳ���
 * ��д���ڣ�2007-10-05
 * @author ��ԣ�� *
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

/*����doPost����*/
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  String dsn=request.getParameter("dsn");
  String user=request.getParameter("user");
  String password="";
  String sql=request.getParameter("sql");
	
	request.setCharacterEncoding("gb2312");
	response.setCharacterEncoding("gb2312");
	out=response.getWriter();
	
	OpenConn(dsn,user,password);  //��������
	show(sql,0);
	closeConn();
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

//�õݹ��㷨,���ĳһ������ĵȼ�,0Ϊ��������
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
		level++;                   //levelΪȫ�ֱ���,��������ʹ�����Ӧ����
		getLevel(sql,parentId);    ////�ݹ�
	}
	return level;
}

//��⵱ǰ�����Ƿ�Ϊ��ײ�ķ���
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

//�õݹ��㷨����ʾ����֮��ĸ��ӹ�ϵ
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
		level=0;                       //levelΪȫ�ֱ���,��������ʹ�����Ӧ����
		
		show(sql,Id);                  //�ݹ�
	}
	}catch(SQLException e){
		System.err.println("aq.executeUpdate:"+e.getMessage());
	}
}

//�ر�����
public void closeConn(){
	try{
		conn.close();
	}catch(SQLException e){
		System.err.println("aq.closeConn:"+e.getMessage());
	}
}

/*����doGet����*/
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
}

