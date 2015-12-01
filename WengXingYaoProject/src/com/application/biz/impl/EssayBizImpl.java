package com.application.biz.impl;

import java.util.List;

import com.application.biz.EssayBiz;
import com.application.dao.EssayDao;
import com.application.dao.impl.EssayDaoImpl;
import com.application.entity.Essay;

public class EssayBizImpl implements EssayBiz {

	private EssayDao essayDao = new EssayDaoImpl();

	public int addEssay(Essay essay) {
		return essayDao.addEssay(essay);
	}

	// totalCurrent ���ڲ����������ô��� Ϊ�Ժ��������ص����� ��׼��
	public List<Essay> fetchEssayPage(int currentPage, int everyPage,
			int totalCurrent) {
		int startPlace = initStartPlace(currentPage, everyPage);
		String sql = "select * from essay order by id limit ?, ?";
		return essayDao.fetchEssayByPage(sql, startPlace, everyPage);
	}

	public Essay fetchEssayById(int id) {
		return essayDao.fetchEssayById(id);
	}
	
	/**
	 * ��ʼ����ѯ��ʼ��λ��
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public int initStartPlace(Integer currentPage, Integer pageSize) {
		return (currentPage - 1) * pageSize;
	}

}
