package com.application.biz;

import java.util.Map;

import com.application.entity.User;

/**
 * 用户业务层接口
 * 
 * @author 唐泰明
 * @version 1.0
 * 
 */
public interface UserBiz {

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户账号/密码存入实体类中
	 * @return 用户信息/状态
	 */
	public abstract Map<String, Object> login(User user);

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户信息
	 * @return 注册成功 true/ 注册失败 false
	 */
	public abstract boolean register(User user);

}
