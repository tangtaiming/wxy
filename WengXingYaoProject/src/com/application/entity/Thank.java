package com.application.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Thank implements Serializable {

	//id
	private int id;
	
	//����
	private String content;
	
	//����ʱ��
	private String createTime;
	
	//������
	private int creator;
	
	//����
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
