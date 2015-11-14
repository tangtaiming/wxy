package com.application.util;

/**
 * ��ҳ
 * 
 * @author Administrator
 * 
 */
public class Page {

	private Integer currentPage; // ��ǰҳ
	private Integer totalPage; // ��ҳ��
	private Integer everyPage; // ÿҳ��ʾ����
	private Integer totalCurrent; // �ܼ�¼��
	private Integer showNumber; // ��ʾ��ҳ����
	private boolean isUpPage; // �Ƿ�����һҳ
	private boolean isDownPage; // �Ƿ�����һҳ

	public Page(Integer currentPage, Integer totalPage, Integer everyPage,
			Integer totalCurrent, Integer showNumber, boolean isUpPage,
			boolean isDownPage) {
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.everyPage = everyPage;
		this.totalCurrent = totalCurrent;
		this.showNumber = showNumber;
		this.isUpPage = isUpPage;
		this.isDownPage = isDownPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(Integer everyPage) {
		this.everyPage = everyPage;
	}

	public Integer getTotalCurrent() {
		return totalCurrent;
	}

	public void setTotalCurrent(Integer totalCurrent) {
		this.totalCurrent = totalCurrent;
	}

	public Integer getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(Integer showNumber) {
		this.showNumber = showNumber;
	}

	public boolean isUpPage() {
		return isUpPage;
	}

	public void setUpPage(boolean isUpPage) {
		this.isUpPage = isUpPage;
	}

	public boolean isDownPage() {
		return isDownPage;
	}

	public void setDownPage(boolean isDownPage) {
		this.isDownPage = isDownPage;
	}

}
