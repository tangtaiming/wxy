package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.application.dao.BlessingDao;
import com.application.entity.Blessing;
import com.application.util.DBUtil;

public class BlessingDaoImpl implements BlessingDao {

	private DBUtil dbUtil = DBUtil.getDBUtil();

	private Connection con;

	private PreparedStatement pre;

	private ResultSet res;

	private String sql;

	public boolean addBlessing(Blessing blessing) {
		int addArgee = 0; // 添加是否成功
		con = dbUtil.getCon();
		sql = "insert into Blessing "
				+ "(bleContent, bleTime, bleIp, bleName, praise, praiseNumber) values "
				+ "(?, ?, ?, ?, ?, ?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, blessing.getBleContent());
			pre.setString(2, blessing.getBleTime());
			pre.setString(3, blessing.getBleIp());
			pre.setString(4, blessing.getBleName());
			pre.setInt(5, blessing.getPraise());
			pre.setInt(6, blessing.getPraiseNumber());
			addArgee = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------添加祝福‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}

		return addArgee > 0 ? true : false;
	}

	public List<Blessing> fetchBlessingByPage(String sql, int startPoint,
			int pageSize) {

		List<Blessing> blessingList = new ArrayList<Blessing>();
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, startPoint);
			pre.setInt(2, pageSize);
			res = pre.executeQuery();

			while (res.next()) {
				Blessing tempB = new Blessing();
				getBlessing(tempB, res);
				blessingList.add(tempB);
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------添加祝福‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return blessingList;
	}

	public int fetchBlessingCount() {
		int count = 0; // 数量
		con = dbUtil.getCon();
		sql = "select count(*) from Blessing";

		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------计算祝福数量‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return count;
	}

	private void getBlessing(Blessing blessing, ResultSet res)
			throws SQLException {
		if (blessing == null) {
			blessing = new Blessing();
		}
		blessing.setId(res.getInt("id"));
		blessing.setBleContent(res.getString("bleContent"));
		blessing.setBleIp(res.getString("bleIp"));
		blessing.setBleName(res.getString("bleName"));
		blessing.setBleTime(res.getString("bleTime"));
		blessing.setPraise(res.getInt("praise"));
		blessing.setPraiseNumber(res.getInt("praiseNumber"));
	}

}
