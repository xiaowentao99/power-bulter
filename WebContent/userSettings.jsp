<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>智能管家--用户设置</title>
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#confirm").click(function(){
		if($("#username").val()==""){
			alert("请填写用户名");
			$("#username").focus();
			return;
		}
		else if($("#password").val()==""){
			alert("请填写密码");
			$("#password").focus();
			return;
		}
		else if($("#topassword").val() != $("#password").val()){
			alert("两次密码不匹配，请检查");
			$("#password").focus();
			return;
		}
		else if($("#nid").val()==""){
			alert("请填写IP");
			$("#nid").focus();
			return;
		}
					
		$("#userUpdateForm").submit();
	});
	$("#clear").click(function(){
		$("#username").val("");
		$("#password").val("");
		$("#topassword").val("");
		$("#nid").val("");
	});
});
</script>
</head>
<%
String name=request.getParameter("user");
User user=(new com.dao.UserDo()).userInfoQueryByName(name);
%>
<body>
<div class="block">
	<h1>智能管家V1.0</h1>
    <ul class="nav">
        	<li><a href="#" >策略查看</a></li>
            <li><a href="realData.jsp" >实时数据</a></li>
            <li><a href="#">EB评估</a></li>
            <li><a href="#">历史数据</a></li>
            <li><a href="newDevice1.jsp">新器件集成</a></li>
            <li><a href="userSettingDo.jsp" class="on">用户设置</a></li>
            <li><a href="systemInfo.jsp">系统信息</a></li>
     </ul>
    <div class="content">
		<div class="setting_t">用户设置</div>
		<div class="setting_cont">
           <img src="images/setting.png">
		   <form action="userUpdateDo.jsp" method="get" id="userUpdateForm">
		   		<div class="inform" ><label for="username">用户名:</label> <input type="text" name="username" id="username" value="<%=user.getName() %>"> </div>
				<div class="inform" ><label for="password">密码:</label> <input type="password" name="password" id="password" value="<%=user.getPasswd() %>"> </div>
				<div class="inform" ><label for="topassword">确认密码:</label> <input type="password" id="topassword"> </div>
				<div class="inform" ><label for="nid">网络IP:</label> <input type="text" name="nid" id="nid" value="<%=user.getIp_address() %>"> </div>
				<div class="inform">
					<a class="makepic login_b bg" href="javascript:void(0)" id="confirm">确认</a>
					<a class="makepic login_b bg" href="javascript:void(0)" id="clear">重置</a> 
					<div class="clear"></div>
				</div>
		   </form>	
		   <div class="clear"></div>	
		</div>

    </div>
</div>
</body>
	
</html>
