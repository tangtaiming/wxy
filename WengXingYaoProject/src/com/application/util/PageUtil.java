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
	 * 创建分页工具类
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
	 * 当前页
	 * 
	 * @param currentPage
	 * @return Integer
	 */
	private Integer getPageNumber(int currentPage) {
		return currentPage <= 0 ? 1 : currentPage;
	}

	/**
	 * 每页显示数量
	 * 
	 * @param everyPage
	 * @return
	 */
	private Integer getPageSize(int everyPage) {
		return everyPage <= 0 ? 10 : everyPage;
	}

	/**
	 * 总页数
	 * 
	 * @param totalCurrent
	 *            总数量
	 * @param everyPage
	 *            每页显示数量
	 * @return 总页数
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
	 * 是否有上一页
	 * 
	 * @param currentPage
	 *            当前页
	 * @return true[有]/false[没有]
	 */
	private boolean getPrevious(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	/**
	 * 是否有下一页
	 * 
	 * @param currentPage
	 *            当前页
	 * @param totalPage
	 *            总页数
	 * @return true[有]/false[没有]
	 */
	private boolean getNext(int currentPage, int totalPage) {
		return currentPage >= totalPage ? false : true;
	}

	/**
	 * 获取当前页前后分页起始值
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
	 * 获取方向
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