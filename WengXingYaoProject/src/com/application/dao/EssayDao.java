package com.application.dao;

import java.util.List;

import com.application.entity.Essay;
import com.application.util.Page;

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
	 * @param pageFirst
	 *            ��ǰҳ��һ������λ��
	 * @param pageLast
	 *            ��ǰҳ���һ������λ��
	 * @return
	 */
	public abstract List<Essay> fetchEssayByPage(int pageFirst, int pageLast);
	
	/**
	 * ��ȡ����������
	 * @return
	 */
	public abstract int fetchEssayCount();

}
