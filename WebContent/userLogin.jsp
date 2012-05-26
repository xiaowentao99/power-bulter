<%@page import="com.dao.UserDo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
String name=request.getParameter("username")!=""?request.getParameter("username"):null;
String passwd=request.getParameter("password")!=""?request.getParameter("password"):null;

if(name==null || passwd ==null){
	response.sendRedirect("error.jsp?errorInfo=EmptyName");
}
if(new UserDo().isValidUser(name,passwd)){
	session.setAttribute("username", name);
	response.sendRedirect("realData.jsp");
}else{
	response.sendRedirect("error.jsp?errorInfo=InvalidName");
}

%>