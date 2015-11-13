package com.application.util;

/**
 * ��ҳ������
 * 
 * @author ��̩��
 * 
 */
public class PageUtil {
	/**
	 * ������ҳ������
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
	 * ��ǰҳ
	 * 
	 * @param currentPage
	 * @return Integer
	 */
	private static Integer getCurrentPage(Integer currentPage) {
		return currentPage == null || currentPage <= 0 ? 1 : currentPage;
	}

	/**
	 * ÿҳ��ʾ����
	 * 
	 * @param everyPage
	 * @return
	 */
	private static Integer getEveryPage(Integer everyPage) {
		return everyPage == null || everyPage <= 0 ? 10 : everyPage;
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
	 * �Ƿ�����һҳ
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @return true[��]/false[û��]
	 */
	private static boolean getIsUpPage(Integer currentPage) {
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
	private static boolean getIsDownPage(Integer currentPage, Integer totalPage) {
		return currentPage >= totalPage ? false : true;
	}
}
