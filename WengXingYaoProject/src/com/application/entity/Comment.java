package com.application.entity;

import java.io.Serializable;

/**
 * ����ʵ����dddd
 * 
 * @author ��̩��
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
public class Comment implements Serializable {

	// id
	private int id;
	// ����id
	private String essayId;
	
	// ����ʱ��
	private String createData;
	// ��������
	private String content;
	// ���۵�IP
	private String addressIp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEssayId() {
		return essayId;
	}

	public void setEssayId(String essayId) {
		this.essayId = essayId;
	}

	public String getCreateData() {
		return createData;
	}

	public void setCreateData(String createData) {
		this.createData = createData;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddressIp() {
		return addressIp;
	}

	public void setAddressIp(String addressIp) {
		this.addressIp = addressIp;
	}

}