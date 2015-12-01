package com.application.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.CommentBiz;
import com.application.biz.impl.CommentBizImpl;
import com.application.dao.CommentDao;
import com.application.dao.impl.CommentDaoImpl;
import com.application.entity.Comment;
import com.application.entity.Essay;
import com.application.util.Number;
import com.application.util.Page;
import com.application.util.PageUtil;
import com.application.util.PrintUtil;

/**
 * ����ҵ���߼���
 * 
 * @author ��̫��
 * 
 */
@Controller
@RequestMapping(value = "/c")
@SessionAttributes(value = { "commentPage", "essay" })
public class CommentService {

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

	private int essayId;

	private List<Comment> commentList;

	private Essay essay;

	/**
	 * �������
	 * 
	 * @param comment
	 * @return String
	 */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(Comment comment, HttpServletRequest request,
			Map<String, Object> data) {
		 comment.setCreateData(LocalDate.now().atTime(LocalTime.now())
		 .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm:ss")));
		 comment.setAddressIp(request.getRemoteAddr());
		 PrintUtil.printUtil(comment);
		 if (commentBiz.addComment(comment) == 1) {
			 // return "redirect:/e/essay/" + comment.getEssayId();
			 // 1. �����ˢ������ҳ�档
			 essayId = comment.getEssayId();
			 //��session �����ȡ���۵�ǰҳ
			 pageNumber = ((Page) data.get("commentPage")).getPageNumber();
			 initCommentPage(data);
			 initCommentDataPage(data);
			 
			 return "/comment";
		 }
		return "error";
	}

	/**
	 * ���۷�ҳ
	 * 
	 * @param currentPage
	 * @param essayId
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/commentPage", method = RequestMethod.GET)
	public String commentPge(
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			Map<String, Object> data) {

		essay =  (Essay) data.get("essay");
		essayId = essay.getId();
		pageNumber = currentPage;
		
		initCommentPage(data);
		initCommentDataPage(data);
		return "/comment";
		
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

}
