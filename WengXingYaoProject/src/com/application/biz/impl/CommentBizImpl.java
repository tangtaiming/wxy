package com.application.biz.impl;

import java.util.List;

import com.application.biz.CommentBiz;
import com.application.dao.CommentDao;
import com.application.dao.impl.CommentDaoImpl;
import com.application.entity.Comment;

/**
 * �������ҵ���
 * @author ��̫��
 *
 */
public class CommentBizImpl implements CommentBiz {

	private CommentDao commentDao = new CommentDaoImpl();
	
	public int addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	public List<Comment> fetchComment(Integer currentPage, Integer everyPage, Integer essayId) {
													 
		String sql = "select * from comment where essayId = ? order by createData desc limit ?, ?";
		return commentDao.fetchComment(sql, currentPage, everyPage, essayId);
	}

}
