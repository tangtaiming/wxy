package com.application.dao;

import java.util.List;

import com.application.entity.Comment;

/**
 * ���۽ӿ����ݲ�
 * 
 * @author ��̫��
 *
 */
public interface CommentDao {

	/**
	 * �������
	 * @param comment
	 * @return int
	 */
	public abstract int addComment(Comment comment);
	
	/**
	 * �޸�����
	 * @param comment
	 * @return int
	 */
	public abstract int updateComment(Comment comment);
	
	/**
	 * ��ҳ��ѯ����
	 * @return
	 */
	public abstract List<Comment> fetchComment(String sql, Integer currentPage, Integer everyPage, Integer essayId);
	
	/**
	 * ��ѯ����������
	 * @return
	 */
	public abstract int fetchCommentCount(Integer essayId);
	
}
