package com.application.dao;

import java.util.List;

import com.application.entity.Essay;

/**
 * �������ݲ�Dao
 * 
 * @author ��̩��
 * @version 1.0
 * 
 */
public interface EssayDao {

	/**
	 * �������
	 * 
	 * @param essay
	 * @return ���ݷ���ֵ�ж��Ƿ���ӳɹ�
	 */
	public abstract int addEssay(Essay essay);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return ���ݷ���ֵ�ж��Ƿ���ӳɹ�
	 */
	public abstract int deleteEssay(int id);

	/**
	 * id ��ѯ ����
	 * 
	 * @param id
	 * @return
	 */
	public abstract Essay fetchEssayById(int id);

	/**
	 * �������id ��ѯ����
	 * 
	 * @param foreignId
	 * @return
	 */
	public abstract List<Essay> fetchEssayByForeignId(int foreignId);

	/**
	 * �޸�����
	 * 
	 * @param essay
	 * @return
	 */
	public abstract int updateEssay(Essay essay);

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @param sql���
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @param everyPage
	 *            ÿҳ��ʾ������
	 * @return
	 */
	public abstract List<Essay> fetchEssayByPage(String sql, int currentPage,
			int everyPage);

	/**
	 * ��ȡ����������
	 * 
	 * @return
	 */
	public abstract int fetchEssayCount();

}
