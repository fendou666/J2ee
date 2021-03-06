package com.exercise.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise.java.UserInfo;

public class RankFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("执行filter");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		UserInfo u = (UserInfo)req.getSession().getAttribute("user");
		//System.out.println(req.getRequestURI());
		//System.out.println(req.getRequestURL());
		String URI = req.getRequestURI();
		int lastIndex = URI.lastIndexOf("Vip0");
		int qx = Integer.parseInt(URI.substring(lastIndex+3, lastIndex+5));
		//System.out.println(qx);
		
		if(Integer.parseInt(u.getQx())<qx){
			System.out.println("访问权限不足，去失败页面");
			//req.getRequestDispatcher("WorkAfter/Error.jsp").forward(req, resp);;
			resp.sendRedirect(req.getContextPath()+"/WorkAfter/Error.jsp");
		}else{
			System.out.println("权限足够，可以访问自己要访问的页面");
			System.out.println(req.getRequestURI());
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
