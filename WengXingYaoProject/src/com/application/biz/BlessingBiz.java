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
	 * @param pageNumber 当前页
	 * @param pageSize 每页显示数量
	 * @return 
	 */
	public abstract List<Blessing> fetchBlessingByPage(int pageNumber, int pageSize);
	
	/**
	 * 计算祝福数量
	 * @return
	 */
	public abstract int fetchBlessingCount();
	
	/**
	 * ID查询祝福
	 * @param id
	 * @return
	 */
	public abstract Blessing fetchBlessingById(int id);
	
	/**
	 * 修改祝福数据
	 * @param blessing
	 * @return
	 */
	public abstract boolean updateBlessing(Blessing blessing);
	
	/**
	 * 根据ID删除祝福数据
	 * @param id
	 * @return
	 */
	public abstract boolean deleteBlessing(int id);
	
	/**
	 * 祝福根据点赞数量排序
	 * @return
	 */
	public abstract List<Blessing> fetchBlessingSortByPraise();
	
}
