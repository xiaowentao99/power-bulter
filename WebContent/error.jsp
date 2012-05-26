<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Error Info</title>
</head>
<body><%
String errorInfo=request.getParameter("errorInfo")!=""?request.getParameter("errorInfo"):"未知错误";

%>
<%=errorInfo %>
</body>
</html>