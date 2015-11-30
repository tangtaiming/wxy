package com.application.util;


public class Page {

	// ��ǰҳ��
	private int pageNumber;
	// ÿҳ��Ŀ��
	private int pageSize;
	// ҳ������Χ
	private int pageRange;
	// ��ҳ��
	private int totalPage;
	// ����Ŀ��
	private int totalNumber;
	// ��ҳ������ǰ��ҳʱֵΪ -1������Ϊ 1����ʼ��ʱΪ 0
	private int dirction;
	// ��ʼλ��
	private int rangeStart;
	// ����λ��
	private int rangeEnd;
	// �Ƿ�����һҳ
	private boolean previous;
	// �Ƿ�����һҳ
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

