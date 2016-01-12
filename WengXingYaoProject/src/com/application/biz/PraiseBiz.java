package com.application.biz;

import java.util.List;

import com.application.entity.Praise;

public interface PraiseBiz {
	
	/**
	 * ���������
	 * 
	 * @param praise
	 * @return
	 */
	public abstract boolean addPraise(Praise praise);

	/**
	 * �޸�������
	 * 
	 * @param praise
	 * @return
	 */
	public abstract boolean updatePraise(Praise praise);

	/**
	 * ����IP��ѯʵ������
	 * 
	 * @param ip
	 * @return
	 */
	public abstract List<Praise> fetchPraiseByIp(String ip);
	
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
	
	/**
	 * ����ף��id ��ѯʵ�������Ƿ����
	 * @param blessingId
	 * @return
	 */
	public abstract boolean fetchPraiseByBlessingIdForBoolean(int blessingId, String ip);
	
}
