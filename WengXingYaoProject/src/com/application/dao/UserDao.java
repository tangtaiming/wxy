package com.application.dao;

import com.application.entity.User;

/**
 * 用户接口实现类
 * 
 * @author 唐泰明
 * @version 1.0
 * 
 */
public interface UserDao {

	/**
	 * 账号/密码查询数据
	 * 
	 * @param userName
	 *            账号
	 * @param password
	 *            密码
	 * @return 用户实体类
	 */
	public abstract User fetchUser(String userName, String password);

	/**
	 * 账号查询用户是否存在
	 * 
	 * @param userName
	 *            账号
	 * @return 存在 true / 不存在 false
	 */
	public abstract boolean fetchIsUserTrue(String userName);

	/**
	 * 添加用户
	 * 
	 * @return 根据返回的值判断成功或者失败，错误的情况
	 */
	public abstract int addUser(User user);

	/**
	 * 根据账号删除数据
	 * 
	 * @param userName
	 *            账号
	 * @return 根据返回的值判断成功或者失败，错误的情况
	 */
	public abstract int deleteUser(String userName);

}
