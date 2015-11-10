package com.application.biz;

import java.util.Map;

import com.application.entity.User;

/**
 * �û�ҵ���ӿ�
 * 
 * @author ��̩��
 * @version 1.0
 * 
 */
public interface UserBiz {

	/**
	 * �û���¼
	 * 
	 * @param user
	 *            �û��˺�/�������ʵ������
	 * @return �û���Ϣ/״̬
	 */
	public abstract Map<String, Object> login(User user);

	/**
	 * �û�ע��
	 * 
	 * @param user
	 *            �û���Ϣ
	 * @return ע��ɹ� true/ ע��ʧ�� false
	 */
	public abstract boolean register(User user);

}
