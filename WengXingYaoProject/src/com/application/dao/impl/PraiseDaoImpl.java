package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.application.dao.PraiseDao;
import com.application.entity.Praise;
import com.application.util.DBUtil;
import com.application.util.PrintUtil;

public class PraiseDaoImpl implements PraiseDao {

	private DBUtil dbUtil = DBUtil.getDBUtil();

	private Connection con;

	private PreparedStatement pre;

	private ResultSet res;

	private String sql;

	// public static void main(String[] args) {
	// PraiseDao praiseDao = new PraiseDaoImpl();
	// Praise praise = new Praise();
	// praise.setBlessingId(28);
	// praise.setIp("192.168.220.42");
	// PrintUtil.printUtil(praiseDao.addPraise(praise));
	// PrintUtil.printUtil(praise);
	// Praise praise = praiseDao.fetchPraise("192.168.220.44");
	// praise.setIp("192.168.220.40");
	// System.out.println(praiseDao.updatePraise(praise));
	//
	// PrintUtil.printUtil(praiseDao.deletePraise(2));
	// }

	public boolean addPraise(Praise praise) {
		boolean isAdd = true;
		int id = 0;
		con = dbUtil.getCon();
		sql = "insert into praise (blessingId, ip) values (?, ?)";
		try {
			pre = con.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setInt(1, praise.getBlessingId());
			pre.setString(2, praise.getIp());

			isAdd = pre.executeUpdate() > 0 ? true : false;
			res = pre.getGeneratedKeys();
			if (res.next()) {
				id = res.getInt(1);
				praise.setId(id);
			}
		} catch (SQLException e) {
			System.out.println("-------------------ÃÌº”‘ﬁ°Æ“Ï≥£°Ø-------------------");
			isAdd = false;
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return isAdd;
	}

	public boolean updatePraise(Praise praise) {

		boolean isUpdate = true;
		con = dbUtil.getCon();
		sql = "update praise set blessingId = ?, ip = ? where id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, praise.getBlessingId());
			pre.setString(2, praise.getIp());
			pre.setInt(3, praise.getId());
			isUpdate = pre.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			System.out.println("-------------------–ﬁ∏ƒ‘ﬁ°Æ“Ï≥£°Ø-------------------");
			isUpdate = false;
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isUpdate;
	}

	public List<Praise> fetchPraise(String ip) {
		List<Praise> praiseLists = null;
		con = dbUtil.getCon();
		sql = "select * from praise where ip = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, ip);
			res = pre.executeQuery();
			praiseLists = new ArrayList<Praise>();
			while (res.next()) {
				Praise praise = new Praise();
				praise = new Praise();
				praise.setId(res.getInt("id"));
				praise.setBlessingId(res.getInt("blessingId"));
				praise.setIp(res.getString("ip"));
				praiseLists.add(praise);
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------ip≤È—Ø‘ﬁ°Æ“Ï≥£°Ø-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return praiseLists;
	}

	public boolean deletePraise(int id, int blessingId) {
		boolean isDelete = true;
		con = dbUtil.getCon();
		sql = "delete from praise where id = ? and blessingId = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			pre.setInt(2, blessingId);
			isDelete = pre.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			System.out
					.println("-------------------id…æ≥˝‘ﬁ°Æ“Ï≥£°Ø-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isDelete;
	}

	public Praise fetchPraiseByBlessingId(int blessingId, String ip) {
		Praise praise = null;
		con = dbUtil.getCon();
		sql = "select * from praise where blessingId = ? and ip = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, blessingId);
			pre.setString(2, ip);
			res = pre.executeQuery();
			if (res.next()) {
				praise = new Praise();
				praise.setId(res.getInt("id"));
				praise.setBlessingId(res.getInt("blessingId"));
				praise.setIp(res.getString("ip"));
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------ipµÿ÷∑ ◊£∏£id ≤È—Ø‘ﬁ°Æ“Ï≥£°Ø-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}
		return praise;
	}

}
