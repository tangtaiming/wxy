package com.application.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.biz.UserBiz;
import com.application.biz.impl.UserBizImpl;
import com.application.entity.User;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value="/user")
public class UserService {
	
	private UserBiz userBiz = new UserBizImpl();

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String inRegister(Map<String, Object> request) {
		request.put("user", new User());
	
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(User user) {
		System.out.println("yes");
		if (userBiz.register(user)) {
			return "redirect:registerMessage";
		}
		return "redirect:registerMessage";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="loginUserName") String userName,
			@RequestParam(value="loginPassword") String password) {
		System.out.println(userName + "\t" + password);
		User user = new User();
		Map<String, Object> userMessage = new HashMap<String, Object>();
		user.setUserName(userName);
		user.setPassword(password);
		userMessage = userBiz.login(user);
		PrintUtil.printUtil(userMessage);
		return "redirect:loginMessage";
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
}
