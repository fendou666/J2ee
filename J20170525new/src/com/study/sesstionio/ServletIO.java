package com.study.sesstionio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletIO")
public class ServletIO extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	
	/*private String getName(String readInfo){
		
	}
*/	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("请求serverlet 上传文件");
		ServletInputStream sis = req.getInputStream();
		byte [] b= new byte[1024];
		int l = 0;
		String readInfo = "";
		//BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file)); 
		
		while((l=sis.read(b))!=-1){
			readInfo = new String(b);
			System.out.println(readInfo);
		}
		sis.close();
		resp.getWriter().write("上传成功");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
