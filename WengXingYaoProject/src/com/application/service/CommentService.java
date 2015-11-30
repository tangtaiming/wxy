package com.application.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
@SessionAttributes(value = { "commentPage" })
public class CommentService {

	private CommentBiz commentBiz = new CommentBizImpl();
	private CommentDao commentDao = new CommentDaoImpl();

	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return String
	 */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(Comment comment, HttpServletRequest request,
			Map<String, Object> data) {
//
//		comment.setCreateData(LocalDate.now().atTime(LocalTime.now())
//				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm:ss")));
//		comment.setAddressIp(request.getRemoteAddr());
//		PrintUtil.printUtil(comment);
//		if (commentBiz.addComment(comment) == 1) {
//			// return "redirect:/e/essay/" + comment.getEssayId();
//			// 1. 保存后刷新评论页面。
//			Page commentPage = (Page) data.get("commentPage");
//			// 计算总数量
//			Integer totalCurrent = commentDao.fetchCommentCount(comment
//					.getEssayId());
//			data.put("commentList", commentList);
//			data.put("commentPage", commentPage);
//			return "/comment";
//		}

		return "";
	}

	@RequestMapping(value = "/commentPage", method = RequestMethod.GET)
	public String commentPge(
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(value = "essayId", defaultValue = "1") Integer essayId,
			Map<String, Object> data) {
//
//		// 获取评论分页
//		Page commentPage = (Page) data.get("commentPage");
//		PageUtil pageUtil = PageUtil.getPageUtil();
//
//		List<Integer> showNumber = pageUtil.getPageNumberTwo(currentPage,
//				commentPage.getTotalPage(), commentPage.getPageNumber());
//		pageUtil.createPage(currentPage, commentPage.getEveryPage(),
//				commentPage.getTotalCurrent());
//		List<Comment> commentList = commentBiz.fetchComment(
//				commentPage.getCurrentPage() - 1, commentPage.getEveryPage(),
//				essayId);
//
//		data.put("commentList", commentList);
//		data.put("commentPage", commentPage);
		return "/comment";
	}

}
