package com.application.entity;

import java.io.Serializable;
/**
 * 用户实体类
 * 
 * @author 唐泰明
 * @version 1.0
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	//id
	private Integer id;
	//登录账户
	private String userName;	
	//用户密码
	private String password;
	//手机号码
	private String phone;
	//电子邮箱
	private String email;
	//创建时间
	private String createData;
	//登录时间
	private String loginData;
	//登录次数
	private int loginAccount;
	//上次登录时间
	private String upLoginData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateData() {
		return createData;
	}

	public void setCreateData(String createData) {
		this.createData = createData;
	}

	public String getLoginData() {
		return loginData;
	}

	public void setLoginData(String loginData) {
		this.loginData = loginData;
	}

	public int getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(int loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getUpLoginData() {
		return upLoginData;
	}

	public void setUpLoginData(String upLoginData) {
		this.upLoginData = upLoginData;
	}
	
}
