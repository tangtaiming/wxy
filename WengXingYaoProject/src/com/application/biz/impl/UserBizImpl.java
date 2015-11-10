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
			System.out.println("+++++++++++++++++ 传入值为空 +++++++++++++++");
			return null;
		}
		
		String userName = user.getUserName();
		Integer status = -1;		
		if (userDao.fetchIsUserTrue(userName)) {
			status = 1; //1 表示用户已经存在状态
			
			String password = user.getPassword();
			_user = userDao.fetchUser(userName, password);
			if (_user == null) {
				status = 3; //3 表示查询用户密码错误
				_map.put("user", null);
			} else {
				status = 999; //999 表示查询到用户数据
				_map.put("user", user);
			}
		} else {
			status = 2; //2 表示用户不存在状态
			_map.put("user", null);
		}
		
		_map.put("status", status);
		return _map;
	}

	public boolean register(User user) {
		if (user == null) {
			System.out.println("+++++++++++++++++ 传入值为空 +++++++++++++++");
			return false;
		}
		
		//用户账号
		String userName = user.getUserName();
		if (userDao.fetchIsUserTrue(userName)) {
			System.out.println("+++++++++++++++++ 用户已经存在 +++++++++++++++");
			return false;
		}
		
		//进行创建时间获取
		String createData = fetchFormatTime("yyyy-MM-dd HH:mm:ss");
		user.setCreateData(createData);
		return userDao.addUser(user) > 0 ? true : false;
		
	}
	
	/**
	 * 获取当前时间 格式化当前时间
	 * @param instance 格式化 样式
	 * @return String 字符串时间
	 */
	public String fetchFormatTime(String instance) {
		if (instance == null || instance.equals("")) {
			System.out.println("+++++++++++++++++ 传入时间异常 +++++++++++++++");
			return null;
		}
		
		SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(instance);
		return _simpleDateFormat.format(Calendar.getInstance().getTimeInMillis());
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
