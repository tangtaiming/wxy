package com.application.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.biz.EssayBiz;
import com.application.biz.impl.EssayBizImpl;
import com.application.entity.Essay;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value = "/e")
public class EssayService {

	private EssayBiz essayBiz = new EssayBizImpl();
	
	/**
	 * д����
	 * @return 
	 */
	@RequestMapping(value = "/writerEssay")
	public String writerEssay(Essay essay) {
		
		return "writerEssay";
	}
	
	/**
	 * ��ҳ��ʾ����
	 * @return
	 */
	@RequestMapping(value = "/essays", method = RequestMethod.GET)
	public String essays(Map<String, Object> data){
		//��ǰҳ
		Integer currentPage = 1;
		//ÿҳ��ʾ 5 
		int everyPage = com.application.util.Number.FIVE;
		List<Essay> essayList = essayBiz.fetchEssayPage(currentPage - 1, everyPage, 0);
		PrintUtil.printUtil(essayList);
		data.put("essayList", essayList);
		return "essays";
		
	}
	
}
