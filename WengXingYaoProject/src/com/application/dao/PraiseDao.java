package com.application.dao;

import java.util.List;

import com.application.entity.Praise;

/**
 * �����ݽӿ�
 * @author ��̫��
 *
 */
public interface PraiseDao {

	/**
	 * ���������
	 * @param praise
	 * @return
	 */
	public abstract boolean addPraise(Praise praise);
	
	/**
	 * �޸�������
	 * @param praise
	 * @return
	 */
	public abstract boolean updatePraise(Praise praise);
	
	/**
	 * ����IP��ѯʵ������
	 * @param ip
	 * @return
	 */
	public abstract List<Praise> fetchPraise(String ip);
	
	/**
	 * ����IDɾ����������
	 * @param id
	 * @param blessingId
	 * @return
	 */
	public abstract boolean deletePraise(int id, int blessingId);
	
	/**
	 * ����ף��id ��ѯʵ������
	 * @param blessingId
	 * @return
	 */
	public abstract Praise fetchPraiseByBlessingId(int blessingId, String ip);
	
}
