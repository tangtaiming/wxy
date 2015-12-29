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
	 * ǰ����ʾ��л����
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/showThank", method = RequestMethod.GET)
	public String showThank(Map<String, Object> data) {
		int creator = 1;	//������id
		thank = thankBiz.fetchThank(creator);
		data.put("thank", thank);
		//��ȡ����
		data.put("action", "showThank");
		return "thank";
	}
	
}
