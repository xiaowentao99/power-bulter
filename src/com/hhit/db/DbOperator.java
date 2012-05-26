package com.hhit.db;

import java.util.*;
import java.sql.*;

public class DbOperator {
	private Connection con = null;
	public boolean isConnect() {//////////////////////////////////�Ƿ�����
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

	public void connect() throws Exception {///////////////////////////����
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

	public void disConnect() {////////////////////////////////////////�Ͽ�����
		try {
			con.setAutoCommit(false);
			con.close();
		} catch (Exception e) {
			return;
		}
	}
	public ResultSet executeQuery(String selectSQL) throws SQLException {///////////////////////����
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

	public int executeDb(String sql) throws Exception {//////////////////////���¡���Ӻ�ɾ��
		int num = -1;


		Statement stmt = null;
		stmt = con.createStatement();
		num = stmt.executeUpdate(sql);
		stmt.close();///�����ͷŴ� Statement ��������ݿ�� JDBC ��Դ�������ǵȴ��ö����Զ��ر�ʱ�����˲�����
		return num;
	}
	public void commit() throws Exception {////////////////////////////////////
		con.commit();//ʹ�Դ���һ���ύ/�ع��������е����и��ĳ�Ϊ�־ø��ģ����ͷŴ� Connection ����ǰ������������ݿ�������
		////from API
	}

	public void rollback() {
		try {
			con.rollback();////ȡ�����ø��� Savepoint ����֮����е����и��ġ� 
                            //�˷���Ӧ��ֻ���ѽ����Զ��ύʱʹ�á� 

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
