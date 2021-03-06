package com.chinasofti.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyA3Servlet
 */
@WebServlet("/AS3")
public class AS3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AS3() {
    	count = 0;
    	System.out.println("A3======构造方法");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("A3======init");
	}

	
	public  boolean checkUserPwd(String userName, String pwd){
//		连接数据库
		boolean rec = false;
		String rsPwd = "";
		JdbdStore store = new JdbdStore("aaa");
		String sql = "SELECT userName, pwd FROM j2eeTest WHERE userName=" + userName;
		ResultSet queryData = store.queryData(null, sql);
		try {
			while(queryData.next()){
				System.out.println(queryData.getString(1));
				rsPwd = queryData.getString(1);
				if(rsPwd.equals(pwd)){
					rec = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rec;
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("A3=====destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("======service");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		第一步乱码处理
		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
		
//		请求解析
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		user = new String(user.getBytes("ISO-8859-1"), "UTF-8");
		pwd = new String(pwd.getBytes("ISO-8859-1"), "UTF-8");
		
		
		PrintWriter writer = response.getWriter();
//		session判断
		String value = (String)request.getSession().getAttribute("aaa");
		if(!value.equals("神马都是浮云")){
			writer.write("session判断出错");
			return;
		}
		
		
//		用户名密码判断
		if(user.equals("aaa") && pwd.equals("bbb")){
			writer.write("登陆成功");
		}else {
			writer.write("用户名或密码错误");
			return;
		}
		
		
		
//		System.out.println("密码 ：" + checkUserPwd(user, pwd));
//		请求响应
//		ServletOutputStream outputStream = response.getOutputStream();
		count++;
		writer.write(user + pwd + "您是第" + count + "位访问myA3Servlet");
		

		
		System.out.println("A3=====doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
