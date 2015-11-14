package com.application.biz;

import java.util.List;

import com.application.entity.Essay;

/**
 * 文章业务接口
 * 
 * @author 唐泰明
 * @version 1.0
 * 
 */
public interface EssayBiz {

	/**
	 * 添加文章
	 * @param essay
	 * @return int表示获取是否成功
	 */
	public abstract int addEssay(Essay essay);
	
	/**
	 * 分页显示文章
	 * @param currentPage
	 * @param everyPage
	 * @param totalCurrent
	 * @return 文章集合
	 */
	public abstract List<Essay> fetchEssayPage(int currentPage, int everyPage, int totalCurrent);
	
	/**
	 * ID查询文章数据
	 * @param id
	 * @return
	 */
	public abstract Essay fetchEssayById(int id);
	
}
