package com.application.dao;

import java.util.List;

import com.application.entity.User;

/**
 * �û��ӿ�ʵ����
 * 
 * @author ��̩��
 * @version 1.0
 * 
 */
public interface UserDao {

	/**
	 * �˺�/�����ѯ����
	 * 
	 * @param userName
	 *            �˺�
	 * @param password
	 *            ����
	 * @return �û�ʵ����
	 */
	public abstract User fetchUser(String userName, String password);

	/**
	 * �˺Ų�ѯ�û��Ƿ����
	 * 
	 * @param userName
	 *            �˺�
	 * @return ���� true / ������ false
	 */
	public abstract boolean fetchIsUserTrue(String userName);

	/**
	 * ����û�
	 * 
	 * @return ���ݷ��ص�ֵ�жϳɹ�����ʧ�ܣ���������
	 */
	public abstract int addUser(User user);

	/**
	 * �����˺�ɾ������
	 * 
	 * @param userName
	 *            �˺�
	 * @return ���ݷ��ص�ֵ�жϳɹ�����ʧ�ܣ���������
	 */
	public abstract int deleteUser(String userName);
	
	/**
	 * id ��ѯ�û��Ƿ����
	 * @param id
	 * @return
	 */
	public abstract User fetchUserById(int id);
	
	/**
	 * ��ѯ���� �û�
	 * @return
	 */
	public abstract List<User> fetchUser();

}
