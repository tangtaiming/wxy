package com.application.entity;

import java.io.Serializable;

/**
 * ף��
 * @author ��̫��
 * @version 1.0
 */
public class Blessing implements Serializable {

	private static final long serialVersionUID = 8666487985424667218L;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ף������
	 */
	private String bleContent;
	/**
	 * ף������ʱ��
	 */
	private String bleTime;
	/**
	 * ף������IP��ַ
	 */
	private String bleIp;
	/**
	 * ����
	 */
	private String bleName;
	/**
	 * ��
	 */
	private int praise;
	/**
	 * ��������
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
