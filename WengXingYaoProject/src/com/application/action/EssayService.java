package com.application.action;

import java.util.ArrayList;
import java.util.HashMap;
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
@SessionAttributes(value = { "essayPage", "commentPage", "essay" })
public class EssayService {

	private EssayBiz essayBiz = new EssayBizImpl();
	private EssayDao essayDao = new EssayDaoImpl();
	private CommentBiz commentBiz = new CommentBizImpl();
	private CommentDao commentDao = new CommentDaoImpl();

	// ��ǰҳ
	private int pageNumber = Number.ONE;
	// ������
	private int totalNumber = 0;
	// ÿҳ��ʾ����
	private int pageSize = Number.ONE;

	private int pageRange = Number.TWO;

	private PageUtil pageUtil = PageUtil.getPageUtil();

	private Page page;

	private List<Integer> tempShowPage;

	private List<Essay> essayList;

	private int essayId;

	private List<Comment> commentList;
	
	private Essay essay;

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
		initEssayPage(data);
		initEssayDataPage(data);

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
		pageNumber = currentPage;
		initEssayPage(data);
		initEssayDataPage(data);

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
		// ȫ�ֱ�����ȡ����ID
		if (id == null || id <= 0) {
			return "error";
		}
		essayId = id;
		fetchOneEssay(data);
		initCommentPage(data);
		initCommentDataPage(data);
		
		if (essay == null) {
			return "error";
		}
		return "essay";

	}
	
	/**
	 * ��ȡ������������
	 * @param data
	 */
	public void fetchOneEssay(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		
		essay = essayBiz.fetchEssayById(essayId);
		data.put("essay", essay);
	}

	/**
	 * ��ʼ�� ��������
	 * 
	 * @param data
	 */
	public void initCommentDataPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}

		commentList = commentBiz.fetchComment(page.getPageNumber(),
				page.getPageSize(), essayId);
		if (commentList == null) {
			commentList = new ArrayList<Comment>();
		}
		data.put("commentList", commentList);
	}

	/**
	 * ��ʼ�� ���۷�ҳ
	 * 
	 * @param data
	 */
	public void initCommentPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		// ������
		totalNumber = commentDao.fetchCommentCount(essayId);
		// ����ÿҳ��ʾ����
		pageSize = Number.TWO;
		// ���õ�ǰҳǰ����ʾ����
		pageRange = Number.ONE;
		// --- commentPage
		page = pageUtil
				.createPage(pageNumber, pageSize, totalNumber, pageRange);

		// --- showPage
		tempShowPage = new ArrayList<Integer>();
		for (int x = page.getRangeStart(); x <= page.getRangeEnd(); x++) {
			tempShowPage.add(x);
		}
		data.put("showPage", tempShowPage);
		data.put("commentPage", page);
		System.out
				.println("----------------initCommentPage()-----------------");
		PrintUtil.printUtil(page);

	}

	/**
	 * ��ʼ�� ���·�ҳ
	 * 
	 * @param data
	 */
	public void initEssayPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		totalNumber = essayDao.fetchEssayCount();
		// --- essayPage
		page = pageUtil
				.createPage(pageNumber, pageSize, totalNumber, pageRange);

		// --- showPage
		tempShowPage = new ArrayList<Integer>();
		for (int x = page.getRangeStart(); x <= page.getRangeEnd(); x++) {
			tempShowPage.add(x);
		}
		data.put("showPage", tempShowPage);
		data.put("essayPage", page);
		PrintUtil.printUtil(page);

	}

	/**
	 * ��ʼ���������ݷ�ҳ �������ʹ���� initEssayPage ����֮��
	 */
	public void initEssayDataPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}

		essayList = essayBiz.fetchEssayPage(page.getPageNumber(),
				page.getPageSize(), 0);
		if (essayList == null) {
			essayList = new ArrayList<Essay>();
		}
		data.put("essayList", essayList);
	}

}
