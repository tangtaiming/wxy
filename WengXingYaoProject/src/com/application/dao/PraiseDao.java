package com.application.dao;

import java.util.List;

import com.application.entity.Praise;

/**
 * 赞数据接口
 * @author 唐太明
 *
 */
public interface PraiseDao {

	/**
	 * 添加赞数据
	 * @param praise
	 * @return
	 */
	public abstract boolean addPraise(Praise praise);
	
	/**
	 * 修改赞数据
	 * @param praise
	 * @return
	 */
	public abstract boolean updatePraise(Praise praise);
	
	/**
	 * 根据IP查询实体数据
	 * @param ip
	 * @return
	 */
	public abstract List<Praise> fetchPraise(String ip);
	
	/**
	 * 根据ID删除点赞数据
	 * @param id
	 * @param blessingId
	 * @return
	 */
	public abstract boolean deletePraise(int id, int blessingId);
	
	/**
	 * 根据祝福id 查询实体数据
	 * @param blessingId
	 * @return
	 */
	public abstract Praise fetchPraiseByBlessingId(int blessingId, String ip);
	
}
