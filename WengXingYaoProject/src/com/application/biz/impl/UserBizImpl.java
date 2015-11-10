package com.application.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.application.biz.UserBiz;
import com.application.dao.UserDao;
import com.application.dao.impl.UserDaoImpl;
import com.application.entity.User;

public class UserBizImpl implements UserBiz {
	
	private UserDao userDao = new UserDaoImpl();

	public Map<String, Object> login(User user) {
		Map<String, Object> _map = new HashMap<String, Object>();
		User _user = new User();
		if (user == null) {
			System.out.println("+++++++++++++++++ ����ֵΪ�� +++++++++++++++");
			return null;
		}
		
		String userName = user.getUserName();
		Integer status = -1;		
		if (userDao.fetchIsUserTrue(userName)) {
			status = 1; //1 ��ʾ�û��Ѿ�����״̬
			
			String password = user.getPassword();
			_user = userDao.fetchUser(userName, password);
			if (_user == null) {
				status = 3; //3 ��ʾ��ѯ�û��������
				_map.put("user", null);
			} else {
				status = 999; //999 ��ʾ��ѯ���û�����
				_map.put("user", user);
			}
		} else {
			status = 2; //2 ��ʾ�û�������״̬
			_map.put("user", null);
		}
		
		_map.put("status", status);
		return _map;
	}

	public boolean register(User user) {
		if (user == null) {
			System.out.println("+++++++++++++++++ ����ֵΪ�� +++++++++++++++");
			return false;
		}
		
		//�û��˺�
		String userName = user.getUserName();
		if (userDao.fetchIsUserTrue(userName)) {
			System.out.println("+++++++++++++++++ �û��Ѿ����� +++++++++++++++");
			return false;
		}
		
		//���д���ʱ���ȡ
		String createData = fetchFormatTime("yyyy-MM-dd HH:mm:ss");
		user.setCreateData(createData);
		return userDao.addUser(user) > 0 ? true : false;
		
	}
	
	/**
	 * ��ȡ��ǰʱ�� ��ʽ����ǰʱ��
	 * @param instance ��ʽ�� ��ʽ
	 * @return String �ַ���ʱ��
	 */
	public String fetchFormatTime(String instance) {
		if (instance == null || instance.equals("")) {
			System.out.println("+++++++++++++++++ ����ʱ���쳣 +++++++++++++++");
			return null;
		}
		
		SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(instance);
		return _simpleDateFormat.format(Calendar.getInstance().getTimeInMillis());
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
