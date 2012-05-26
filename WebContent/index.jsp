<%@page import="com.bean.RealTimeData"%>
<%@page import="com.dao.RealDataDo"%>
<%@page import="com.dao.VersionDo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
this is the first page

next is the data from database:</br>
<%! com.bean.Version v = new VersionDo().getVersionInfo(); %>
<% if(v != null) { %>
Hardware Version:V<%=v.getHardware_main()%>.<%=v.getHardware_sub() %> </br>
Software Version:V<%=v.getSoftware_main()%>.<%=v.getSotfware_sub()%> </br>
<% } else {%>
no data </br>
<% } %>
</br>
</br>
实时数据：
</br>
<%
int[] devices=new int[2];
devices[0]=1;
devices[1]=2;
List[] devicesDatalist=(RealDataDo.getDeviceRealData(devices,0,0));

for(int i=0;i<devicesDatalist.length;i++){
	List<RealTimeData> datalist=devicesDatalist[i];
//	for(int j=0;j<datalist.size();j++){
		
//	}
	for(Iterator<RealTimeData> realdata=datalist.iterator();realdata.hasNext();){
		RealTimeData rtd=realdata.next();
%>
<%=rtd.getId() %>------<%=rtd.getDev_id() %>----<%=rtd.getTime_s() %>---<%=rtd.getSample_data() %></br>
<%
	}
}
%>
<%=RealDataDo.getDeviceRealDataJson(devices,0,0) %>
</body>
</html>