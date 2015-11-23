package com.application.biz.impl;

import java.util.List;

import com.application.biz.CommentBiz;
import com.application.dao.CommentDao;
import com.application.dao.impl.CommentDaoImpl;
import com.application.entity.Comment;

/**
 * 添加评论业务层
 * @author 唐太明
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
