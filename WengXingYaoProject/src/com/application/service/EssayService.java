package com.application.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.EssayBiz;
import com.application.biz.impl.EssayBizImpl;
import com.application.dao.EssayDao;
import com.application.dao.impl.EssayDaoImpl;
import com.application.entity.Essay;
import com.application.util.Number;
import com.application.util.Page;
import com.application.util.PageUtil;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value = "/e")
@SessionAttributes(value = { "page" })
public class EssayService {

	private EssayBiz essayBiz = new EssayBizImpl();
	private EssayDao essayDao = new EssayDaoImpl();

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
		// 每页显示 5
		int everyPage = Number.ONE;
		// 显示****
		int showNumber = Number.FIVE;
		// 获取数量
		int totalCurrent = essayDao.fetchEssayCount();
		Page page = PageUtil.createPage(currentPage, everyPage, totalCurrent,
				showNumber);

		List<Essay> essayList = essayBiz.fetchEssayPage(currentPage - 1,
				everyPage, 0);
		PrintUtil.printUtil(essayList);
		data.put("essayList", essayList);
		data.put("page", page);
		PrintUtil.printUtil(page);

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
		//修改当前页
		page.setCurrentPage(currentPage);  			
		// 创建一个分页
		page = PageUtil.createPage(page.getCurrentPage(), page.getEveryPage(),
				page.getTotalCurrent(), page.getShowNumber());
		// 存储到session中
		data.put("page", page);
		
		// 查询当前页数据
		List<Essay> essayList = essayBiz.fetchEssayPage(
				page.getCurrentPage() - 1, page.getEveryPage(),
				page.getTotalCurrent());
		data.put("essayList", essayList);

		return "essays";
	}
}
