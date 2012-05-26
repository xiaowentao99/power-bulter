package com.dao; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


import com.bean.RealTimeData;

public  class MyUtility {
//	private static final int SIZEofREALTIMEDATA=40;
//	public static String devicesRealTimeData2Json(List<RealTimeData> rtdList){
//		//as the server is small,I just write this function all by myself without include other jars
//				int i=0;
//				//count the possible size of the json result
//				// more is better than less		
//				//6-4-5-13-5-5-2=40
//				int jsonSize=rtdList.size()*SIZEofREALTIMEDATA;
//				//end of count size of the possible json result
//				StringBuilder sb=new StringBuilder(jsonSize);
//				RealTimeData tmp=null;
//				sb.append("[");
//				for(i=0;i<rtdList.size()-1;i++){
//					tmp=(RealTimeData)rtdList.get(i);//6-4-5-13-5-5-2=40
//					sb.append("{\"I\":").append(tmp.getId()).append(",\"T\":").append(tmp.getTime_s()).append(",\"V\":").append(tmp.getSample_data()).append("},");
//				}
//				//the last object
//				System.out.println(rtdList.size());
//				
//				tmp=(RealTimeData)rtdList.get(i);
//				sb.append("{\"ID\":").append(tmp.getId()).append(",\"T\":").append(tmp.getTime_s()).append(",\"V\":").append(tmp.getSample_data()).append("}]");
//				
//				System.out.println(sb.toString());
//				return sb.toString();
//		}
//	public static String multiDevicesRealTimeData2Json(List<RealTimeData> rtdList){
////as the server is small,I just write this function all by myself without include other jars
//		int i=0;
//		//count the possible size of the json result
//		// more is better than less		
//		//6-4-5-13-5-5-2=40
//		int jsonSize=rtdList.size()*SIZEofREALTIMEDATA;
//		//end of count size of the possible json result
//		StringBuilder sb=new StringBuilder(jsonSize);
//		RealTimeData tmp=null;
//		sb.append("[");
//		for(i=0;i<rtdList.size()-1;i++){
//			tmp=(RealTimeData)rtdList.get(i);//6-4-5-13-5-5-2=40
//			sb.append("{\"I\":").append(tmp.getId()).append(",\"T\":").append(tmp.getTime_s()).append(",\"V\":").append(tmp.getSample_data()).append("},");
//		}
//		//the last object
//		System.out.println(rtdList.size());
//		
//		tmp=(RealTimeData)rtdList.get(i);
//		sb.append("{\"ID\":").append(tmp.getId()).append(",\"T\":").append(tmp.getTime_s()).append(",\"V\":").append(tmp.getSample_data()).append("}]");
//		
//		System.out.println(sb.toString());
//		return sb.toString();
//	}
	
	//for sort
//	private static Comparator<RealTimeData> comparator=new Comparator<RealTimeData>(){
//		public int compare(RealTimeData rtd0,RealTimeData rtd1){
//			if(rtd0==null && rtd1==null) return 0;
//			if(rtd0==null || rtd1 == null) return (rtd0==null?-1:1);
//			if(rtd0.getTime_s()> rtd1.getTime_s()){
//				return (int) (rtd0.getTime_s()-rtd1.getTime_s());
//			}
//			return (int) (rtd0.getTime_s()-rtd1.getTime_s());
//		}
//	};
//	private static void cutData(RealTimeData rtd0,RealTimeData rtd1,RealTimeData rtd_tgt)//the third param is time
//	{
//		//RealTimeData targetRtd= new RealTimeData();
//		//I need to reconsideration the timestamp calculation.
//		double tmp=
//				rtd0.getSample_data()+rtd_tgt.getSample_data()+
//				(rtd1.getSample_data()-rtd0.getSample_data())*(rtd_tgt.getTime_s()-rtd0.getTime_s())/(rtd1.getTime_s()-rtd0.getTime_s());
//		System.out.println("rtd0.getSample_data()="+rtd0.getSample_data());
//		System.out.println("rtd_tgt.getSample_data()="+rtd_tgt.getSample_data());
//		System.out.println("(rtd1.getSample_data()-rtd0.getSample_data())="+(rtd1.getSample_data()-rtd0.getSample_data()));
//		System.out.println("(rtd_tgt.getTime_s()-rtd0.getTime_s())="+(rtd_tgt.getTime_s()-rtd0.getTime_s()));
//		System.out.println("(rtd1.getTime_s()-rtd0.getTime_s())="+(rtd1.getTime_s()-rtd0.getTime_s()));
//		System.out.println("tmp="+(float)tmp);
//		rtd_tgt.setSample_data((float)tmp);
//				
//		//return rtd_tgt;
//	}
	//multi device real data merge
//	public static List<RealTimeData> multiDevicesRealTimeData(List<RealTimeData>[] deviceRtdList){
//		//System.out.println("deviceRtdList.length="+deviceRtdList.length);
//		
//		if(deviceRtdList.length==1) return (List<RealTimeData>)deviceRtdList[0];
//		
//		List<RealTimeData> resList=(List<RealTimeData>)deviceRtdList[0];
//		System.out.println("resList0.size()="+resList.size());
//		for(int i=1;i<deviceRtdList.length;i++){
//			resList=twoDevicesRealTimeData(resList,(List<RealTimeData>)deviceRtdList[i]);
//			System.out.println("resList"+i+".size()="+resList.size());
//			Collections.sort(resList,comparator);//sort for data example cat time
//		}
//		
//		return resList;
//	}
	
