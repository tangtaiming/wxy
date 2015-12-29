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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@SessionAttributes(value = { "blessingPage", "loginUser" })
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
	
	/**
	 * ��̨ף������༭
	 * @param blessing
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/blessingEdit/{id}", method = RequestMethod.POST)
	public String blessingEdit(Blessing blessing, Map<String, Object> data) {
		//��ѯ���� ������װ����
		Blessing sBlessing = blessingBiz.fetchBlessingById(blessing.getId());
		sBlessing.setBleName(blessing.getBleName());
		sBlessing.setBleContent(blessing.getBleContent());
		if (blessingBiz.updateBlessing(sBlessing)) {
			return "redirect:/b/blessingManager";
		}
		return "redirect:/b/blessingEdit/" + blessing.getId();
	}
	
	/**
	 * ��̨ף������༭ҳ��
	 * @param id
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/blessingEdit/{id}", method = RequestMethod.GET)
	public String blessingEdit(@PathVariable(value = "id") Integer id ,Map<String, Object> data) {
		System.out.println("~~~~~~~~~~" + id);
		if (id != null) {
			Blessing blessing = blessingBiz.fetchBlessingById(id);
			PrintUtil.printUtil(blessing);
			if (blessing != null) {
				setMap(data, "blessing", blessing);
			}
			return "/admin/blessing/edit-blessing";
		}
		return "";
	}
	
	/**
	 * ��ҳ��ѯ��̨����
	 * @param curPage
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/blessingManagerPage", method = RequestMethod.GET)
	public String blessingManagerPage(@RequestParam(value = "curPage") Integer curPage , Map<String, Object> data) {
		if (curPage != null) {
			calculate(curPage);
			calculateDatePage(curPage);
			
			setMap(data, "showPage", tempShowPage);
			setMap(data, "blessingPage", page);
			setMap(data, "blessingList", blessingList);
			return "/admin/blessing/index-data";
		}
		return "";
	}
	
	/**
	 * ��̨����ҳ��-ף���б�
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/blessingManager", method = RequestMethod.GET)
	public String blessingManager(Map<String, Object> data) {
		initBlessingPage(data);
		initBlessingDataPage(data);
		return "/admin/blessing/index";
	}
	
	/**
	 * ǰ��ף������༭ҳ��
	 * @param id
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/editBlessing/{id}", method = RequestMethod.GET)
	public String editBlessing(@PathVariable Integer id, Map<String, Object> data) {
		if (id == null) {
			return "";
		}
		
		Blessing blessing = blessingBiz.fetchBlessingById(id);
		if (blessing != null) {
			data.put("blessing", blessing);
			return "/admin/blessing/index";
		} else {
			return "";
		}
	}
	
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

		// --- showPage ��ȡ��ʾҳ��ļ���
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
	
	/**
	 * ��������
	 */
	private void calculate(int curPage) {
		// ������
		totalNumber = blessingBiz.fetchBlessingCount();
		// ����ÿҳ��ʾ����
		pageSize = Number.TWO;
		// ���õ�ǰҳǰ����ʾ����
		pageRange = Number.THREE;
		page = pageUtil
				.createPage(curPage, pageSize, totalNumber, pageRange);
	}
	
	/**
	 * �����ҳ��ʾ����
	 */
	private void calculateDatePage(int curPage) {
		blessingList = blessingBiz.fetchBlessingByPage(page.getPageNumber(),
				page.getPageSize());
		if (blessingList == null) {
			blessingList = new ArrayList<Blessing>();
			return;
		}
	}
	
	/**
	 * �������󷵻�ֵ
	 * @param data
	 * @return
	 */
	private Map<String, Object> setMap(Map<String, Object> data, String key, Object value) {
		data.put(key, value);
		return data;
	}
	
}
