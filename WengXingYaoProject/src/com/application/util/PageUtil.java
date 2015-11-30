package com.application.util;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {

	private static PageUtil SINGLE_PAGE_UTIL;

	private PageUtil() {
	};

	public static PageUtil getPageUtil() {
		if (SINGLE_PAGE_UTIL == null) {
			SINGLE_PAGE_UTIL = new PageUtil();
		}

		return SINGLE_PAGE_UTIL;
	}

	/**
	 * ������ҳ������
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param totalNumber
	 * @return
	 */
	public Page createPage(int pageNumber, int pageSize, int totalNumber,
			int pageRange) {
		pageNumber = getPageNumber(pageNumber);
		pageSize = getPageSize(pageSize);
		int totalPage = getTotalPage(totalNumber, pageSize);

		Map<String, Integer> rangeData = fetchRange(pageNumber, totalPage,
				pageRange);
		int rangeStart = rangeData.get("rangeStart");
		int rangeEnd = rangeData.get("rangeEnd");
		boolean previous = getPrevious(pageNumber);
		boolean next = getNext(pageNumber, totalPage);
		
		Page page = new Page(pageNumber, pageSize, pageRange, totalPage,
				totalNumber, 0, rangeStart, rangeEnd, previous, next);
		return page;
	}

	/**
	 * ��ǰҳ
	 * 
	 * @param currentPage
	 * @return Integer
	 */
	private Integer getPageNumber(int currentPage) {
		return currentPage <= 0 ? 1 : currentPage;
	}

	/**
	 * ÿҳ��ʾ����
	 * 
	 * @param everyPage
	 * @return
	 */
	private Integer getPageSize(int everyPage) {
		return everyPage <= 0 ? 10 : everyPage;
	}

	/**
	 * ��ҳ��
	 * 
	 * @param totalCurrent
	 *            ������
	 * @param everyPage
	 *            ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	private Integer getTotalPage(int totalCurrent, int everyPage) {
		Integer aTotalPage = 0;
		if (totalCurrent % everyPage == 0) {
			aTotalPage = totalCurrent / everyPage;
		} else {
			aTotalPage = totalCurrent / everyPage + 1;
		}

		return aTotalPage;
	}

	/**
	 * �Ƿ�����һҳ
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @return true[��]/false[û��]
	 */
	private boolean getPrevious(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	/**
	 * �Ƿ�����һҳ
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @param totalPage
	 *            ��ҳ��
	 * @return true[��]/false[û��]
	 */
	private boolean getNext(int currentPage, int totalPage) {
		return currentPage >= totalPage ? false : true;
	}

	/**
	 * ��ȡ��ǰҳǰ���ҳ��ʼֵ
	 * 
	 * @param currentPage
	 * @param totalPage
	 * @param pageRange
	 * @return
	 */
	private Map<String, Integer> fetchRange(int currentPage, int totalPage,
			int pageRange) {

		Map<String, Integer> data = new HashMap<String, Integer>();
		int rangeStart = currentPage - pageRange;
		int rangeEnd = currentPage + pageRange;

		if (rangeEnd > totalPage) {
			rangeEnd = totalPage;
			rangeStart = totalPage - pageRange * 2;
			rangeStart = rangeStart < 1 ? 1 : rangeStart;
		}
		if (rangeStart <= 1) {
			rangeStart = 1;
			rangeEnd = Math.min(pageRange * 2 + 1, totalPage);
		}

		data.put("rangeStart", rangeStart);
		data.put("rangeEnd", rangeEnd);
		return data;

	}

	/**
	 * ��ȡ����
	 * 
	 * @param currentPage
	 * @param lastCurrentPage
	 * @return
	 */
	@SuppressWarnings("unused")
	private int getDirction(int currentPage, int lastCurrentPage) {
		return currentPage == 0 ? 0 : (currentPage > lastCurrentPage ? 1 : -1);
	}
	
}