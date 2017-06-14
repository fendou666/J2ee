package com.chinasofti.eecuser.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.eecuser.model.javabean.SqlDataPage;
import com.chinasofti.eecuser.model.javabean.UserInfo;
import com.chinasofti.eecuser.model.service.AdminServiceImp;
import com.chinasofti.eecuser.model.service.IAdminService;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
    
    }
    
    public void getPageMode(String pageMode, SqlDataPage stuPage){
    	if(pageMode.equals("first")){
    		stuPage.getFirstPage();
    	}else if(pageMode.equals("pre")){
    		stuPage.getPrePage();
    	}else if(pageMode.equals("next")){
    		stuPage.getNextPage();
    	}else if(pageMode.equals("last")){
    		stuPage.getLastPage();
    	}else{
    		try{
    			stuPage.getCustomPage(Integer.parseInt(pageMode));
    		}catch(NumberFormatException e){
    			System.out.println("传入指定页参数有问题，跳入首页");
    			stuPage.getCustomPage(1);
    		}
    	}
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取页面的参数
		String roleId 		= 	request.getParameter("roleId");
		String classId 		= 	request.getParameter("classId");
		String eecId		=  	request.getParameter("eecId");
		String eecName 		= 	request.getParameter("eecName");
		String action 		= 	request.getParameter("action");
		
		// 其他需要的参数
		PrintWriter out = response.getWriter();
		IAdminService adminService = new AdminServiceImp();
		int sqlRoleId = 0;
		int sqlClassId = 0;
		int sqlEecId = 0;
		System.out.println("roleId :" + roleId);
		System.out.println("classId :" + classId);
		System.out.println("eecId :" + eecId);
		System.out.println("eecName :" + eecName);
		System.out.println("action :" + action);
		
		// 参数处理
		if((roleId == null || roleId =="") 
			&& 	(classId == null || classId =="")
			&& 	(eecId == null || eecId =="")
			&& 	(eecName == null || eecName =="")
				){
			action = "errorReq";
		}
		if(roleId.equals("postAll")){
			roleId = "000";
		}
		if(classId.equals("classAll")){
			classId = "000";
		}
		if(roleId == null || roleId == ""){
			roleId = "-1";
		}
		if(classId == null || classId == ""){
			classId = "-1";
		}
		if(eecId == null || eecId == ""){
			eecId = "-1";
		}
		try{
			sqlRoleId 	= 	Integer.parseInt(roleId);
			sqlClassId 	= 	Integer.parseInt(classId);
			sqlEecId	= 	Integer.parseInt(eecId);
		}catch(NumberFormatException E){
			System.out.println("参数格式不对");
			action = "errorReq";
		}
		
		// 按需请求
		if(action.equals("getQuery")){
			List<UserInfo> userList = adminService.queryDataByCondition(sqlRoleId, sqlClassId, sqlEecId, eecName);
			if(userList!=null && userList.size()>0){
				Iterator<UserInfo> iterator = userList.iterator();
				UserInfo tmp = null;
				while(iterator.hasNext()){
					tmp = iterator.next();
					out.write("{");
					out.write("\"classId\":\""+ tmp.getClassId() +"\"," );
					out.write("\"id\":\""+ tmp.getId() +"\"," );
					out.write("\"name\":\""+ tmp.getName() +"\"," );
					out.write("\"sex\":\""+ tmp.getSex() +"\"," );
					out.write("\"age\":\""+ tmp.getAge() +"\"," );
					out.write("\"email\":\""+ tmp.getEmail() +"\"," );
					out.write("\"telephone\":\""+ tmp.getTelephone() +"\"," );
					out.write("\"roleName\":\""+ tmp.getRoleName() +"\"," );
					if(!iterator.hasNext()){
						out.write("}");
					}else{
						out.write("},");
					}
				}
			}else{
				out.write("[]");
			}
		}else if(action.equals("insertData")){
			
		}else if(action.equals("deleteData")){
			
		}else if(action.equals("updateData")){
			
		}else if(action.equals("errorReq")){
			out.write("[]");
		}else{ 
			out.write("[]");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
