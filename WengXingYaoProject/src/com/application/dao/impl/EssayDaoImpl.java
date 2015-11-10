package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.application.dao.EssayDao;
import com.application.entity.Essay;
import com.application.util.DBUtil;

public class EssayDaoImpl implements EssayDao {

	private Connection con;
	private PreparedStatement pre;
	private ResultSet res;
	private String sql;
	
	private DBUtil dbUtil = DBUtil.getDBUtil();
	
	public static void main(String[] args) {
		Essay essay = new Essay();
		essay.setTitle("小明");
		essay.setUser("");
	}
	
	public int addEssay(Essay essay) {
		int isAddEssay = 0;
		
		con = dbUtil.getCon();
		sql = "insert into essay(user, title, click, "
				+ "issueData, writer, color, "
				+ "description, keywords, body)";
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
			con.commit();
		} catch (SQLException e) {
			System.out.println("-------------------添加文章‘异常’-------------------");
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			isAddEssay = -2;		//异常
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}
		return isAddEssay;
	}
	
	public int deleteEssay(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Essay fetchEssayById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Essay> fetchEssayByForeignId(int foreignId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateEssay(Essay essay) {
		// TODO Auto-generated method stub
		return 0;
	}

}
