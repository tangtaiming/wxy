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
 * 评论业务逻辑层
 * 
 * @author 唐太明
 * 
 */
@Controller
@RequestMapping(value = "/c")
@SessionAttributes(value = { "commentPage", "essay" })
public class CommentService {

	private CommentBiz commentBiz = new CommentBizImpl();
	private CommentDao commentDao = new CommentDaoImpl();

	// 当前页
	private int pageNumber = Number.ONE;
	// 总数量
	private int totalNumber = 0;
	// 每页显示数量
	private int pageSize = Number.ONE;

	private int pageRange = Number.TWO;

	private PageUtil pageUtil = PageUtil.getPageUtil();

	private Page page;

	private List<Integer> tempShowPage;

	private int essayId;

	private List<Comment> commentList;

	private Essay essay;

	/**
	 * 添加评论
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
			 // 1. 保存后刷新评论页面。
			 essayId = comment.getEssayId();
			 //从session 里面获取评论当前页
			 pageNumber = ((Page) data.get("commentPage")).getPageNumber();
			 initCommentPage(data);
			 initCommentDataPage(data);
			 
			 return "/comment";
		 }
		return "error";
	}

	/**
	 * 评论翻页
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
	 * 初始化 评论数据
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
	 * 初始化 评论分页
	 * 
	 * @param data
	 */
	public void initCommentPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		// 总数量
		totalNumber = commentDao.fetchCommentCount(essayId);
		// 设置每页显示数量
		pageSize = Number.TWO;
		// 设置当前页前后显示数量
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
