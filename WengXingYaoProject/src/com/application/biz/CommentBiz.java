package com.application.biz;

import java.util.List;

import com.application.entity.Comment;

/**
 * ����ҵ���
 * 
 * @author ��̫��
 * 
 */
public interface CommentBiz {

	/**
	 * �������
	 * 
	 * @param comment
	 * @return int
	 */
	public abstract int addComment(Comment comment);

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @param everyPage
	 *            ÿҳ��ʾ����
	 * @return
	 */
	public abstract List<Comment> fetchComment(Integer currentPage,
			Integer everyPage, Integer essayId);

}