	//only two device real data merge
//	private static List<RealTimeData> twoDevicesRealTimeData(List<RealTimeData> list0,List<RealTimeData> list1){
//		if(list1==null && list0 == null) return null;
//		else if(list0 == null || list1==null) return list0 == null?list1:list0;
//		//both are not null
//		List<RealTimeData> resList=new ArrayList<RealTimeData>();
//		
//		//System.out.println("twoDevicesRealTimeData list0.size="+list0.size());
//		//System.out.println("twoDevicesRealTimeData list1.size="+list1.size());
//		
//		RealTimeData zeroRtdData=new RealTimeData();
//		zeroRtdData.setSample_data(0);
//		
//		//List list0=deviceRtdList[0];
//		//List list1=deviceRtdList[1];
//		
//		//if()
//		int i=0,j=0;
//		short flag0=0,flag1=0;
////		while(i<list0.size())
////		{
//			while(i<list0.size() || j<list1.size()){
//				RealTimeData tmpRtd0=(RealTimeData)list0.get(i);
//				RealTimeData tmpRtd1=(RealTimeData)list1.get(j);
//				if(tmpRtd0.getTime_s()<tmpRtd1.getTime_s()){
//					if(j==0) resList.add(tmpRtd0);//the first real time data;
//					else {
////						if(j==0) {
////							cutData(zeroRtdData,tmpRtd1,tmpRtd0);// if list0.size()>=1
////						}
//						//else{
//							cutData((RealTimeData)list1.get(j-1),tmpRtd1,tmpRtd0);//if j>0						
//						//}
//						resList.add(tmpRtd0);
//					}//else
//					i++;
//					if(i==list0.size()){
//						while(j<list1.size()){
//							resList.add((RealTimeData)list1.get(j));
//							j++;
//						}
//						break;
//					}
//					
//				}//if
//				else{
//					if(i==0) resList.add(tmpRtd1);//the first real time data;
//					else {
////						if(i==0) {
////							cutData(zeroRtdData,tmpRtd0,tmpRtd1);// if list0.size()>=1
////						}
////						else{
//							cutData((RealTimeData)list0.get(i-1),tmpRtd0,tmpRtd1);//if j>0						
//						//}
//						resList.add(tmpRtd1);
//					}//else
//					j++;
//					if(j==list1.size()){
//						while(i<list0.size()){
//							resList.add((RealTimeData)list0.get(i));
//							i++;
//						}
//						break;
//					}
//				}
//			}
//		//	break;//add data has been merged,and it should exit the loop.
//			//cutData(list0.get(i),list0.get(i+1),list1.get(i))
//		//}
//		return resList;//merge OK
//	}
	
	public static String int2Ip(int intIp){
		String strIp="";
		int temp=0,i=4;
		// ip[];
		int[] ip=new int[4];
		while(i-- > 0){
			temp= (int)(Math.pow(2, i*8));
			ip[i]=intIp / temp;
			//System.out.println(ip[i]);
			intIp = intIp % temp;
			//System.out.println(ip[i]);
			//intIp-=ip[i];
			//i++;
			if(i>0){
				strIp=strIp+ip[i]+".";
			}else{
				strIp=strIp+ip[i];
			}
		}
				
		return strIp;
	}
	
	public static int ip2Int(String strIp)
	{
		int targetIp=0;
		int i=4;
		//System.out.println(strIp);
		String[] byteArray = new String[4];
		byteArray=strIp.split("[.]",4);
		for(String onebyte :byteArray){
			//System.out.println("byte:"+onebyte);
			targetIp += Integer.parseInt(onebyte)*Math.pow(2,(i-1)*8);
			i--;
		}
		//System.out.println("byteArray:"+byteArray[0]);
		return targetIp;
		
	}
	
//	public static void main(String arg []){
//		System.out.println(MyUtility.ipToInt("127.0.0.1"));
//		System.out.println(MyUtility.intToIp(2130706433));
//	}
}
