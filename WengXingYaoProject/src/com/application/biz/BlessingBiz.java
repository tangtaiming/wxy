package com.application.biz;

import java.util.List;

import com.application.entity.Blessing;

public interface BlessingBiz {

	/**
	 * ���ף��
	 * @param blessing ף��ʵ��
	 * @return 
	 */
	public abstract boolean saveBlessing(Blessing blessing);
	
	/**
	 * ��ҳ��ʾ����
	 * @param startPoint ��ǰҳ
	 * @param pageSize ÿҳ��ʾ����
	 * @return 
	 */
	public abstract List<Blessing> fetchBlessingByPage(int pageNumber, int pageSize);
	
}
