package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.application.dao.CommentDao;
import com.application.entity.Comment;
import com.application.util.DBUtil;

/**
 * 评论接口实现类
 * 
 * @author 唐太明
 * 
 */
public class CommentDaoImpl implements CommentDao {

	private Connection con;
	private PreparedStatement pre;
	private ResultSet res;
	private String sql;

	private DBUtil dbUtil = DBUtil.getDBUtil();

	// public static void main(String[] args) {
	// Comment comment = new Comment();
	// comment.setAddressIp("192.188.220.41");
	// comment.setContent("<h1>content2</h1>");
	//
	// comment.setCreateData(LocalDate.now().atTime(LocalTime.now())
	// .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	// comment.setEssayId(1);
	//
	// CommentDao commentDao = new CommentDaoImpl();
	// System.out.println(commentDao.addComment(comment));
	// }

	public int addComment(Comment comment) {

		int error = 0;
		con = dbUtil.getCon();
		sql = "insert into comment (essayId, createData, content, addressIp) values (?, ?, ?, ?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, comment.getEssayId());
			pre.setString(2, comment.getCreateData());
			pre.setString(3, comment.getContent());
			pre.setString(4, comment.getAddressIp());

			error = pre.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("-------------------添加评论‘异常’-------------------");
			error = -1;
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre);
		}

		return error;
	}

	public int updateComment(Comment comment) {

		return 0;
	}

	public List<Comment> fetchComment(String sql, Integer currentPage,
			Integer everyPage, Integer essayId) {

		List<Comment> comments = new ArrayList<Comment>();
		con = dbUtil.getCon();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, essayId);
			pre.setInt(2, currentPage);
			pre.setInt(3, everyPage);

			res = pre.executeQuery();
			while (res.next()) {
				Comment comment = new Comment();

				comment.setId(res.getInt("id"));
				comment.setEssayId(res.getInt("essayId"));
				comment.setCreateData(res.getString("createData"));
				comment.setContent(res.getString("content"));
				comment.setAddressIp(res.getString("addressIp"));
				comments.add(comment);
			}

			if (comments.size() <= 0) {
				comments = null;
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------分页查询评论‘异常’-------------------");
			e.printStackTrace();
		} finally {
			dbUtil.close(con, pre, res);
		}

		return comments;
	}

	public int fetchCommentCount(Integer essayId) {

		int count = -1;
		con = dbUtil.getCon();
		sql = "select count(*) from comment where essayId = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, essayId);
			res = pre.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			System.out
					.println("-------------------查询评论总数量‘异常’-------------------");
			e.printStackTrace();
		}
		return count;
	}
	
}
