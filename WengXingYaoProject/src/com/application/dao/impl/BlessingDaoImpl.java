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

	public Blessing fetchBlessingById(int id) {

		Blessing blessing = null;
		con = dbUtil.getCon();
		sql = "select * from Blessing where id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			res = pre.executeQuery();
			if (res.next()) {
				blessing = getBlessing(blessing, res);
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------ID查询祝福‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return blessing;
	}

	// public static void main(String[] args) {
	// Blessing blessing = new Blessing();
	// blessing.setId(25);
	// blessing.setBleContent("翁我喜欢你!");
	// blessing.setBleTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	// blessing.setBleIp("192.168.220.41");
	// blessing.setBleName("一个默默的游客");
	// blessing.setPraise(0);
	// blessing.setPraiseNumber(0);
	//
	// BlessingDao blessingDao = new BlessingDaoImpl();
	// System.out.println(blessingDao.updateBlessing(blessing));
	// }

	public boolean updateBlessing(Blessing blessing) {

		boolean isUpdate = true;
		con = dbUtil.getCon();
		sql = "update Blessing set " + "bleContent = ?, bleTime = ?, "
				+ "bleIp = ?, bleName = ?, " + "praise = ?, praiseNumber = ? "
				+ "where id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, blessing.getBleContent());
			pre.setString(2, blessing.getBleTime());
			pre.setString(3, blessing.getBleIp());
			pre.setString(4, blessing.getBleName());
			pre.setInt(5, blessing.getPraise());
			pre.setInt(6, blessing.getPraiseNumber());
			pre.setInt(7, blessing.getId());
			isUpdate = pre.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			System.out
					.println("-------------------修改祝福‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isUpdate;
	}

	public boolean deleteBlessing(int id) {

		boolean isDelete = true;
		con = dbUtil.getCon();
		sql = "delete from Blessing where id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			isDelete = pre.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			System.out
					.println("-------------------删除祝福‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isDelete;
	}

	public List<Blessing> fetchBlessingSortByPraise(int start, int end) {
		List<Blessing> blessingLists = null;
		con = dbUtil.getCon();
		sql = "SELECT * FROM Blessing order by praiseNumber desc limit ?, ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, start);
			pre.setInt(2, end);
			res = pre.executeQuery();
			blessingLists = new ArrayList<Blessing>();
			while(res.next()) {
				Blessing blessing = new Blessing();
				blessing = getBlessing(blessing, res);
				blessingLists.add(blessing);
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------赞数量排序查询祝福‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return blessingLists;
	}

	private Blessing getBlessing(Blessing blessing, ResultSet res)
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
		return blessing;
	}

}
