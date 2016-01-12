package com.application.biz.impl;

import java.util.List;

import com.application.biz.BlessingBiz;
import com.application.dao.BlessingDao;
import com.application.dao.impl.BlessingDaoImpl;
import com.application.entity.Blessing;

public class BlessingBizImpl implements BlessingBiz {

	private BlessingDao blessingDao = new BlessingDaoImpl();
	
	private int startPoint = 0;
	
	public boolean saveBlessing(Blessing blessing) {
		return blessingDao.addBlessing(blessing);
	}

	public List<Blessing> fetchBlessingByPage(int pageNumber, int pageSize) {
		String sql = "select * from Blessing order by bleTime desc limit ?, ?";
		calculateStartPoint(pageNumber, pageSize);
		return blessingDao.fetchBlessingByPage(sql, startPoint, pageSize);
	}
	
	public int fetchBlessingCount() {
		return blessingDao.fetchBlessingCount();
	}
	
	public List<Blessing> fetchBlessingSortByPraise() {
		int start = 0;
		int end = 10;
		return blessingDao.fetchBlessingSortByPraise(start, end);
	}
	
	/**
	 * 计算起始点
	 * @param pageNumber  当前页
	 * @param pageSize	   每页显示数量
	 */
	private void calculateStartPoint(int pageNumber, int pageSize) {
		startPoint = (pageNumber - 1) * pageSize;
	}

	public Blessing fetchBlessingById(int id) {
		return blessingDao.fetchBlessingById(id);
	}

	public boolean updateBlessing(Blessing blessing) {
		return blessingDao.updateBlessing(blessing);
	}

	public boolean deleteBlessing(int id) {
		return blessingDao.deleteBlessing(id);
	}

}
