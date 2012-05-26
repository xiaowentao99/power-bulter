<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>智能管家——新器件集成</title>
<link href="css/style.css" rel="stylesheet">
</head>

<body>
<div class="block">
	<h1>智能管家V1.0</h1>
    <ul class="nav">
        		<li><a href="#" >策略查看</a></li>
            <li><a href="realData.jsp" >实时数据</a></li>
            <li><a href="#">EB评估</a></li>
            <li><a href="#">历史数据</a></li>
            <li><a href="newDevice1.jsp" class="on">新器件集成</a></li>
            <li><a href="userSettingDo.jsp" >用户设置</a></li>
            <li><a href="systemInfo.jsp">系统信息</a></li>
     </ul>
    <div class="content">
		<div class="setting_t guide_t">第一步</div>
		<div class="setting_cont guide_count">
           <img src="images/first.png">
		   <div class="guide">
		   	   <p>请将智能插座插入墙面上的插孔，然后单击“下一步”</p>
			   <a href="newDevice2.jsp" id="next" class="step setp_1">下一步</a>
		   </div>
		   <div class="clear"></div>	
		</div>

    </div>
</div>
</body>
	
</html>
