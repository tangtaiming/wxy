package com.application.util;

/**
 * 分页
 * 
 * @author Administrator
 * 
 */
public class Page {

	private Integer currentPage; // 当前页
	private Integer totalPage; // 总页数
	private Integer everyPage; // 每页显示数量
	private Integer totalCurrent; // 总记录数
	private Integer showNumber; // 显示分页数量
	private Boolean isUpPage; // 是否有上一页
	private Boolean isDownPage; // 是否有下一页

	public Page(Integer currentPage, Integer totalPage, Integer everyPage,
			Integer totalCurrent, Integer showNumber, Boolean isUpPage,
			Boolean isDownPage) {
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

	public Boolean getIsUpPage() {
		return isUpPage;
	}

	public void setIsUpPage(Boolean isUpPage) {
		this.isUpPage = isUpPage;
	}

	public Boolean getIsDownPage() {
		return isDownPage;
	}

	public void setIsDownPage(Boolean isDownPage) {
		this.isDownPage = isDownPage;
	}

}
