package com.application.dao;

import java.util.List;

import com.application.entity.Blessing;

public interface BlessingDao {

	/**
	 * 添加祝福
	 * 
	 * @param blessing
	 *            祝福实体
	 * @return
	 */
	public abstract boolean addBlessing(Blessing blessing);

	/**
	 * 分页显示祝福
	 * 
	 * @param sql
	 *            sql语句
	 * @param startPoint
	 *            起始点
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	public abstract List<Blessing> fetchBlessingByPage(String sql,
			int startPoint, int pageSize);

}
