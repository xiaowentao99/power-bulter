/**
 * 
 */
package com.db;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author tjy
 *
 */
public class AddRealData {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		int i=0,target=1;
////		String sql="";
////		Db db=new Db();
////		
////		while(i++<target){
////			sql="insert into real_data(time,dev,value) values("+System.currentTimeMillis()+",1,"
////		+(0.2+i)+")";
////			System.out.println(sql);
////			db.executeUpdate(sql);
////		}
//		
////		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
////		java.util.Date utilDate=new java.util.Date();
////		java.sql.Date sqlDate= new java.sql.Date(utilDate.getTime());
////		 java.sql.Time sTime=new java.sql.Time(utilDate.getTime());   
////		java.sql.Timestamp stp=new java.sql.Timestamp(utilDate.getTime()); 
////		System.out.println(f.format(utilDate));
////		
////		System.out.println(f.format(sqlDate));
////		System.out.println(f.format(sTime));
////		System.out.println(f.format(stp));
////		System.out.println(utilDate.getTime());
////		System.out.println(f.format(1336872616656L));
//		/*
//		 * it will print as follw:
//		 * 2012-05-12 11:31:36
//		   2012-05-12 11:31:36
//		   2012-05-12 11:31:36
//		   2012-05-12 11:31:36
//		 * */
//		//int[] deviceId={1,2};
////		Random random0=new Random();
////		Random random1=new Random();
////		Random random2=new Random();
////		Random random3=new Random();
////		Db db=new Db();
////		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
////		String sql="";
////		int j=20;
////		for(int i=0;i<j;i++){
////			sql="insert into real_data(time,dev,data_type,value) values('"
////		+f.format(new java.util.Date().getTime()+(i*60*3+0)*1000)+"',"+1+","+0+","+(random0.nextInt()%10/10+0.8)+")";
////			db.executeUpdate(sql);
////		}
////		for(int i=0;i<j;i++){
////			sql="insert into real_data(time,dev,data_type,value) values('"
////		+f.format(new java.util.Date().getTime()+(i*60*3+42)*1000)+"',"+2+","+0+","+(random1.nextInt()%10/10+0.1)+")";
////			db.executeUpdate(sql);
////		}
////		for(int i=0;i<j;i++){
////			sql="insert into real_data(time,dev,data_type,value) values('"
////		+f.format(new java.util.Date().getTime()+(i*60*3+13)*1000)+"',"+4+","+0+","+(random2.nextInt()%10/10+1)+")";
////			db.executeUpdate(sql);
////		}
////		for(int i=0;i<j;i++){
////			sql="insert into real_data(time,dev,data_type,value) values('"
////		+f.format(new java.util.Date().getTime()+(i*60*3+28)*1000)+"',"+3+","+0+","+(random3.nextInt()%10/10+1.9)+")";
////			db.executeUpdate(sql);
////		}
////		long ti=System.currentTimeMillis();
////
////		 int lastId=(int)(ti%80L);
////		 System.out.println(lastId);
//		java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		long ti=System.currentTimeMillis();
//		int lastId=(int)(ti%100);
//		if(lastId<50) lastId+=50;
//		String json="[\"value\":";
//		com.db.Db db=new com.db.Db();
//
//			String sql="insert into real_data(time,dev,data_type,value) values('"+f.format(new java.util.Date().getTime())+"',1,0,"+lastId+")";
//			db.executeUpdate(sql);
//		//sql="select UNIX_TIMESTAMP(time) as cat_time,value from real_data where value = "+lastId;
//		//java.sql.ResultSet rs=db.executeQuery(sql);
//		//if(rs.next()){
//			json+=""+lastId;
//			json+=",\"time\":"+ti;
//			json+="]";
//		//}
//		System.out.println(json);
//	//	out.println(json);
//	}

}
