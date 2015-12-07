package com.application.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.application.dao.BlessingDao;
import com.application.dao.UserDao;
import com.application.dao.impl.BlessingDaoImpl;
import com.application.entity.Blessing;
import com.application.entity.User;
import com.application.service.UserService;

public class Test {

	private static UserDao userDao;
	private static UserService us;

	public static void init() {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"classpath:applicationContext*.xml");
		us = (UserService) app.getBean("userService");
	}

	
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

	public void addBlessing() {
		BlessingDao blessingDao = new BlessingDaoImpl();
		Blessing blessing = new Blessing();
		blessing.setBleContent("张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号张家港市沙州西路109号");
		blessing.setBleIp("192.168.220.44");
		blessing.setBleName("红孩儿");

		String bleTime = LocalTime.now().atDate(LocalDate.now())
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
		blessing.setBleTime(bleTime);
		blessing.setPraise(0);
		blessing.setPraiseNumber(0);
		System.out.println(blessingDao.addBlessing(blessing));
	}	

	public void fetchUser() {
		// User user = new User();
		// System.out.println(userDao.fetchIsUserTrue("wengxingyao1111"));
	}

	public void loginUser() {
		// User user = new User();
		// System.out.println(userDao.fetchUser("tangtaiming1",
		// "Tangtaiming123"));
	}

	public void deleteUser() {
		// userDao.deleteUser("ttttt");
	}

}
