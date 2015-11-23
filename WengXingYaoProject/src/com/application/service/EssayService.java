package com.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.CommentBiz;
import com.application.biz.EssayBiz;
import com.application.biz.impl.CommentBizImpl;
import com.application.biz.impl.EssayBizImpl;
import com.application.dao.CommentDao;
import com.application.dao.EssayDao;
import com.application.dao.impl.CommentDaoImpl;
import com.application.dao.impl.EssayDaoImpl;
import com.application.entity.Comment;
import com.application.entity.Essay;
import com.application.util.Number;
import com.application.util.Page;
import com.application.util.PageUtil;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value = "/e")
@SessionAttributes(value = { "page", "commentPage" })
public class EssayService {

	private EssayBiz essayBiz = new EssayBizImpl();
	private EssayDao essayDao = new EssayDaoImpl();
	private CommentBiz commentBiz = new CommentBizImpl();
	private CommentDao commentDao = new CommentDaoImpl();

	/**
	 * д����
	 * 
	 * @return
	 */
	@RequestMapping(value = "/writerEssay")
	public String writerEssay(Essay essay) {

		return "writerEssay";
	}

	/**
	 * Ĭ����ʾ�����б��һҳ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/essays", method = RequestMethod.GET)
	public String essays(Map<String, Object> data) {
		// ��ǰҳ
		Integer currentPage = 1;
		// ÿҳ��ʾ 1
		int everyPage = Number.ONE;
		// ��ȡ����
		int totalCurrent = essayDao.fetchEssayCount();

		List<Integer> showPageNumber = new ArrayList<Integer>();
		PageUtil pageUtil = PageUtil.getPageUtil();
		Page page = pageUtil.createPage(currentPage, everyPage, totalCurrent);

		showPageNumber = pageUtil.getPageNumberTwo(currentPage,
				page.getTotalPage(), showPageNumber);
		page.setPageNumber(showPageNumber);

		List<Essay> essayList = essayBiz.fetchEssayPage(currentPage - 1,
				everyPage, 0);
		PrintUtil.printUtil(essayList);
		PrintUtil.printUtil(page);

		data.put("essayList", essayList);
		data.put("page", page);
		return "essays";
	}

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @return
	 */
	@RequestMapping(value = "/essays/{id}", method = RequestMethod.GET)
	public String essaysPage(@PathVariable("id") int currentPage,
			Map<String, Object> data) {
		// ��ȡSession�е�����
		Page page = (Page) data.get("page");

		if (currentPage == 0) {
			currentPage = 1;
		}
		// �޸ĵ�ǰҳ
		page.setCurrentPage(currentPage);
		// ����һ����ҳ
		PageUtil pageUtil = PageUtil.getPageUtil();
		// ��ȡҳ����ʾ
		List<Integer> showPageNumber = new ArrayList<Integer>();
		// ������ʾҳ��
		showPageNumber = pageUtil.getPageNumberTwo(page.getCurrentPage(),
				page.getTotalPage(), page.getPageNumber());
		// ���÷�ҳ
		page = pageUtil.createPage(page.getCurrentPage(), page.getEveryPage(),
				page.getTotalCurrent());

		page.setPageNumber(showPageNumber);
		// �洢��session��
		data.put("page", page);

		// ��ѯ��ǰҳ����
		List<Essay> essayList = essayBiz.fetchEssayPage(
				page.getCurrentPage() - 1, page.getEveryPage(),
				page.getTotalCurrent());
		data.put("essayList", essayList);
		PrintUtil.printUtil(page);
		return "essays";
	}

	/**
	 * �鿴����
	 * 
	 * @param id
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/essay/{id}", method = RequestMethod.GET)
	public String essay(@PathVariable("id") Integer id, Map<String, Object> data) {
		Essay essay = null;

		if (id == null) {
			id = 1;
		}
		essay = essayBiz.fetchEssayById(id);
		// Ĭ����ʾ��һҳ
		Integer currentPage = 1;
		// ÿҳ��ʾ 2������
		Integer everyPage = Number.TWO;
		// ����������
		Integer totalCurrent = commentDao.fetchCommentCount(id);

		PageUtil pageUtil = PageUtil.getPageUtil();
		Page commentPage = pageUtil.createPage(currentPage, everyPage,
				totalCurrent);

		List<Integer> showNumber = pageUtil.getPageNumberTwo(
				commentPage.getCurrentPage(), commentPage.getTotalPage(), null);
		commentPage.setPageNumber(showNumber);
		List<Comment> commentList = commentBiz
				.fetchComment(currentPage, everyPage, id);

		data.put("essay", essay);
		data.put("commentList", commentList);
		data.put("commentPage", commentPage);
		return "essay";

	}

}
