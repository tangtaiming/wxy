package com.application.entity;

import java.io.Serializable;

/**
 * 文章实体类
 * 
 * @author 唐泰明
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Essay implements Serializable {

	// id
	private int id;
	// 发布人
	private String user;
	// 文章标题
	private String title;
	// 点击次数
	private int click; 
	
	// 发布时间
	private String issueData;
	// 作者
	private String writer;
	// 标题颜色
	private String color;
	// 摘要
	private String description;
	// 关键字
	private String keywords;
	// 文章内容
	private String body;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public String getIssueData() {
		return issueData;
	}

	public void setIssueData(String issueData) {
		this.issueData = issueData;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
