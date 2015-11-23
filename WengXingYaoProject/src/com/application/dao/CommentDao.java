package com.application.dao;

import java.util.List;

import com.application.entity.Comment;

/**
 * 评论接口数据层
 * 
 * @author 唐太明
 *
 */
public interface CommentDao {

	/**
	 * 添加评价
	 * @param comment
	 * @return int
	 */
	public abstract int addComment(Comment comment);
	
	/**
	 * 修改评论
	 * @param comment
	 * @return int
	 */
	public abstract int updateComment(Comment comment);
	
	/**
	 * 分页查询评论
	 * @return
	 */
	public abstract List<Comment> fetchComment(String sql, Integer currentPage, Integer everyPage, Integer essayId);
	
	/**
	 * 查询评论总数量
	 * @return
	 */
	public abstract int fetchCommentCount(Integer essayId);
	
}
