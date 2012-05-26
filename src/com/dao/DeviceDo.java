/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Device;
import com.db.Db;

/**
 * @author tjy
 *
 */
public class DeviceDo {
	
	public int deviceAdd(Device dev)
	{
		String sql="insert into device(type,desc,fps_soc) values("+dev.getDevice_type()+",'"+dev.getDesc()+"',"+dev.getFps_soc()+")";
		Db db=new Db();
		return db.executeUpdate(sql);
	}
	
	public int setDevice(Device dev)
	{
		String sql="update device set type="+dev.getDevice_type()+",desc='"+dev.getDesc()+"',fps_soc="+dev.getFps_soc()+" where ID = "+dev.getId();
		Db db=new Db();
		return db.executeUpdate(sql);
	}
	
	public List<Device> getDeviceByType(String type){
		//String[] deviceType = new String
		List<Device> list = new ArrayList<Device>();
		
		String sql="";
		if("soc".equals(type)){
			sql="select * from device where type = 1";//1:soc,2:fps
		}else if("fps".equals(type)){
			sql="select * from device where type = 2";//1:soc,2:fps
		}else{
			System.out.println("no such device type");
			return null;
		}
		Db db= new Db();
		ResultSet rs=db.executeQuery(sql);
		try{
			while(rs.next()){
				
				Device dev=new Device();
				dev.setId(rs.getInt("ID"));
				dev.setDevice_type(rs.getShort("rtpe"));
				dev.setDesc(rs.getString("desc"));
				dev.setFps_soc(rs.getShort("fps_soc"));
				
				list.add(dev);
			}
		}catch(Exception e){
			//
			System.out.println("Error:"+e.toString());
		}
		
		return list;
				
	}

}
