<%@page import="com.bean.Version"%>
<%@page import="com.dao.VersionDo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>智能管家--系统设置</title>
<link href="css/style.css" rel="stylesheet">
</head>
<%
Version version=(new VersionDo()).getVersionInfo();
%>
<body>
<div class="block">
	<h1>智能管家V1.0</h1>
    <ul class="nav">
        	<li><a href="#" >策略查看</a></li>
            <li><a href="realData.jsp" >实时数据</a></li>
            <li><a href="#">EB评估</a></li>
            <li><a href="#">历史数据</a></li>
            <li><a href="newDevice1.jsp">新器件集成</a></li>
            <li><a href="userSettingDo.jsp" >用户设置</a></li>
            <li><a href="systemInfo.jsp" class="on">系统信息</a></li>
     </ul>
    <div class="content">
		<div class="setting_t">系统设置</div>
		<div class="setting_cont">
           <p>智能管家出产ID:<%=version.getID() %></p>
		  <!--  <p>注册用户名:myhome123</p> -->
		   <p>内网IP地址:<%=version.getIp() %></p>
		   <p>硬件版本号:V<%=version.getHardware_main() %>.<%=version.getHardware_sub() %></p>
		   <p>软件版本号:V<%=version.getSoftware_main() %>.<%=version.getSotfware_sub() %></p>
		   <div id="success">已连接ENDS!!</div>
		</div>

    </div>
</div>
</body>
	
</html>
