package com.application.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.UserBiz;
import com.application.biz.impl.UserBizImpl;
import com.application.entity.User;
import com.application.util.MapData;
import com.application.util.PrintUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/user")
@SessionAttributes(value = {"message", "loginUser"})
public class UserService {
	
	private UserBiz userBiz = new UserBizImpl();
	
	private Gson gson = new Gson();

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String inRegister(Map<String, Object> request) {
		request.put("user", new User());
	
		return "/admin/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(User user, Map<String, Object> request) {
		System.out.println("yes");
		Map<String, Object> message = new HashMap<String, Object>();
		if (userBiz.register(user)) {
			MapData.and(message, "status", "999");
			request.put("message", gson.toJson(message));
			return "/admin/message";
		}
		MapData.and(message, "status", -1);
		request.put("message", gson.toJson(message));
		return "/admin/message";
	}
	
	/**
	 * 用户进入登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login(Map<String, Object> request) {
		return "/admin/login";
	}
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password, Map<String, Object> request) {
		System.out.println(userName + "\t" + password);
		User user = new User();
		Map<String, Object> userMessage = new HashMap<String, Object>();
		user.setUserName(userName);
		user.setPassword(password);
		userMessage = userBiz.login(user);
		PrintUtil.printUtil(userMessage);
		
		Gson gson = new Gson();
		String message = gson.toJson(userMessage);
		System.out.println(message.toString());
		request.put("message", message);
		if (userMessage.get("user") !=null) {
			request.put("loginUser", userMessage.get("user"));
		}
		return "/admin/message";
	}
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager(Map<String, Object> request) {
		PrintUtil.printUtil(request.get("loginUser"));
		return "/manager/index";
	}
	
	/**
	 * 进入主页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> request) {
		return "/index";
	}
	
}
