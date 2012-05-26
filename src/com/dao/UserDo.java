package com.dao;

import java.sql.ResultSet;

import com.bean.User;
import com.db.Db;

public class UserDo {
	
	public  boolean isValidUser(String name,String passwd){
		//ResultSet rs=null;
		Db db=new Db();
		String sql="select count(name) as count_user from user_config where name='"+name+"' and password='"+passwd+"'";
		if(db.executeQueryCount(sql,"count_user")==1){
			return true;
		}
		
		return false;
		
		
	}
	public boolean userInfoUpdate(User user)
	{
		Db db=new Db();
		String sql="update user_config set name='"+user.getName()+"',password='"+user.getPasswd()+"',ip_addr="+MyUtility.ip2Int(user.getIp_address());
		
		if(db.executeUpdate(sql)==1) return true;
		
		return false;
		
	}
	
//	public User userInfoQueryById(int id)
//	{
//		User user=new User();
//		ResultSet rs=null;
//		String sql="select * from user_config where id = "+id;
//		Db db=new Db();
//		rs=db.executeQuery(sql);
//		
//		
//		try{
//			while(rs.next()){
//				user.setName(rs.getString("name"));
//				user.setPasswd(rs.getString("password"));
//				user.setIp_address(new Integer(rs.getInt("ip_addr")).toString());
//			}
//		}catch(Exception e)
//		{
//			//
//			return null;
//		}
//		return user;
//	}
//	
	public User userInfoQueryByName(String name)
	{
		User user=new User();
		ResultSet rs=null;
		String sql="select * from user_config where name = '"+name+"'";
		Db db=new Db();
		rs=db.executeQuery(sql);
		
		
		try{
			while(rs.next()){
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("password"));
				user.setIp_address(MyUtility.int2Ip(rs.getInt("ip_addr")));
			}
		}catch(Exception e)
		{
			//
			return null;
		}
		return user;
	}

}
