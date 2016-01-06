package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.application.dao.UserDao;
import com.application.entity.User;
import com.application.util.DBUtil;
import com.application.util.PrintUtil;

/**
 * �û�����Daoʵ��
 * 
 * @author ��̩��
 * @version 1.0
 * 
 */
public class UserDaoImpl implements UserDao {

	private DBUtil dbUtil = DBUtil.getDBUtil();

	private Connection con;
	private PreparedStatement pre;
	private ResultSet res;
	private String sql;

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		PrintUtil.printUtil(userDao.fetchUser("tangtaiming", "Tangtaiming1"));
	}

	public User fetchUser(String userName, String password) {
		User user = null;

		con = dbUtil.getCon();
		sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, password);
			res = pre.executeQuery();

			if (res.next()) {
				user = new User();
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("userName"));
				user.setPassword(res.getString("password"));
				user.setPhone(res.getString("phone"));
				user.setEmail(res.getString("email"));
				user.setCreateData(res.getString("createData"));
				user.setLoginData(res.getString("loginData"));
				user.setLoginAccount(res.getInt("loginAccount"));
				user.setUpLoginData(res.getString("upLoginData"));
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------�˺�/�����ѯ���ݡ��쳣��-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return user;
	}

	public boolean fetchIsUserTrue(String userName) {
		boolean isUserTrue = false;

		sql = "SELECT * FROM user WHERE userName = ?";
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			res = pre.executeQuery();

			if (res.next()) {
				isUserTrue = true;
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------�˺Ų�ѯ�û��Ƿ���ڡ��쳣��-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return isUserTrue;
	}

	public int addUser(User user) {
		int isAddTrue = 0; // �Ƿ���ӳɹ� Ĭ�� 0 ���ɹ�

		sql = "insert into user(userName, password, phone, "
				+ "email, createData, loginAccount) "
				+ "value (?, ? , ?, ?, ?, ?)";
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			pre.setString(3, user.getPhone());
			pre.setString(4, user.getEmail());
			pre.setString(5, user.getCreateData());
			pre.setInt(6, user.getLoginAccount());

			isAddTrue = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------����û����쳣��-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}

		return isAddTrue;
	}

	public int deleteUser(String userName) {
		int isDeleteTrue = 0; // Ĭ��û��ɾ��

		sql = "delete from user where userName = ?";
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);

			isDeleteTrue = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------�����˺�ɾ�����ݡ��쳣��-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isDeleteTrue;
	}

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	public User fetchUserById(int id) {
		
		User user = null;
		sql = "select * from user where id = ?";
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			res = pre.executeQuery();
			if (res.next()) {
				user = new User();
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("userName"));
				user.setPassword(res.getString("password"));
				user.setPhone(res.getString("phone"));
				user.setEmail(res.getString("email"));
				user.setCreateData(res.getString("createData"));
				user.setLoginData(res.getString("loginData"));
				user.setLoginAccount(res.getInt("loginAccount"));
				user.setUpLoginData(res.getString("upLoginData"));
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------����û����쳣��-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return user;
	}

	@Override
	public List<User> fetchUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
