package com.application.service;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.biz.ThankBiz;
import com.application.biz.impl.ThankBizImpl;
import com.application.entity.Thank;

@Controller
@RequestMapping(value = "/t")
public class ThankService {

	private ThankBiz thankBiz = new ThankBizImpl();
	
	private Thank thank;
	
	
	
	/**
	 * 前端显示感谢数据
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/showThank", method = RequestMethod.GET)
	public String showThank(Map<String, Object> data) {
		int creator = 1;	//创建人id
		thank = thankBiz.fetchThank(creator);
		data.put("thank", thank);
		//获取导航
		data.put("action", "showThank");
		return "thank";
	}
	
}
