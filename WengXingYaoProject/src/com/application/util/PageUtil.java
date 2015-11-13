package com.application.util;

/**
 * 分页工具类
 * 
 * @author 唐泰明
 * 
 */
public class PageUtil {
	/**
	 * 创建分页工具类
	 * 
	 * @param currentPage
	 * @param everyPage
	 * @param totalCurrent
	 * @return
	 */
	public static Page createPage(Integer currentPage, Integer everyPage,
			Integer totalCurrent) {
		currentPage = getCurrentPage(currentPage);
		everyPage = getEveryPage(everyPage);
		Integer totalPage = getTotalPage(totalCurrent, everyPage);
		boolean isUpPage = getIsUpPage(currentPage);
		boolean isDownPage = getIsDownPage(currentPage, totalPage);
//		Page page = new Page(currentPage, totalPage, everyPage, totalCurrent,
//				isUpPage, isDownPage);
		Page page = null;

		return page;
	}

	/**
	 * 当前页
	 * 
	 * @param currentPage
	 * @return Integer
	 */
	private static Integer getCurrentPage(Integer currentPage) {
		return currentPage == null || currentPage <= 0 ? 1 : currentPage;
	}

	/**
	 * 每页显示数量
	 * 
	 * @param everyPage
	 * @return
	 */
	private static Integer getEveryPage(Integer everyPage) {
		return everyPage == null || everyPage <= 0 ? 10 : everyPage;
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
	private static Integer getTotalPage(Integer totalCurrent, Integer everyPage) {
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
	private static boolean getIsUpPage(Integer currentPage) {
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
	private static boolean getIsDownPage(Integer currentPage, Integer totalPage) {
		return currentPage >= totalPage ? false : true;
	}
}
