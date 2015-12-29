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
	 * @param pageNumber ��ǰҳ
	 * @param pageSize ÿҳ��ʾ����
	 * @return 
	 */
	public abstract List<Blessing> fetchBlessingByPage(int pageNumber, int pageSize);
	
	/**
	 * ����ף������
	 * @return
	 */
	public abstract int fetchBlessingCount();
	
	/**
	 * ID��ѯף��
	 * @param id
	 * @return
	 */
	public abstract Blessing fetchBlessingById(int id);
	
	/**
	 * �޸�ף������
	 * @param blessing
	 * @return
	 */
	public abstract boolean updateBlessing(Blessing blessing);
	
	/**
	 * ����IDɾ��ף������
	 * @param id
	 * @return
	 */
	public abstract boolean deleteBlessing(int id);
	
}
