<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%=new Date() %>
<%
	for(int i=0;i<20;i++){
		System.out.println("i:" +i);
	}
%>