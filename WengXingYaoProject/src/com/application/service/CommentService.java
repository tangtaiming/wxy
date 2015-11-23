package com.application.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.biz.CommentBiz;
import com.application.biz.impl.CommentBizImpl;
import com.application.entity.Comment;
import com.application.util.PrintUtil;

/**
 * 评论业务逻辑层
 * 
 * @author 唐太明
 * 
 */
@Controller
@RequestMapping(value = "/c")
public class CommentService {

	private CommentBiz commentBiz = new CommentBizImpl();

	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return String
	 */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(Comment comment, HttpServletRequest request, Map<String, Object> data) {

		comment.setCreateData(LocalDate.now().atTime(LocalTime.now())
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm:ss")));
		comment.setAddressIp(request.getRemoteAddr());
		PrintUtil.printUtil(comment);
		if (commentBiz.addComment(comment) == 1) {
//			return "redirect:/e/essay/" + comment.getEssayId();
			return "/comment";
		}
		
		return "";
		
	}
}
