package com.hhit.db;

import java.util.*;
import java.sql.*;

public class DbOperator {
	private Connection con = null;
	public boolean isConnect() {//////////////////////////////////是否连接
		try {
			if ((con == null) || (con.isClosed())) {
				return false;
			} else {
				return true;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	public void connect() throws Exception {///////////////////////////连接
		Properties pro=new Properties();
		pro.load(this.getClass().getClassLoader().getResourceAsStream("com/hhit/db/zroadbconfig.ini"));
		String drivert=pro.getProperty("driver");
		String url=pro.getProperty("url");
		String database=pro.getProperty("databasename");
		//System.out.println("databasename="+database);
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		Class.forName(pro.getProperty("driver")).newInstance();
		con = java.sql.DriverManager
				.getConnection(
						"jdbc:mysql://127.0.0.1:3306/power_bulter",
						"root","root"
					//	url+"/"+database,
					//	url,
					//	user,password
						);
	}

	public void disConnect() {////////////////////////////////////////断开连接
		try {
			con.setAutoCommit(false);
			con.close();
		} catch (Exception e) {
			return;
		}
	}
	public ResultSet executeQuery(String selectSQL) throws SQLException {///////////////////////查找
		//System.out.println(selectSQL);
		ResultSet RS = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			RS = stmt.executeQuery(selectSQL);
		} catch (SQLException ex) {
			throw ex;
		}
		return RS;
	}

	public int executeDb(String sql) throws Exception {//////////////////////更新、添加和删除
		int num = -1;


		Statement stmt = null;
		stmt = con.createStatement();
		num = stmt.executeUpdate(sql);
		stmt.close();///立即释放此 Statement 对象的数据库和 JDBC 资源，而不是等待该对象自动关闭时发生此操作。
		return num;
	}
	public void commit() throws Exception {////////////////////////////////////
		con.commit();//使自从上一次提交/回滚以来进行的所有更改成为持久更改，并释放此 Connection 对象当前保存的所有数据库锁定。
		////from API
	}

	public void rollback() {
		try {
			con.rollback();////取消设置给定 Savepoint 对象之后进行的所有更改。 
                            //此方法应该只在已禁用自动提交时使用。 

		} catch (Exception e) {
			return;
		}
	}
	public static void main (String[] args) 
		throws Exception
		{
		DbOperator dbo=new DbOperator();
		try
		{
			dbo.connect();
			System.out.println ("OKOK");
		}
		catch(Exception e){
			System.out.println (""+e);
		}
		ResultSet rs=dbo.executeQuery("SELECT * FROM chengjibiao");////////////////
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		rs.close();
		dbo.disConnect();
    }


}
