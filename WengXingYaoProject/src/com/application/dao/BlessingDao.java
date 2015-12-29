package com.application.dao;

import java.util.List;

import com.application.entity.Blessing;

public interface BlessingDao {

	/**
	 * ���ף��
	 * 
	 * @param blessing
	 *            ף��ʵ��
	 * @return
	 */
	public abstract boolean addBlessing(Blessing blessing);

	/**
	 * ��ҳ��ʾף��
	 * 
	 * @param sql
	 *            sql���
	 * @param startPoint
	 *            ��ʼ��
	 * @param pageSize
	 *            ÿҳ��ʾ����
	 * @return
	 */
	public abstract List<Blessing> fetchBlessingByPage(String sql,
			int startPoint, int pageSize);
	
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
