package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.application.dao.EssayDao;
import com.application.entity.Essay;
import com.application.util.DBUtil;
import com.application.util.PageUtil;
import com.application.util.Page;
import com.application.util.PrintUtil;

public class EssayDaoImpl implements EssayDao {

	private Connection con;
	private PreparedStatement pre;
	private ResultSet res;
	private String sql;

	private DBUtil dbUtil = DBUtil.getDBUtil();

	public static void main(String[] args) {
//		 Essay essay = new Essay();
//		 essay.setUser("4");
//		 essay.setTitle("4");
//		 essay.setClick(0);
//		
//		 SimpleDateFormat format = new
//		 SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		 String createDate = format.format(System.currentTimeMillis());
//		 essay.setIssueData(createDate);
//		 essay.setWriter("writer");
//		 essay.setColor("red");
//		 essay.setDescription("Description");
//		 essay.setKeywords("keyword");
//		 essay.setBody("body");
//		
//		 EssayDao essayDao = new EssayDaoImpl();
//		 System.out.println(essayDao.addEssay(essay));

		// int id = 2;
		// EssayDao essayDao = new EssayDaoImpl();
		// System.out.println(essayDao.fetchEssayById(2));

//		int currentPage = 2;
//		int everyPage = 1;
//		 
//		EssayDao essayDao = new EssayDaoImpl();
//		int totalPage = essayDao.fetchEssayCount();
//		int showNumber = 1;
////		System.out.println(essayDao.fetchEssayCount());
//		
//		Page page = PageUtil.createPage(currentPage, everyPage, totalPage, showNumber);
//		PrintUtil.printUtil(page);
//		int pageFirst = new PageUtil().currentFirstPage(currentPage, everyPage);
//		int pageLast = new PageUtil().currentLastPage(currentPage, everyPage);
//		
//		
//		String sql = "select * from essay order by id desc limit ?, ?";
//		List<Essay> tempList = essayDao.fetchEssayByPage(sql, currentPage - 1, everyPage);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~start select" + tempList.size());
//		PrintUtil.printUtil(tempList);
		
	}

	public int addEssay(Essay essay) {
		int isAddEssay = 0; // 默认0 表示正常

		con = dbUtil.getCon();
		sql = "insert into essay(user, title, click, "
				+ "issueData, writer, color, "
				+ "description, keywords, body) "
				+ "values (?, ? , ?, ?, ? , ?, ?, ? , ?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, essay.getUser());
			pre.setString(2, essay.getTitle());
			pre.setInt(3, essay.getClick());
			pre.setString(4, essay.getIssueData());
			pre.setString(5, essay.getWriter());
			pre.setString(6, essay.getColor());
			pre.setString(7, essay.getDescription());
			pre.setString(8, essay.getKeywords());
			pre.setString(9, essay.getBody());

			isAddEssay = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------添加文章‘异常’-------------------");
			isAddEssay = -2; // 异常
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isAddEssay;
	}

	public int deleteEssay(int id) {
		con = dbUtil.getCon();
		sql = "delete from essay where id = ?";
		int isDeleteEssay = 0;

		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);

			isDeleteEssay = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------删除文章‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}

		return isDeleteEssay;
	}

	// 如果没有查询到数据返回为null
	public Essay fetchEssayById(int id) {
		Essay tempEssay = null;
		con = dbUtil.getCon();
		sql = "select * from essay where id = ?";

		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			res = pre.executeQuery();

			if (res.next()) {
				tempEssay = getEssay(res);
			}

		} catch (SQLException e) {
			System.out
					.println("-------------------ID获取文章‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return tempEssay;
	}

	public List<Essay> fetchEssayByForeignId(int foreignId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateEssay(Essay essay) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Essay> fetchEssayByPage(String sql, int currentPage, int everyPage) {
		List<Essay> tempEssayList = null;
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, currentPage);
			pre.setInt(2, everyPage);

			res = pre.executeQuery();
			tempEssayList = new ArrayList<Essay>();
			while (res.next()) {
				tempEssayList.add(getEssay(res));
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------分页查询文章‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return tempEssayList;
	}

	public int fetchEssayCount() {
		int count = 0;
		con = dbUtil.getCon();
		sql = "select count(*) from essay";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return count;
	}

	/**
	 * 获取Essay数据
	 * 
	 * @param res
	 * @return
	 * @throws SQLException
	 */
	private Essay getEssay(ResultSet res) throws SQLException {
		Essay tempEssay = new Essay();
		tempEssay.setId(res.getInt("id"));
		tempEssay.setUser(res.getString("user"));
		tempEssay.setTitle(res.getString("title"));
		tempEssay.setClick(res.getInt("click"));
		tempEssay.setIssueData(res.getString("issueData"));
		tempEssay.setWriter(res.getString("writer"));
		tempEssay.setColor(res.getString("color"));
		tempEssay.setDescription(res.getString("description"));
		tempEssay.setKeywords(res.getString("keywords"));
		tempEssay.setBody(res.getString("body"));

		return tempEssay;
	}

}
