package com.study.servletImg;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckImgAuthCode
 */
@WebServlet("/CheckImgAuthCode")
public class CheckImgAuthCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckImgAuthCode() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pAuthCode = request.getParameter("authCode");
		String sAuthCode = (String)request.getSession().getAttribute("authCode");
		boolean match = false;
		if(pAuthCode==null || pAuthCode.equals("")){
			match = false;
		}else if(sAuthCode==null || sAuthCode.equals("")){
			match = false;
		}else if(pAuthCode.equals(sAuthCode)){
			match = true;
		}else{
			match = false;
		}
		if(match){
			out.write("1");
		}else{
			out.write("0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
