package com.application.entity;

import java.io.Serializable;

/**
 * 评论实体类
 * 
 * @author 唐泰明
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
public class Comment implements Serializable {

	// id
	private int id;
	// 文章id
	private int essayId;
	
	// 评论时间
	private String createData;
	// 评论内容
	private String content;
	// 评论的IP
	private String addressIp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEssayId() {
		return essayId;
	}

	public void setEssayId(int essayId) {
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
