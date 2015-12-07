package com.application.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Thank implements Serializable {

	//id
	private int id;
	
	//内容
	private String content;
	
	//创建时间
	private String createTime;
	
	//创建人
	private int creator;
	
	//标题
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
