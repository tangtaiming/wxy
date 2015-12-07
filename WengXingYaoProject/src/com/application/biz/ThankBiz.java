package com.application.biz;

import com.application.entity.Thank;

public interface ThankBiz {

	/**
	 * 添加感谢
	 * @param thank
	 * @return boolean
	 */
	public abstract boolean addThank(Thank thank);
	
	/**
	 * 删除感谢
	 * @param id
	 * @return
	 */
	public abstract boolean deleteThank(int id);
	
	/**
	 * id查询
	 * @param userId 创建人id
	 * @return
	 */
	public abstract Thank fetchThank(int userId);
	
}
