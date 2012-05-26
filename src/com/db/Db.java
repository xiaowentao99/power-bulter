package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hhit.db.DbOperator;

public  class Db {
	
	public  ResultSet executeQuery(String selectSQL){
		System.out.println(selectSQL);
		ResultSet rs=null;
		DbOperator dbop= new DbOperator();
		if(!dbop.isConnect())
		{
			try{
				dbop.connect();
			}catch(Exception e)
			{
				//do something
				//i think it is necessary to log the error info
				System.out.println("Error:"+e.toString());
				dbop.disConnect();
				return null;
			}
		}
		
		//it is connect to db
		try{
			rs=dbop.executeQuery(selectSQL);
		}catch(SQLException e)
		{
			//query error
			System.out.println("Error:"+e.toString());
			dbop.disConnect();
			rs=null;
		}
		//dbop.disConnect();
		return rs;
	} 
	public  int  executeQueryCount(String selectSQL,String colString){
		ResultSet rs=null;
		int result=0;
		DbOperator dbop= new DbOperator();
		if(!dbop.isConnect())
		{
			try{
				dbop.connect();
			}catch(Exception e)
			{
				//do something
				//i think it is necessary to log the error info
				System.out.println("connect db Error:"+e.toString());
				dbop.disConnect();
				return 0;
			}
		}
		
		//it is connect to db
		try{
			rs=dbop.executeQuery(selectSQL);
		}catch(SQLException e)
		{
			//query error
			System.out.println("executeQuery Error:"+e.toString());
			dbop.disConnect();
			rs=null;
			return 0;
		}
		try{
			if(rs.next()){
				result=rs.getInt(colString);
			}else{
				return 0;
			}
			
		}catch(Exception e)
		{
			//
			System.out.println("get result Error:"+e.toString());
			dbop.disConnect();
			return 0;
		}
		//rs=null;
		//dbop.disConnect();
		return result;
	} 
	
	public int executeUpdate(String sql) {
		System.out.println(sql);
		int result=0;
		DbOperator dbop= new DbOperator();
		if(!dbop.isConnect())
		{
			try{
				dbop.connect();
			}catch(Exception e)
			{
				//do something
				//i think it is necessary to log the error info
				System.out.println("Error:"+e.toString());
				dbop.disConnect();
				return 0;
			}
		}
		
		//it is connect to db
		try{
			result=dbop.executeDb(sql);
		}catch(Exception e)
		{
			//query error
			System.out.println("Error:"+e.toString());
			dbop.disConnect();
			return 0;
		}
		//dbop.disConnect();
		return result;
	}
	

}
