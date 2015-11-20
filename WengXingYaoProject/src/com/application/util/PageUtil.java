package com.application.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * ��ҳ������
 * 
 * @author ��̩��
 * 
 */
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
	 * @param currentPage
	 * @param everyPage
	 * @param totalCurrent
	 * @return
	 */
	public Page createPage(Integer currentPage, Integer everyPage,
			Integer totalCurrent) {
		currentPage = getCurrentPage(currentPage);
		everyPage = getEveryPage(everyPage);
		Integer totalPage = getTotalPage(totalCurrent, everyPage);
		boolean isUpPage = getIsUpPage(currentPage);
		boolean isDownPage = getIsDownPage(currentPage, totalPage);
		Page page = new Page(currentPage, totalPage, everyPage, totalCurrent,
				isUpPage, isDownPage);

		return page;
	}
	
	public static void main(String[] args) {
		List<Integer> tempList = new ArrayList<Integer>();
		for (int x = 1; x <= 5; x++) {
			tempList.add(x);
		}
		Integer centerPage = 3;
		Integer totalPage = 7;
		
		PageUtil pageUtil = PageUtil.getPageUtil();
		List<Integer> t = pageUtil.getPageNumberTwo(centerPage, totalPage, (List<Integer>) null);
		PrintUtil.printUtil(t);
	}

	/**
	 * 
	 * @param currentPage
	 * @param totalPage
	 * @param centerPage
	 * @return
	 */
	public List<Integer> getPageNumberTwo(Integer currentPage,
			Integer totalPage, List<Integer> listNumber) {

		List<Integer> showNumber = new ArrayList<Integer>();
		if (listNumber == null) {
			listNumber = new ArrayList<Integer>();
			for (Integer x = 1; x <= 5; x++) {
				listNumber.add(x);
			}
		}
		if (listNumber.size() == 0) {
			for (Integer x = 1; x <= 5; x++) {
				listNumber.add(x);
			}
		} 
		
		
		if (totalPage < listNumber.get(listNumber.size() - 1)) {
			for (int x = 1; x <= totalPage; x++) {
				showNumber.add(x);
			}
			
			return showNumber;
		}

		Integer chaZhi = currentPage - listNumber.get(Number.THREE - 1);
		for (Integer x = 0; x < listNumber.size(); x++) {
			Integer a = listNumber.get(x) + chaZhi;
			showNumber.add(a);
		}
		
		Integer firstPage = showNumber.get(Number.ONE - 1);
		Integer lastPage = showNumber.get(showNumber.size() - 1);
		if (totalPage <= lastPage) {
			showNumber.clear();
			for (int x = totalPage - 4; x <= totalPage; x++) {
				showNumber.add(x);
			}
		}
		
		if (firstPage <= 0) {
			showNumber.clear();
			for (Integer x = 1; x <= 5; x++) {
				showNumber.add(x);
			}
		}
		
		return showNumber;
	}

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	public List<Integer> getPageNumber(Integer currentPage, Integer totalPage,
			Integer clickPage) {

		List<Integer> showNumber = new ArrayList<Integer>();
		if (totalPage < 5) {
			for (int x = 1; x <= totalPage; x++) {
				showNumber.add(x);
			}
			return showNumber;
		}

		// ���ҳ ���� ��ǰҳ
		if (clickPage > currentPage) {
			if (currentPage + 4 > totalPage) {
				for (int x = totalPage - 4; x <= totalPage; x++) {
					showNumber.add(x);
				}
			} else {
				for (int x = currentPage; x <= currentPage + 4; x++) {
					showNumber.add(x);
				}
			}
		} else {
			if (currentPage - 4 < 1) {
				for (int y = 1; y <= 5; y++) {
					showNumber.add(y);
				}
			} else {
				for (int y = currentPage - 4; y <= currentPage; y++) {
					showNumber.add(y);
				}
			}
		}

		return showNumber;
	}

	/**
	 * ��ǰҳ
	 * 
	 * @param currentPage
	 * @return Integer
	 */
	public Integer getCurrentPage(Integer currentPage) {
		return currentPage == null || currentPage <= 0 ? 1 : currentPage;
	}

	/**
	 * ÿҳ��ʾ����
	 * 
	 * @param everyPage
	 * @return
	 */
	private Integer getEveryPage(Integer everyPage) {
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
	private Integer getTotalPage(Integer totalCurrent, Integer everyPage) {
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
	private boolean getIsUpPage(Integer currentPage) {
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
	private boolean getIsDownPage(Integer currentPage, Integer totalPage) {
		return currentPage >= totalPage ? false : true;
	}

	/**
	 * ��ȡ��ǰҳ��һ������λ��
	 * 
	 * @param currentPage
	 * @param everyPage
	 * @return
	 */
	public int currentFirstPage(Integer currentPage, Integer everyPage) {
		return (everyPage * (currentPage - 1));
	}

	/**
	 * ��ȡ��ǰҳ���������λ��
	 * 
	 * @param currentPage
	 * @param everyPage
	 * @return
	 */
	public int currentLastPage(Integer currentPage, Integer everyPage) {
		return everyPage * currentPage;
	}

}
