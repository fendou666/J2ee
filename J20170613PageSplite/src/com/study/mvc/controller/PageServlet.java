package com.study.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import com.study.mvc.model.javabean.SqlDataPage;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
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
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入get请求");
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		IStudentService studentService = new StudentServiceImp();
		
		if(action.equals("seachByNameJSONPage")){
			System.out.println("进入seachByNameJSONPage");
			String name = request.getParameter("name");
			String pageMode = request.getParameter("pageIndex");
			
			// 初始化数据库page JavaBean
			HashMap<String,SqlDataPage> sqlPageHashSet  = (HashMap<String,SqlDataPage>)request.getSession().getAttribute("sqlPageList");
			SqlDataPage stuPage = null;
			if(sqlPageHashSet == null){
				sqlPageHashSet = new HashMap<String,SqlDataPage>();
				stuPage = new SqlDataPage();
				stuPage.setCurrentPage(1);
				stuPage.setPageMaxRows(10);
				sqlPageHashSet.put("stuPage", stuPage);
			}else{
				stuPage = (SqlDataPage)sqlPageHashSet.get("stuPage");
			}
			System.out.println("传参为" + pageMode);
			if(pageMode==null){
				out.write("[]");
				return;
			}
			getPageMode(pageMode, stuPage);
			System.out.println("当前请求页码是 :" + stuPage.getCurrentPage());
			sqlPageHashSet.put("stuPage", stuPage);
			
			out.write("[");
			if(name!=null){
				List<StudentInfo> stuList = studentService.getStudentByName(name, stuPage);
				System.out.println("所有记录条数" + stuPage.getAllRows());
				if(stuList!=null && stuList.size()>0){
					Iterator<StudentInfo> iterator = stuList.iterator();
					StudentInfo tmp = null;
					while(iterator.hasNext()){
						tmp = iterator.next();
						out.write("{");
						out.write("\"id\":\""+ tmp.getId() +"\"," );
						out.write("\"num\":\""+ tmp.getNum() +"\"," );
						out.write("\"name\":\""+ tmp.getName() +"\"," );
						out.write("\"age\":\""+ tmp.getAge() +"\"," );
						out.write("\"sex\":\""+ tmp.getSex() +"\"," );
						out.write("\"school\":\""+ tmp.getSchool() +"\"" );
						if(!iterator.hasNext()){
							out.write("}");
						}else{
							out.write("},");
						}
					}
				}else{
					System.out.println("没有获取到数据");
				}
			}else{
				System.out.println("用户名为空");
			}
			request.getSession().setAttribute("sqlPageList", sqlPageHashSet);
			out.write("]");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
