package com.application.dao;

import java.util.List;

import com.application.entity.Essay;
import com.application.util.Page;

/**
 * 文章数据层Dao
 * 
 * @author 唐泰明
 * @version 1.0
 * 
 */
public interface EssayDao {

	/**
	 * 添加文章
	 * 
	 * @param essay
	 * @return 根据返回值判断是否添加成功
	 */
	public abstract int addEssay(Essay essay);

	/**
	 * 删除文章
	 * 
	 * @param id
	 * @return 根据返回值判断是否添加成功
	 */
	public abstract int deleteEssay(int id);

	/**
	 * id 查询 文章
	 * 
	 * @param id
	 * @return
	 */
	public abstract Essay fetchEssayById(int id);

	/**
	 * 评论外键id 查询文章
	 * 
	 * @param foreignId
	 * @return
	 */
	public abstract List<Essay> fetchEssayByForeignId(int foreignId);

	/**
	 * 修改文章
	 * 
	 * @param essay
	 * @return
	 */
	public abstract int updateEssay(Essay essay);

	/**
	 * 分页查询文章
	 * 
	 * @param pageFirst
	 *            当前页第一条数据位置
	 * @param pageLast
	 *            当前页最后一条数据位置
	 * @return
	 */
	public abstract List<Essay> fetchEssayByPage(int pageFirst, int pageLast);
	
	/**
	 * 获取文章总数量
	 * @return
	 */
	public abstract int fetchEssayCount();

}
