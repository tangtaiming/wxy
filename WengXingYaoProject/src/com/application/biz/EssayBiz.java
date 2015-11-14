package com.application.biz;

import java.util.List;

import com.application.entity.Essay;

/**
 * ����ҵ��ӿ�
 * 
 * @author ��̩��
 * @version 1.0
 * 
 */
public interface EssayBiz {

	/**
	 * �������
	 * @param essay
	 * @return int��ʾ��ȡ�Ƿ�ɹ�
	 */
	public abstract int addEssay(Essay essay);
	
	/**
	 * ��ҳ��ʾ����
	 * @param currentPage
	 * @param everyPage
	 * @param totalCurrent
	 * @return ���¼���
	 */
	public abstract List<Essay> fetchEssayPage(int currentPage, int everyPage, int totalCurrent);
	
	/**
	 * ID��ѯ��������
	 * @param id
	 * @return
	 */
	public abstract Essay fetchEssayById(int id);
	
}
