package com.application.biz;

import java.util.List;

import com.application.entity.Blessing;

public interface BlessingBiz {

	/**
	 * 添加祝福
	 * @param blessing 祝福实体
	 * @return 
	 */
	public abstract boolean saveBlessing(Blessing blessing);
	
	/**
	 * 分页显示数据
	 * @param startPoint 当前页
	 * @param pageSize 每页显示数量
	 * @return 
	 */
	public abstract List<Blessing> fetchBlessingByPage(int pageNumber, int pageSize);
	
}
