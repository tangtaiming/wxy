package com.application.util;


public class Page {

	// 当前页码
	private int pageNumber;
	// 每页条目数
	private int pageSize;
	// 页码数范围
	private int pageRange;
	// 总页数
	private int totalPage;
	// 总条目数
	private int totalNumber;
	// 分页方向，往前翻页时值为 -1，往后翻为 1，初始化时为 0
	private int dirction;
	// 开始位置
	private int rangeStart;
	// 结束位置
	private int rangeEnd;
	// 是否有上一页
	private boolean previous;
	// 是否有下一页
	private boolean next;

	public Page() {
	}

	public Page(int pageNumber, int pageSize, int pageRange, int totalPage,
			int totalNumber, int dirction, int rangeStart, int rangeEnd,
			boolean previous, boolean next) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.pageRange = pageRange;
		this.totalPage = totalPage;
		this.totalNumber = totalNumber;
		this.dirction = dirction;
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
		this.previous = previous;
		this.next = next;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getDirction() {
		return dirction;
	}

	public void setDirction(int dirction) {
		this.dirction = dirction;
	}

	public int getRangeStart() {
		return rangeStart;
	}

	public void setRangeStart(int rangeStart) {
		this.rangeStart = rangeStart;
	}

	public int getRangeEnd() {
		return rangeEnd;
	}

	public void setRangeEnd(int rangeEnd) {
		this.rangeEnd = rangeEnd;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}

