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
		// ÿҳ��ʾ 5
		int everyPage = Number.ONE;
		// ��ʾ****
		int showNumber = Number.FIVE;
		// ��ȡ����
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
	 * ��ҳ��ѯ����
	 * 
	 * @return
	 */
	@RequestMapping(value = "/essays/{id}", method = RequestMethod.GET)
	public String essaysPage(@PathVariable("id") int currentPage,
			Map<String, Object> data) {
		// ��ȡSession�е�����
		Page page = (Page) data.get("page");
		//�޸ĵ�ǰҳ
		page.setCurrentPage(currentPage);  			
		// ����һ����ҳ
		page = PageUtil.createPage(page.getCurrentPage(), page.getEveryPage(),
				page.getTotalCurrent(), page.getShowNumber());
		// �洢��session��
		data.put("page", page);
		
		// ��ѯ��ǰҳ����
		List<Essay> essayList = essayBiz.fetchEssayPage(
				page.getCurrentPage() - 1, page.getEveryPage(),
				page.getTotalCurrent());
		data.put("essayList", essayList);

		return "essays";
	}
}
