package com.application.entity;

import java.io.Serializable;

/**
 * 祝福
 * @author 唐太明
 * @version 1.0
 */
public class Blessing implements Serializable {

	private static final long serialVersionUID = 8666487985424667218L;
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 祝福内容
	 */
	private String bleContent;
	/**
	 * 祝福发布时间
	 */
	private String bleTime;
	/**
	 * 祝福发布IP地址
	 */
	private String bleIp;
	/**
	 * 网名
	 */
	private String bleName;
	/**
	 * 赞
	 */
	private int praise;
	/**
	 * 赞总数量
	 */
	private int praiseNumber;
	
	private String praiseStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBleContent() {
		return bleContent;
	}

	public void setBleContent(String bleContent) {
		this.bleContent = bleContent;
	}

	public String getBleTime() {
		return bleTime;
	}

	public void setBleTime(String bleTime) {
		this.bleTime = bleTime;
	}

	public String getBleIp() {
		return bleIp;
	}

	public void setBleIp(String bleIp) {
		this.bleIp = bleIp;
	}

	public String getBleName() {
		return bleName;
	}

	public void setBleName(String bleName) {
		this.bleName = bleName;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public int getPraiseNumber() {
		return praiseNumber;
	}

	public void setPraiseNumber(int praiseNumber) {
		this.praiseNumber = praiseNumber;
	}

	public String getPraiseStatus() {
		return praiseStatus;
	}

	public void setPraiseStatus(String praiseStatus) {
		this.praiseStatus = praiseStatus;
	}

}
