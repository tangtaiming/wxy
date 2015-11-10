package com.application.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.application.dao.UserDao;
import com.application.entity.User;
import com.application.service.UserService;

public class Test {
	
	private static UserDao userDao;
	private static UserService us;
	
	@BeforeClass
	public static void init() {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
		us = (UserService) app.getBean("userService");
	}
	
	@org.junit.Test
	public void registerUser() {
		User user = new User();
		user.setUserName("wengxingyao");
		user.setPassword("Wengxingyao123");
		user.setEmail("1252575758@qq.com");
		user.setPhone("15211636823");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setCreateData(format.format(Calendar.getInstance().getTime()));
		System.out.println(us.register(user));
	}
	
	@org.junit.Test
	public void fetchUser() {
//		User user = new User();
//		System.out.println(userDao.fetchIsUserTrue("wengxingyao1111"));
	}
	
	@org.junit.Test
	public void loginUser() {
//		User user = new User();
//		System.out.println(userDao.fetchUser("tangtaiming1", "Tangtaiming123"));
	}
	
	@org.junit.Test
	public void deleteUser() {
//		userDao.deleteUser("ttttt");
	}
	
}
