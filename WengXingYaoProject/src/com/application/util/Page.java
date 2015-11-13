package com.application.util;

/**
 * ��ҳ
 * 
 * @author Administrator
 * 
 */
public class Page {

	// ��ǰҳ
	private int current;
	// ÿҳ��ʾ����
	private int pageNumber;
	// ��ҳ��
	private int pageTotal;
	// ��ʾ��ҳ��ʾ����
	private int showNumber;
	// �ܼ�¼��
	private int recordTotalNumber;
	// �Ƿ�����һҳ
	private boolean isUp;
	// �Ƿ�����һҳ
	private boolean isDown;

	public Page(int current, int pageNumber, int pageTotal, int showNumber,
			int recordTotalNumber, boolean isUp, boolean isDown) {
		this.current = current;
		this.pageNumber = pageNumber;
		this.pageTotal = pageTotal;
		this.showNumber = showNumber;
		this.recordTotalNumber = recordTotalNumber;
		this.isUp = isUp;
		this.isDown = isDown;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}

	public int getRecordTotalNumber() {
		return recordTotalNumber;
	}

	public void setRecordTotalNumber(int recordTotalNumber) {
		this.recordTotalNumber = recordTotalNumber;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

}
