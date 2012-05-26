/**
 * 
 */
package com.dao;

import java.sql.ResultSet;

import com.bean.Version;
import com.db.Db;

/**
 * @author tjy
 *
 */
public class VersionDo {
	
	public Version getVersionInfo(){
		Version v=new Version();
		String sql = "select * from version_info";
		Db db=new Db();
		ResultSet rs=db.executeQuery(sql);
		
		try{
			while(rs.next())
			{
				v.setID(rs.getString("ID"));
				v.setIp(MyUtility.int2Ip(rs.getInt("ip_addr")));
				v.setHardware_main(rs.getInt("hardware_main"));
				v.setHardware_sub(rs.getInt("hardware_sub"));
				
				v.setSoftware_main(rs.getInt("software_main"));
				v.setSotfware_sub(rs.getInt("software_sub"));
			}
		}catch(Exception e){
			//
			System.out.println("error:"+e.toString());
			return null;
		}
		
		return v;
	}
	
	

}
