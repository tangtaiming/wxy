package com.application.biz;

import java.util.List;

import com.application.entity.Comment;

/**
 * 评论业务层
 * 
 * @author 唐太明
 * 
 */
public interface CommentBiz {

	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return int
	 */
	public abstract int addComment(Comment comment);

	/**
	 * 分页查询评论
	 * 
	 * @param currentPage
	 *            当前页
	 * @param everyPage
	 *            每页显示数量
	 * @return
	 */
	public abstract List<Comment> fetchComment(Integer currentPage,
			Integer everyPage, Integer essayId);

}
