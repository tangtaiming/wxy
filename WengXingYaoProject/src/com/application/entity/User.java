package com.application.entity;

import java.io.Serializable;
/**
 * �û�ʵ����
 * 
 * @author ��̩��
 * @version 1.0
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	//id
	private Integer id;
	//��¼�˻�
	private String userName;	
	//�û�����
	private String password;
	//�ֻ�����
	private String phone;
	//��������
	private String email;
	//����ʱ��
	private String createData;
	//��¼ʱ��
	private String loginData;
	//��¼����
	private int loginAccount;
	//�ϴε�¼ʱ��
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
