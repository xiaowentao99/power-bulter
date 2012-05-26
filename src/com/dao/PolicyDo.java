/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Fps_policy;
import com.bean.PowerPolicy;
import com.bean.RealTimeData;
import com.bean.Soc_policy;
import com.db.Db;

/**
 * @author tjy
 *
 */
public class PolicyDo {
	private static final int SIZEofPOWERPOLICY=54;
	
	public String latestPolicyJson(){
		List<PowerPolicy> ppList=latestPolicyList();
		return policyList2Json(ppList);
	}
	
	private String policyList2Json(List<PowerPolicy> ppList){
		System.out.println("size="+ppList.size());
		int i=0;
		PowerPolicy tmp=null;
		int jsonSize=ppList.size()*SIZEofPOWERPOLICY;
		StringBuilder sb=new StringBuilder(jsonSize); 
		sb.append("[");
		
		for(i=0;i<ppList.size()-1;i++){
			tmp=(PowerPolicy)ppList.get(i);//6-4-5-13-5-5-2=40
			sb.append("{\"S\":").append(tmp.getStart_time_second()).append(",\"E\":").append(tmp.getEnd_time_second()).append(",\"P\":").append(tmp.getPrice()).append("},");
		}
		tmp=(PowerPolicy)ppList.get(i);
		sb.append("{\"ST\":").append(tmp.getStart_time_second()).append(",\"ET\":").append(tmp.getEnd_time_second()).append(",\"P\":").append(tmp.getPrice()).append("}]");
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public List<PowerPolicy> latestPolicyList()//return the all day policy
	{
		List <PowerPolicy> list=new ArrayList<PowerPolicy>();
		String sql="select * from power_policy";
		Db db=new Db();
		ResultSet rs=db.executeQuery(sql);
		try{
			while(rs.next()){
				PowerPolicy pp=new PowerPolicy();
				pp.setId(rs.getInt("ID"));
				pp.setEnd_time_second(rs.getInt("end_time"));
				pp.setPrice(rs.getFloat("price"));
				pp.setStart_time_second(rs.getInt("start_time"));
				
				list.add(pp);
				//pp=null;
			}
		}catch(Exception e)
		{
			//
			return null;
		}
	//	list.add(arg0);
		
		
		return list;
	}
	
	//fps policy settings
	
	public List<Fps_policy> getFpsPolicyByDeviceId(int id)
	{
		List <Fps_policy> list = new ArrayList<Fps_policy>();
		String sql="select * from fps_exec_policy where dev = "+id;
		Db db = new Db();
		ResultSet rs= db.executeQuery(sql);
		try{
			while(rs.next()){
				Fps_policy fp=new Fps_policy();
				fp.setId(rs.getInt("ID"));
				fp.setStart_time(rs.getInt("start_time"));
				fp.setEnd_time(rs.getInt("end_time"));
				fp.setStatus(rs.getShort("status"));
				fp.setExec_humidity(rs.getInt("exec_humidity"));
				fp.setDevice_id(rs.getInt("dev"));
				//fp.setDevice_name();
				
				list.add(fp);
				
			}
		}catch(Exception e){
			//
			return null;
		}
		
		return list;
	}
	
	public int setFpsPolicyByDevice(Fps_policy fp)
	{
		if(fp ==null) return 0;
		String sql="insert into fps_exec_policy(start_time,end_time,status,exec_humidity,dev) values ("
				+fp.getStart_time()+","+fp.getEnd_time()+","+fp.getStatus()+","+fp.getExec_humidity()+","+fp.getDevice_id()+")";
		Db db=new Db();
		return db.executeUpdate(sql);
	}
	
	
	//soc policy settings
	
	public List<Soc_policy> getSocPolicyByDeviceId(int id)
	{
		List <Soc_policy> list = new ArrayList<Soc_policy>();
		String sql="select * from soc_exec_policy where dev = "+id;
		Db db = new Db();
		ResultSet rs= db.executeQuery(sql);
		try{
			while(rs.next()){
				Soc_policy sp=new Soc_policy();
				sp.setId(rs.getInt("ID"));
				sp.setStart_time(rs.getInt("start_time"));
				sp.setEnd_time(rs.getInt("end_time"));
				sp.setTemp_up(rs.getFloat("temperature_up"));
				sp.setTemp_low(rs.getFloat("temperature_low"));
				sp.setHumidity_up(rs.getFloat("humidity_up"));
				sp.setHumidity_low(rs.getFloat("humidity_low"));
				sp.setNoise_up(rs.getFloat("noise_up"));
				sp.setNoise_low(rs.getFloat("noise_low"));
				sp.setDevice_id(rs.getInt("dev"));
				//fp.setDevice_name();
				
				list.add(sp);
				
			}
		}catch(Exception e){
			//
			return null;
		}
		
		return list;
	}
	
	public int setSocPolicyByDevice(Soc_policy sp)
	{
		if(sp == null) return 0;
		String sql="insert into soc_exec_policy(start_time,end_time,temperature_up,temperature_low,humidity_up,humidity_low,noise_up,noise_low,dev) values ("
				+sp.getStart_time()+","+sp.getEnd_time()+","+sp.getTemp_up()+","+sp.getTemp_low()+","+sp.getHumidity_up()+","+sp.getHumidity_low()
				+","+sp.getNoise_up()+","+sp.getNoise_low()+","+sp.getDevice_id()+")";
		Db db=new Db();
		return db.executeUpdate(sql);
	}
	

}
