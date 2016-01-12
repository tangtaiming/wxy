package com.application.entity;

import java.io.Serializable;

/**
 * ÔÞ±í
 * @author ÌÆÌ«Ã÷
 *
 */
public class Praise implements Serializable {

	private static final long serialVersionUID = 420955030355693713L;
	
	private int id;
	
	private int blessingId;
	
	private String ip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlessingId() {
		return blessingId;
	}

	public void setBlessingId(int blessingId) {
		this.blessingId = blessingId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
