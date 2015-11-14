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

	public List<Essay> fetchEssayPage(int currentPage, int everyPage, int totalCurrent) {
		int selectCount = essayDao.fetchEssayCount();	//获取最新文章数量
		String sql = null;
		if (selectCount > totalCurrent) {
			sql = "";
		} else {
			sql = "select * from essay order by id limit ?, ?";
		}
				
		
		return null;
	}

	public Essay fetchEssayById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
