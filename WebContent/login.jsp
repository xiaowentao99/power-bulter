<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎进入智能管家系统</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#confirm').click(function(){
		if($('#username').val()=='')
			{
				alert("请输入用户名");
				$('#username').focus();
				return;
			}
		 if($('#password').val()=='')
			{
				alert("请输入密码");
				$('#password').focus();
				return;
			}
		$('#loginForm').submit();
	});
	$('#clear').click(function(){
		$('#username').val('');
		$('#password').val('');
	});
	
});
</script>
<style>
html,body,div,h1,ul,li,a{ padding:0px; margin:0px; font-size:12px;}
ul{ list-style:none;}
a{ text-decoration:none; color:#000;}
.block{
		width:980px; 
		margin:0 auto;
		background:#5c9dff;
		-moz-border-radius:50px;
	    -webkit-border-radius:50px;
		border-radius:50px;
		padding-bottom:2px;
		}
h1{
	font-weight:normal;
	font-size:20px;
	padding:10px 0px 10px 30px;
	}

.nav{
	width:900px;
	margin:0 auto;
	-moz-border-radius:50px 50px 0 0;
	-webkit-border-radius:50px 50px 0 0;
	border-radius:50px 50px 0 0;
	background:#fe962c;
	height:31px;
	}
.nav li{ float:left;}
.nav li a{ display:block; float:left; width:90px; text-align:center; height:23px; line-height:23px; color:#000; margin-top:4px; background:#fff; margin-left:20px; -moz-border-color:#000;
	-moz-border-radius:50px;
	-webkit-border-radius:50px;
	border-radius:50px;
	-moz-box-shadow:1px 1px 1px #6a5e51;
	-webkit-border-shadow:1px 1px 1px #6a5e51;
	}
.nav li a.on{
	background:#abb3e4;
	}
.nav li a:hover{
	background:#abb3e4;
	}
.content{
	width:900px;
	margin:0 auto;
	-moz-border-radius:0 0 50px 50px;
	-webkit-border-radius:0 0 50px 50px;
	border-radius:0 0 50px 50px;
	background:#e8e8e8;
	
	}
.content_left{
	width:195px;
	float:left;
	padding-bottom:50px;
	}
.leftblock{
	width:150px;
	margin:10px auto;
	background:#6396c0;
	-moz-border-radius:20px;
	-webkit-border-radius:20px;
	border-radius:20px;
	-moz-box-shadow:1px 1px 1px #6a5e51;
	-webkit-border-shadow:1px 1px 1px #6a5e51;
	}
.leftblock li{
	padding-top:10px;
	}
.leftblock li a,.makepic{
	 width:120px; margin:0px auto; text-align:center; height:23px; line-height:23px;
	 background:#fff;
	display:block;
	-moz-border-radius:20px;
	-webkit-border-radius:20px;
	border-radius:20px;
	-moz-box-shadow:2px 2px 1px #6a5e51;
	-webkit-border-shadow:2px 2px 1px #6a5e51;
	}
.leftblock li a:hover{ color:#F60;background:#ffff32;}
.leftblock li a.current{ background:#ffff32;}
.leftblock:nth-child(1){ padding-bottom:20px;}
.leftblock .row:last-child{ padding-bottom:106px;}
.t{ padding:15px;}
.row{ height:23px; margin:5px 0px; padding-left:15px;}
.row input,.row label{ float:left;}
.row input{ padding:5px;}
.row label{ display: block; background:#fff; border:1px solid #666; width:70px; text-align:center; height:20px; line-height:20px; cursor:pointer;}
.makepic{ border:1px solid #d3e3da;-moz-box-shadow:none;
	-webkit-border-shadow:none;}
.makepic:hover{color:#F60;}

.content_right{ float:left; border:1px solid #add863;
		-moz-border-radius:0 150px 0 150px;
	    -webkit-border-radius:0 150px 0 150px;
	     border-radius:0 150px 0 150px;
		 margin-top:10px;
		 width:680px;
		}
.content_right:after{ clear:both; content:"."; height:0px; display:block;}
.clear{ height:0px; clear:both;}
.login{ width:280px; padding-top:23px; padding-bottom:30px; margin:80px auto 120px;
		-moz-border-radius:50px 0 50px 0;
	    -webkit-border-radius:50px 0 50px 0;
	     border-radius:50px 0 50px 0;
		 background:#4376a1; }
.login_b{ width:85px; float:left; margin-left:24px;}
.inform{ padding-left:15px;margin-top:16px;}
.inform label{ width:64px; text-align:right; display:block; float:left; height:21px; line-height:21px; }
</style>
</head>

<body>
<div class="block">
	<h1>智能管家V1.0</h1>
	<div class="login">
	<form action="userLogin.jsp" method="post" id="loginForm">
		<div class="inform" ><label for="username">用户名:</label> <input type="text" id="username" name="username"> </div>
		<div class="inform" ><label for="password">密码:</label> <input type="text" id="password" name="password"> </div>
		<div class="inform">
		<a class="makepic login_b" href="javascript:void(0)" id="confirm">确认</a>
		<a class="makepic login_b" href="javascript:void(0)" id="clear">重置</a> 
		<div class="clear"></div>
		</div>
	</form>
	</div>  
</div>
</body>
	
</html>
