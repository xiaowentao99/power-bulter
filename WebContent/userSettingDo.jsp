<%@page import="com.dao.UserDo"%>
<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<%
String username=session.getAttribute("username")==null?"":(String)session.getAttribute("username");
if(username=="")
	response.sendRedirect("error.jsp?errorInfo=IllegalUser");
else response.sendRedirect("userSettings.jsp?user="+username);
//User user=(new UserDo()).userInfoQueryByName(username);
%>
</body>
</html>