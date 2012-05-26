/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.RealTimeData;
import com.db.Db;

/**
 * @author tjy
 *
 */
public class RealDataDo {
	//the lest ID that client request real time data
	
	public static String  getDeviceRealData_Json(int deviceId,short data_type,int lastId,long startTimestamp,int endTimestamp)
	{
		List<RealTimeData> deviceRtdList=getDeviceRealData(deviceId,data_type,lastId,startTimestamp,endTimestamp);
		System.out.println("size="+deviceRtdList.size());
		//List<RealTimeData> rtdList=MyUtility.multiDevicesRealTimeData(deviceRtdList);
		//return MyUtility.multiDevicesRealTimeData2Json(rtdList);
		//String str=MyUtility.multiDevicesRealTimeData2Json(rtdList);
		String str=devicesRealTimeData2Json(deviceRtdList);
		System.out.println(str);
		return str;
		//return null;
	}
	private static final int SIZEofREALTIMEDATA=40;
	public static String devicesRealTimeData2Json(List<RealTimeData> rtdList){
		//as the server is small,I just write this function all by myself without include other jars
				int i=0;
				//count the possible size of the json result
				// more is better than less		
				//6-4-5-13-5-5-2=40
				int jsonSize=rtdList.size()*SIZEofREALTIMEDATA;
				//end of count size of the possible json result
				StringBuilder sb=new StringBuilder(jsonSize);
				RealTimeData tmp=null;
				sb.append("[");
				for(i=0;i<rtdList.size()-1;i++){
					tmp=(RealTimeData)rtdList.get(i);//6-4-5-13-5-5-2=40
					sb.append("{\"I\":").append(tmp.getId()).append(",\"T\":").append(tmp.getTime_s()).append(",\"V\":").append(tmp.getSample_data()).append("},");
				}
				//the last object
				System.out.println(rtdList.size());
				
				tmp=(RealTimeData)rtdList.get(i);
				sb.append("{\"ID\":").append(tmp.getId()).append(",\"T\":").append(tmp.getTime_s()).append(",\"V\":").append(tmp.getSample_data()).append("}]");
				
				System.out.println(sb.toString());
				return sb.toString();
		}
	
//	public static List<RealTimeData>  getDeviceRealData_Object(int[] deviceIds,int lastId,long lastTimestamp)
//	{
//		List<RealTimeData>[] deviceRtdList=getDeviceRealData(deviceIds,lastId,lastTimestamp);
//		//System.out.println("size="+deviceRtdList.length);
//		return MyUtility.multiDevicesRealTimeData(deviceRtdList);
//		//return MyUtility.multiDevicesRealTimeData2Json(rtdList);
//		//String str=MyUtility.multiDevicesRealTimeData2Json(rtdList);
//		//System.out.println(str);
//		//return str;
//		//return null;
//	}
	public static List<RealTimeData> getDeviceRealData(int deviceId,short data_type,int lastId,long startTimestamp,long endTimestamp)
	{
		//int i=0;
		System.out.println(deviceId);
		//System.out.println(lastTimestamp);
		if(deviceId < 0){
			//System.out.println(deviceId);
			return null;
		}
		String startDateTimeStr="";
		String endDateTimeStr="";
		if(startTimestamp!=0){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			startDateTimeStr=sdf.format(startTimestamp);
			if(endTimestamp!=0){
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				endDateTimeStr=sdf.format(endTimestamp);			
			}
		}
		
				
		String sql="";
		Db db = new Db();
		
		List<RealTimeData> list = new ArrayList<RealTimeData>();
		
		sql="select ID,UNIX_TIMESTAMP(time) as cat_time,dev,data_type,value from real_data where dev = "+deviceId+" and data_type = "+data_type;
		if(lastId!=0){
			sql=sql+" and ID > "+lastId;
		}
		if(startTimestamp !=0){
			sql=sql+" and time > '"+startDateTimeStr+"'";
		}
		if(endTimestamp != 0){
			sql=sql+" and time < '"+endDateTimeStr+"'";
		}
		sql=sql+" order by ID";
		
		System.out.println(sql);
		
		ResultSet rs=db.executeQuery(sql);
		
		try{
			while(rs.next())
			{
				RealTimeData rtd=new RealTimeData();
				rtd.setId(rs.getInt("ID"));
				rtd.setTime_s(rs.getLong("cat_time"));
				//rtd.setDev_id(rs.getInt("dev"));
				//rtd.setData_type(rs.getShort("data_type"));
				rtd.setSample_data((float)(rs.getFloat("value")+0.5));
				
				list.add(rtd);
			}
		}catch(Exception e){
			//
			System.out.println("Error:"+e.toString());
			
			return null;
		}
		return list;
	}
	
//	public static List[] getDeviceRealData(int[] deviceIds,int lastId,long lastTimestamp)
//	{
//		int i=0;
//		System.out.println(deviceIds);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String lastDateTimeStr=sdf.format(lastTimestamp);
//		
//		String sql="";
//		Db db = new Db();
//
//		List[] devicesDatalist=new List[deviceIds.length];
//		
//		
//		
//		while(i<deviceIds.length){
//			List<RealTimeData> list = new ArrayList<RealTimeData>();
//			//System.out.println("deviceIds:"+deviceIds[i]);
//			//when get out of the database ,the time change to timestamp
//			sql="select ID,UNIX_TIMESTAMP(time) as cat_time,dev,data_type,value from real_data where dev = "+deviceIds[i];
//			if(lastId!=0){
//				sql=sql+" and ID > "+lastId;
//			}
//			if(lastTimestamp !=0){
//				sql=sql+" and time > '"+lastDateTimeStr+"'";
//				//sql="select ID,UNIX_TIMESTAMP(time) as cat_time,dev,data_type,value from real_data where dev = "+deviceIds[i]+" order by ID";
//			}
//			sql=sql+" order by ID limit 0,20";
//			//here need to sort for that merge the device real time data
//			
//			System.out.println(sql);
//			ResultSet rs=db.executeQuery(sql);
//			try{
//				while(rs.next())
//				{
//					RealTimeData rtd=new RealTimeData();
//					rtd.setId(rs.getInt("ID"));
//					rtd.setTime_s(rs.getLong("cat_time"));
//					rtd.setDev_id(rs.getInt("dev"));
//					rtd.setData_type(rs.getShort("data_type"));
//					rtd.setSample_data((float)(rs.getFloat("value")+0.5));
//					
//					list.add(rtd);
//				}
//			}catch(Exception e){
//				//
//				System.out.println("Error:"+e.toString());
//				
//				return null;
//			}
//			
//			devicesDatalist[i]=list;;
//			i++;
//		}
//		System.out.println(devicesDatalist.length);
//		return devicesDatalist;
//	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] devices=new int[2];
//		devices[0]=1;
//		devices[1]=2;
//		//System.out.println("devices.size="+devices.length);
//		
//		List[] list=getDeviceRealData(devices,0,0);
//
//	//System.out.println(getDeviceRealDataJson(devices,0,0));
//	}

}
