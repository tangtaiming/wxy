package com.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.BlessingBiz;
import com.application.biz.impl.BlessingBizImpl;
import com.application.entity.Blessing;
import com.application.util.Number;
import com.application.util.Page;
import com.application.util.PageUtil;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value = "/b")
@SessionAttributes(value = { "blessingPage" })
public class BlessingService {

	private BlessingBiz blessingBiz = new BlessingBizImpl();

	// ��ǰҳ
	private int pageNumber = Number.ONE;
	// ������
	private int totalNumber = 0;
	// ÿҳ��ʾ����
	private int pageSize = Number.ONE;

	private int pageRange = Number.TWO;

	private PageUtil pageUtil = PageUtil.getPageUtil();

	private Page page;

	private List<Integer> tempShowPage;

	private List<Blessing> blessingList;

	@RequestMapping(value = "/addBlessingData", method = RequestMethod.GET)
	public String addBlessingDataByInput(Map<String, Object> data) {
		System.out.println("~~~~~~~~~~~~~~addBlessingDataByInput() get");
		// ��ȡ��ǰʱ��
		LocalDateTime localDateTime = LocalTime.now().atDate(LocalDate.now());
		//������ʾ
		data.put("currentTimeShow", localDateTime.format(DateTimeFormatter.ofPattern("yyyy��MM��dd��")));
		//���ڷ���valueֵ
		data.put("currentTimeHidden", localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		PrintUtil.printUtil(data);
		//��ȡ����
		data.put("action", "addBlessingData");
		
		return "addBlessingData";
	}

	/**
	 * ���ף��
	 * 
	 * @param blessing
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/addBlessingData", method = RequestMethod.POST)
	public String addBlessingData(Blessing blessing, HttpServletRequest request, Map<String, Object> data) {
		String bleTime = LocalTime.now().atDate(LocalDate.now())
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm"));
		int praise = Number.ONE - 1;
		int praiseNumber = Number.ONE - 1;
		String addressIp = request.getRemoteAddr();
		blessing.setBleTime(bleTime);
		blessing.setPraise(praise);
		blessing.setPraiseNumber(praiseNumber);
		blessing.setBleIp(addressIp);
		
		
		System.out.println("~~~~~~~~~~~~addBlessingData() post~~~~~~~~~~~~~");
		PrintUtil.printUtil(blessing);
		boolean addArgee = blessingBiz.saveBlessing(blessing);
		if (addArgee) {
			data.put("blessingMessage", "������ݳɹ�!��л�㡣");
		} else {
			data.put("blessingMessage", "������һЩδ֪����,���ף��û����Ч���档��Ǹ!");
		}
		return "/blessingMessageAjax";
	}

	/**
	 * ��ʾף���б�
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/showBlessingData", method = RequestMethod.GET)
	public String showBlessingData(Map<String, Object> data) {
		initBlessingPage(data);
		initBlessingDataPage(data);
		return "blessingData";
	}

	/**
	 * ��ʼ��ף����ҳ
	 * 
	 * @param data
	 */
	public void initBlessingPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		// ������
		totalNumber = blessingBiz.fetchBlessingCount();
		// ����ÿҳ��ʾ����
		pageSize = Number.TWO;
		// ���õ�ǰҳǰ����ʾ����
		pageRange = Number.THREE;
		// --- commentPage
		page = pageUtil
				.createPage(pageNumber, pageSize, totalNumber, pageRange);

		// --- showPage
		tempShowPage = new ArrayList<Integer>();
		for (int x = page.getRangeStart(); x <= page.getRangeEnd(); x++) {
			tempShowPage.add(x);
		}
		data.put("showPage", tempShowPage);
		data.put("blessingPage", page);
		System.out
				.println("----------------initBlessingDataPage()-----------------");
		PrintUtil.printUtil(page);
	}

	/**
	 * ��ʼ��ף����ҳ����
	 * 
	 * @param data
	 */
	public void initBlessingDataPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}

		blessingList = blessingBiz.fetchBlessingByPage(page.getPageNumber(),
				page.getPageSize());
		if (blessingList == null) {
			blessingList = new ArrayList<Blessing>();
			return;
		}
		data.put("blessingList", blessingList);
	}

}
