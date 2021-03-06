package com.chinasofti.study;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String getPwd(User u, String pwd){
		
		String sql = "SELECT userName, pwd FROM userInfo WHERE id=" + u.getId();
		ResultSet rs = JdbcStore.queryData(sql);
		try {
			if(rs.next()){
				return rs.getString("pwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		编码处理
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		获取参数
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		user = new String(user.getBytes("ISO-8859-1"), "UTF-8");
		pwd = new String(pwd.getBytes("ISO-8859-1"), "UTF-8");

//		参数判断
		int errorSign = 1; // 1代表正常，2代表用户名为空,3， 代表用户名或者密码错误
		if(user==null || (user!=null&&user.equals("")) ){
			errorSign = 2;
		}else {
//			参数对比
			User u = new User(1, user);
			String recPwd = getPwd(u, pwd);
			if(recPwd==null || (recPwd!=null&&!recPwd.equals(pwd))){
				errorSign = 3;
			}
		}
		
//		参数存入cookie,session
		
		Cookie errInfo = null;
		Cookie userC = null;
		Cookie pwdC = null;
		if(errorSign == 2){
			errInfo = new Cookie("errInfo", URLEncoder.encode("用户名为空", "UTF-8"));
//			设置cookie失效时间
			errInfo.setMaxAge((int)(new Date().getTime()+24*60*60*1000));
			//resp.addCookie(errInfo);
		}else if(errorSign == 3){
			//errInfo = new Cookie("errInfo", "用户名或者密码错误");
			//这样不可以要指定存入的code解码 参考http://blog.csdn.net/liulong547026741/article/details/11553923
			errInfo = new Cookie("errInfo", URLEncoder.encode("用户名或者密码错误", "UTF-8"));
//			设置cookie失效时间
			errInfo.setMaxAge((int)(new Date().getTime()+24*60*60*1000));
			resp.addCookie(errInfo);
		}else{
			userC = new Cookie("user", URLEncoder.encode(user, "UTF-8"));
			pwdC = new Cookie("pwd", pwd);
//			设置cookie失效时间
			userC.setMaxAge((int)(new Date().getTime()+24*60*60*1000));
			pwdC.setMaxAge((int)(new Date().getTime()+24*60*60*1000));
			resp.addCookie(userC);
			resp.addCookie(pwdC);
		}
		resp.addCookie(new Cookie("aaaa", "bbbb"));
		
//		URL重定向
		
		resp.sendRedirect("workIn/Login.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

}
