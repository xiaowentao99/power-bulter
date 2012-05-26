<%@page import="com.dao.RealDataDo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
//get the request info
//here need to auth the user name and password
//String id = request.getParameter("lastId");
//String deviceIds = request.getParameter("deviceIds");
//String lastTimeStamp=request.getParameter("lastStamp");

//long lastStamp=0;
//int lastId=0;

//String[] ids = deviceIds.split("#");
//System.out.println(deviceIds);
//int idInt[] = new int[ids.length];
//try{
	//lastStamp=Integer.parseInt(lastTimeStamp);
	//lastId=Integer.parseInt(id);
	
//	for(int i=0;i<ids.length;i++){
//		idInt[i]=Integer.parseInt(ids[i]);	
//		System.out.println(idInt[i]);
//	}	
//}catch(Exception e){

//	System.out.println("parse int error");
//}

 //String resStr= RealDataDo.getDeviceRealDataJson(idInt,lastId,lastStamp);
//int[] idInt ={1,2};
//long ti=System.currentTimeMillis();

// int lastId=(int)(ti%80);
/* if(session.getAttribute("lastId")==null){
	 session.setAttribute("lastId", lastId);
 }else{
	 lastId=Integer.parseInt((String)session.getAttribute("lastId"));
	 System.out.println("lastId="+lastId);
	 lastId++;
	 session.setAttribute("lastId", lastId);
 }
*/
 // String resStr= RealDataDo.getDeviceRealData_Json(idInt,lastId,0);
 //System.out.println("parse OK:"+resStr);
//out.println(resStr);//write the json to client
java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
long ti=System.currentTimeMillis();
int lastId=(int)(ti%100);
if(lastId<50) lastId+=50;
String json="{\"value\":";
com.db.Db db=new com.db.Db();

	String sql="insert into real_data(time,dev,data_type,value) values('"+f.format(new java.util.Date().getTime())+"',1,0,"+lastId+")";
	db.executeUpdate(sql);
//sql="select UNIX_TIMESTAMP(time) as cat_time,value from real_data where value = "+lastId;
//java.sql.ResultSet rs=db.executeQuery(sql);
//if(rs.next()){
	json+=""+lastId;
	json+=",\"time\":"+ti;
	json+="}";
//}
//System.out.println(json);
out.println(json);


%>