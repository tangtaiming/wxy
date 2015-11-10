package com.application.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ����ӹ�����
 * @author ��̩��
 *
 */
public class DBUtil {
	
	private static DBUtil DBUTIL_SINGLETON;
	
	private DBUtil() {};
	
	public static DBUtil getDBUtil() {
		if (DBUTIL_SINGLETON == null) {
			DBUTIL_SINGLETON = new DBUtil();
		}
		
		return DBUTIL_SINGLETON;
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws SQLException 
	 */
	public Connection getCon() {
		Connection con = null;
		String driverClass = "org.gjt.mm.mysql.Driver";
		String url = "jdbc:mysql://localhost:3306/wxy";
		String user = "tangtaiming";
		String password = "Tangtaiming123";
		
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("-------------------��ȡ���ݿ������쳣-------------------");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * �ر�����
	 * @param con
	 * @param pre
	 * @param res
	 */
	public void close(Connection con, PreparedStatement pre, ResultSet res) {
		
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pre != null) {
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void close(Connection con) {
		this.close(con, (PreparedStatement) null, (ResultSet) null);
	}
	
	public void close(Connection con, PreparedStatement pre) {
		this.close(con, pre, (ResultSet) null);
	}

}
