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
		String sql = null;
		sql = "select * from essay order by id limit ?, ?";
		return essayDao.fetchEssayByPage(sql, currentPage, everyPage);
	}

	public Essay fetchEssayById(int id) {
		return essayDao.fetchEssayById(id);
	}

}
