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
	 * 写文章
	 * 
	 * @return
	 */
	@RequestMapping(value = "/writerEssay")
	public String writerEssay(Essay essay) {

		return "writerEssay";
	}

	/**
	 * 默认显示文章列表第一页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/essays", method = RequestMethod.GET)
	public String essays(Map<String, Object> data) {
		// 当前页
		Integer currentPage = 1;
		// 每页显示 1
		int everyPage = Number.ONE;
		// 获取数量
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
	 * 分页查询数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/essays/{id}", method = RequestMethod.GET)
	public String essaysPage(@PathVariable("id") int currentPage,
			Map<String, Object> data) {
		// 获取Session中的数据
		Page page = (Page) data.get("page");

		if (currentPage == 0) {
			currentPage = 1;
		}
		// 修改当前页
		page.setCurrentPage(currentPage);
		// 创建一个分页
		PageUtil pageUtil = PageUtil.getPageUtil();
		// 获取页码显示
		List<Integer> showPageNumber = new ArrayList<Integer>();
		// 计算显示页码
		showPageNumber = pageUtil.getPageNumberTwo(page.getCurrentPage(),
				page.getTotalPage(), page.getPageNumber());
		// 设置分页
		page = pageUtil.createPage(page.getCurrentPage(), page.getEveryPage(),
				page.getTotalCurrent());

		page.setPageNumber(showPageNumber);
		// 存储到session中
		data.put("page", page);

		// 查询当前页数据
		List<Essay> essayList = essayBiz.fetchEssayPage(
				page.getCurrentPage() - 1, page.getEveryPage(),
				page.getTotalCurrent());
		data.put("essayList", essayList);
		PrintUtil.printUtil(page);
		return "essays";
	}

	/**
	 * 查看文章
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
		// 默认显示第一页
		Integer currentPage = 1;
		// 每页显示 2条数据
		Integer everyPage = Number.TWO;
		// 评论总数量
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
