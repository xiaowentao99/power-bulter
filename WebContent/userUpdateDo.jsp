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
String name=request.getParameter("username")!=""?request.getParameter("username"):null;
String password=request.getParameter("password")!=""?request.getParameter("password"):null;
String nid=request.getParameter("nid")!=""?request.getParameter("nid"):null;
//String name=request.getParameters("name");
//response.sendRedirect("info.jsp?info="+nid);

if(name==null || password==null || nid==null)
	response.sendRedirect("error.jsp?errorInfo=EmptyData");

User user=new User();
user.setName(name);
user.setPasswd(password);
user.setIp_address(nid);

//response.sendRedirect("info.jsp?info="+nid);

if(new UserDo().userInfoUpdate(user))
{
	response.sendRedirect("info.jsp?info=userUpdateOK");
}else
{
	response.sendRedirect("error.jsp?errorInfo=userUpdateError");
}
%>
</body>
</html>