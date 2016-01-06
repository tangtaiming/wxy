package com.application.biz.impl;

import com.application.biz.ThankBiz;
import com.application.dao.ThankDao;
import com.application.dao.impl.ThankDaoImpl;
import com.application.entity.Thank;

public class ThankBizImpl implements ThankBiz {
	
	private ThankDao thankDao = new ThankDaoImpl();

	/**
	 * false ���ʧ��, true ��ӳɹ�
	 */
	public boolean addThank(Thank thank) {
		if (fetchThank(thank.getCreator()) != null) {
			return false;
		}
		return thankDao.addThank(thank);
	}

	public boolean deleteThank(int id) {
		return thankDao.deleteThank(id);
	}

	public Thank fetchThank(int userId) {
		return thankDao.fetchThank(userId);
	}

	public boolean updateThank(Thank thank) {
		return thankDao.updateThank(thank);
	}

}
