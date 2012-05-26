<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>智能管家——策略查看</title>
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript">
$(function () {
        Highcharts.setOptions({
            global: {
                useUTC: true
            }
        });
    
        var chart1;
        chart1 = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'spline',
                marginRight: 10,
                events: {
                    load: function() {
                        // set up the updating of the chart each second
                       // var series = this.series[0];
                         var series = this.series[0];
                        setInterval(function() {
                        	//alert("data.");
                        	$.getJSON("realtimedata.jsp", function(data){
                        		//alert(data.value);
								var x = (new Date()).getTime(), // current time
                                y =data.value;
                           	 	series.addPoint([x, y], true, true);});
                        }, 1000);
                    }
                }
            },
            title: {
                text: ''
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: '实时能耗曲线'
                },
				style:{
				    width:'200px',
				},
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
			
			  plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, 'rgba(2,0,0,0)']
                        ]
                    },
                    lineWidth: 1,
                    marker: {
                        enabled: false,
						
                        states: {
                            hover: {
                                enabled: true,
                                radius: 5
                            }
                        }
                    },
                    shadow: false,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    }
                }
            },
            series: [{
				type: 'spline',
            
				data: (function() {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;
    
                    for (i = -30; i <= 0; i++) {
                        data.push({
                            x: time + i * 1000,
                            y: Math.random()*100
                        });
                    }
                    return data;
                })()
            }]
        });
		
		
		
		 var chart2;
        chart2 = new Highcharts.Chart({
            chart: {
                renderTo: 'temperature',
                type: 'spline',
                marginRight: 10,
                events: {
                    load: function() {
                        // set up the updating of the chart each second
                        var series = this.series[0];
                        setInterval(function() {
                        	$.getJSON("realtimedata.jsp", function(data){
                        		//alert(data.value);
								var x = (new Date()).getTime(), // current time
                                y =data.value;
                           	 	series.addPoint([x, y], true, true);});
                        }, 2000);
                    }
                }
            },
            title: {
               text: ''
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: '实时温度曲线'
                },
				style:{
				    width:'200px',
				},
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
			
			  plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, 'rgba(2,0,0,0)']
                        ]
                    },
                    lineWidth: 1,
                    marker: {
                        enabled: false,
                        states: {
                            hover: {
                                enabled: true,
                                radius: 5
                            }
                        }
                    },
                    shadow: false,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    }
                }
            },
            series: [{
				type: 'line',
                name: 'Random data',
                data: (function() {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;
    
                    for (i = -20; i <= 0; i++) {
                        data.push({
                            x: time + i * 1000,
                            y: Math.random()*100
                        });
                    }
                    return data;
                })()
            }]
        });
    });

function startTimerAjax(){
	$.getJSON("test.php",function(data){
		});
	}

</script>

</head>

<body>
<div class="block">
	<h1>智能管家V1.0</h1>
    <ul class="nav">
        	<li><a href="javascript:void(0)" >策略查看</a></li>
            <li><a href="javascript:void(0)" class="on">实时数据</a></li>
            <li><a href="javascript:void(0)">EB评估</a></li>
            <li><a href="javascript:void(0)">历史数据</a></li>
            <li><a href="javascript:void(0)">新器件集成</a></li>
            <li><a href="userSettingDo.jsp">用户设置</a></li>
            <li><a href="systemInfo.jsp">系统信息</a></li>
     </ul>
    <div class="content">
    	<div class="content_left">
        	<ul class="leftblock">
            	<li><a id="allview" class="current" href="#">总体视图</a></li>
                <li><a id="oneview" href="#">分类视图</a></li>
            </ul>
            <div class="leftblock">
            	<div class="t">请选择电器</div>
               	<div class="row"> <input type="checkbox" name="devices" id="3"> <label for="xyj">洗衣机</label></div>
                <div class="row"> <input type="checkbox" name="devices" id="1"> <label for="dbx">电冰箱</label></div>
                <div class="row"> <input type="checkbox" name="devices" id="2"> <label for="zld">走廊灯</label></div>
                <div class="row"> <input type="checkbox" name="devices" id="4"> <label for="zykt">中央空调</label></div>
            	
            </div>
            <a id="generPic" href="javascript:void(0)" class="makepic">生成图像</a>
        </div>
        <div class="content_right">
        	<div class="t">所选电器实时状态控制</div>
		

			<div id="container" style="width: 600px; height: 130px; margin: 10px auto"></div>
			<div id="temperature" style="width: 600px; height: 130px; margin: 10px auto 60px"></div>
        </div>
		<div class="clear"></div>
    </div>
</div>
</body>
	<script src="js/highcharts.js"></script>

</html>
