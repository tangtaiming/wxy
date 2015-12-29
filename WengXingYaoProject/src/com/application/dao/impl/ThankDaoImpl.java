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

//	public static void main(String[] args) {
//		Thank thank = new Thank();
//		thank.setId(2);
//		thank.setContent("我很喜欢她,我不会幽默的说笑.我只是一个默默无闻的程序员,我想用我的方式来给我自己喜欢的人一种特别的烂漫,这个网址是我为她做的,我想用我所学的东西来证明我是喜欢她的,现在是以后也是!");
//		thank.setCreateTime("2015-12-07 22:17:46");
//		thank.setTitle("神奇的大傻子");
//		thank.setCreator(1);
//		
//		ThankDao thankDao = new ThankDaoImpl();
//		thankDao.updateThank(thank);
//	}

	public boolean updateThank(Thank thank) {

		boolean isUpdate = true;
		con = dbUtil.getCon();
		sql = "update thank set " + "thankContent = ?, thankTime = ?, "
				+ "creator = ?, thankTitle = ? " + "where id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, thank.getContent());
			pre.setString(2, thank.getCreateTime());
			pre.setInt(3, thank.getCreator());
			pre.setString(4, thank.getTitle());
			pre.setInt(5, thank.getId());
			isUpdate = pre.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			System.out
					.println("-------------------添加感谢‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isUpdate;
	}

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
