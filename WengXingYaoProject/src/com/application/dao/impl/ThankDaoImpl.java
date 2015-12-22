package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.application.dao.ThankDao;
import com.application.entity.Thank;
import com.application.util.DBUtil;

public class ThankDaoImpl implements ThankDao {

	private DBUtil dbUtil = DBUtil.getDBUtil();

	private Connection con;

	private PreparedStatement pre;

	private ResultSet res;

	private String sql;

	public boolean addThank(Thank thank) {

		int isAddThank = 0;
		con = dbUtil.getCon();
		sql = "insert into thank (thankContent, thankTime, thankTitle, creator) values (?, ?, ?, ?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, thank.getContent());
			pre.setString(2, thank.getCreateTime());
			pre.setString(3, thank.getTitle());
			pre.setInt(4, thank.getCreator());
			isAddThank = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------添加感谢‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}

		return isAddThank > 0 ? true : false;
	}

	public boolean deleteThank(int id) {

		int isDeleteThank = 0;
		con = dbUtil.getCon();
		sql = "delete from thank where id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			isDeleteThank = pre.executeUpdate();
		} catch (SQLException e) {
			System.out.println("-------------------查询‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}

		return isDeleteThank > 0 ? true : false;
	}

	public Thank fetchThank(int userId) {

		Thank thank = null;
		con = dbUtil.getCon();
		sql = "select * from thank where creator = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, userId);

			res = pre.executeQuery();
			if (res.next()) {
				thank = new Thank();
				thank.setId(res.getInt("id"));
				thank.setContent(res.getString("thankContent"));
				thank.setCreateTime(res.getString("thankTime"));
				thank.setTitle(res.getString("thankTitle"));
				thank.setCreator(res.getInt("creator"));
			}
		} catch (SQLException e) {
			System.out.println("-------------------查询‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return thank;
	}

}
