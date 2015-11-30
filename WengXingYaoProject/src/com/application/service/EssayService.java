package com.application.service;

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
import com.application.entity.Essay;
import com.application.util.Number;
import com.application.util.Page;
import com.application.util.PageUtil;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value = "/e")
@SessionAttributes(value = { "essayPage", "commentPage" })
public class EssayService {

	private EssayBiz essayBiz = new EssayBizImpl();
	private EssayDao essayDao = new EssayDaoImpl();
	private CommentBiz commentBiz = new CommentBizImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	
	//当前页
	private int pageNumber = Number.ONE;
	//总数量
	private int totalNumber = 0;
	//每页显示数量
	private int pageSize = Number.ONE;
	
	private int pageRange = Number.TWO;
	
	private PageUtil pageUtil = PageUtil.getPageUtil();
	
	private Page essayPage;
	
	private List<Integer> tempShowPage;
	
	private List<Essay> essayList;

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
		initEssayPage(data);
		initEssayDataPage(data);
		
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
		pageNumber = currentPage;
		initEssayPage(data);
		initEssayDataPage(data);
		
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
		return "essay";

	}
	
	/**
	 * 初始化 文章分页
	 * @param data
	 */
	public void initEssayPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		totalNumber = essayDao.fetchEssayCount();
		// --- essayPage 
		essayPage = pageUtil.createPage(pageNumber, pageSize, totalNumber, pageRange);
		
		// --- showPage
		tempShowPage = new ArrayList<Integer>();
		for (int x = essayPage.getRangeStart(); x <= essayPage.getRangeEnd(); x++) {
			tempShowPage.add(x);
		}
		data.put("showPage", tempShowPage);
		data.put("essayPage", essayPage);
		PrintUtil.printUtil(essayPage);
		
	}
	
	/**
	 * 初始化文章数据分页
	 * 这个方法使用在 initEssayPage 方法之后
	 */
	public void initEssayDataPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		
		essayList = essayBiz.fetchEssayPage(essayPage.getPageNumber(), essayPage.getPageSize(), 0);
		if (essayList == null) {
			essayList = new ArrayList<Essay>();
		}
		data.put("essayList", essayList);
	}

}
