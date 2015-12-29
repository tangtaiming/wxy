package com.application.dao;

import com.application.entity.Thank;

public interface ThankDao {

	/**
	 * ��Ӹ�л
	 * @param thank
	 * @return boolean
	 */
	public abstract boolean addThank(Thank thank);
	
	/**
	 * ɾ����л
	 * @param id
	 * @return
	 */
	public abstract boolean deleteThank(int id);
	
	/**
	 * id��ѯ
	 * @param userId ������id
	 * @return
	 */
	public abstract Thank fetchThank(int userId);
	
	/**
	 * �޸ĸ�л
	 * @param thank
	 * @return
	 */
	public abstract boolean updateThank(Thank thank);
	
}
