package com.application.action;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.BlessingBiz;
import com.application.biz.PraiseBiz;
import com.application.biz.impl.BlessingBizImpl;
import com.application.biz.impl.PraiseBizImpl;
import com.application.entity.Blessing;
import com.application.entity.Praise;
import com.application.util.Number;
import com.application.util.Page;
import com.application.util.PageUtil;
import com.application.util.PrintUtil;

@Controller
@RequestMapping(value = "/b")
@SessionAttributes(value = { "blessingPage", "loginUser" })
public class BlessingService {

	private BlessingBiz blessingBiz = new BlessingBizImpl();
	
	private PraiseBiz praiseBiz = new PraiseBizImpl();
	
	@Autowired
	private HttpServletRequest request;

	// 当前�?
	private int pageNumber = Number.ONE;
	// 总数�?
	private int totalNumber = 0;
	// 每页显示数量
	private int pageSize = Number.ONE;

	private int pageRange = Number.TWO;

	private PageUtil pageUtil = PageUtil.getPageUtil();

	private Page page;

	private List<Integer> tempShowPage;

	private List<Blessing> blessingList;
	
	/**
	 * 分页查询前端数据
	 * @param curPage
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/blessingManagerPageByIndex", method = RequestMethod.GET)
	public String blessingManagerPageByIndex(@RequestParam(value = "curPage") Integer curPage , Map<String, Object> data) {
		if (curPage != null) {
			calculateNew(curPage, Number.TWO, Number.ONE);
			calculateDatePage(curPage);
			fetchPraiseByIp();
			
			setMap(data, "showPage", tempShowPage);
			setMap(data, "blessingPage", page);
			setMap(data, "blessingList", blessingList);
			return "blessingData";
		}
		return "";
	}
	
	@RequestMapping(value = "/updatePraiseNumber", method = RequestMethod.POST)
	public String updatePraiseNumber(@RequestParam("id") int id, @RequestParam("upraise") int upraise, Map<String, Object> request) {
		Blessing blessing = blessingBiz.fetchBlessingById(id);
		Praise praise = new Praise();
		boolean isFetchPraise = true;
		if (blessing == null) {
			return "";
		}
		
		//旧的赞数�?
		int lostPraise = blessing.getPraiseNumber();
		blessing.setPraiseNumber(upraise);
		boolean isUpdate = blessingBiz.updateBlessing(blessing);
		if (!isUpdate) {
			return "";
		}
		isFetchPraise = praiseBiz.fetchPraiseByBlessingIdForBoolean(blessing.getId(), this.request.getRemoteAddr());
		if (!isFetchPraise) {
			praise.setBlessingId(blessing.getId());
			praise.setIp(this.request.getRemoteAddr());
			praiseBiz.addPraise(praise);
		} else {
			Praise tempPraise = ((PraiseBizImpl) praiseBiz).getPraizeEntity();
			//查询数据并且删除点赞数据
			praiseBiz.deletePraise(tempPraise.getId(), tempPraise.getBlessingId());
		}
		
		//把对应状态修改成 已修改过 状�??
		if (lostPraise < upraise) {
			setMap(request, "upraiseStatus", "minus");
//			request.put("upraiseStatus", "minus");
		} else {
			setMap(request, "upraiseStatus", "add");
//			request.put("upraiseStatus", "add");
		}
		request.put("blessing", blessing);
		return "/praise";
	}
	
	/**
	 * 后台祝福保存编辑
	 * @param blessing
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/blessingEdit/{id}", method = RequestMethod.POST)
	public String blessingEdit(Blessing blessing, Map<String, Object> data) {
		//查询数据 并且组装数据
		Blessing sBlessing = blessingBiz.fetchBlessingById(blessing.getId());
		if (sBlessing != null) {
			sBlessing.setBleName(blessing.getBleName());
			sBlessing.setBleContent(blessing.getBleContent());
			if (blessingBiz.updateBlessing(sBlessing)) {
				return "redirect:/b/blessingManager";
			}
		}
		
		return "redirect:/b/blessingEdit/" + blessing.getId();
	}
	
	/**
	 * 后台祝福进入编辑页面
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
	 * 分页查询后台数据
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
	 * 后台管理页面-祝福列表
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
	 * 前端祝福进入编辑页面
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
		// 获取当前时间
		LocalDateTime localDateTime = LocalTime.now().atDate(LocalDate.now());
		//用于显示
		data.put("currentTimeShow", localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd�?")));
		//用于放入value�?
		data.put("currentTimeHidden", localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		PrintUtil.printUtil(data);
		//获取导航
		data.put("action", "addBlessingData");
		
		return "addBlessingData";
	}

	/**
	 * 添加祝福
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
			data.put("blessingMessage", "添加数据成功!感谢你�??");
		} else {
			data.put("blessingMessage", "出现了一些未知问�?,你的祝福没有有效保存。抱�?!");
		}
		return "/blessingMessageAjax";
	}

	/**
	 * 显示祝福列表
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/showBlessingData", method = RequestMethod.GET)
	public String showBlessingData(Map<String, Object> data) {
		initBlessingPage(data);
		initBlessingDataPage(data);
		fetchPraiseByIp();
		return "blessingData";
	}
	
	/**
	 * 显示祝福点赞排名列表
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/showBlessingPraiseData", method = RequestMethod.GET)
	public String showBlessingPraiseData(Map<String, Object> data) {
		initBlessingPraise(data);
		return "/blessingPraiseData";
	}
	
	/**
	 * 初始化祝福点赞排序集�?
	 * @param data
	 */
	public void initBlessingPraise(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		blessingList = blessingBiz.fetchBlessingSortByPraise();
		data.put("praiseBlessing", blessingList);
	}
	
	/**
	 * 初始化祝福分�?
	 * 
	 * @param data
	 */
	public void initBlessingPage(Map<String, Object> data) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		//如果改动�?要改动两个地�?,因为初始化需要获取一�? 另外�?处在 71�?
		calculateNew(pageNumber, Number.TWO, Number.ONE);
		// --- showPage 获取显示页面的集�?
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
	 * 初始化祝福分页数�?
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
	 * 计算数量
	 */
	private void calculate(int curPage) {
		// 总数�?
		totalNumber = blessingBiz.fetchBlessingCount();
		// 设置每页显示数量
		pageSize = Number.TWO;
		// 设置当前页前后显示数�?
		pageRange = Number.THREE;
		page = pageUtil
				.createPage(curPage, pageSize, totalNumber, pageRange);
	}
	
	//获取中间分页显示
	private void fetchTempShowPage(Page page) {
		// --- showPage 获取显示页面的集�?
		tempShowPage = new ArrayList<Integer>();
		for (int x = page.getRangeStart(); x <= page.getRangeEnd(); x++) {
			tempShowPage.add(x);
		}
	}
	
	/**
	 * 设置每页显示数量/当前前后也显示数�?
	 * @param pageSize
	 * @param pageRange
	 */
	private void setCalcuate(int pageSize, int pageRange) {
		this.pageSize = pageSize;
		this.pageRange = pageSize;
	}
	
	/**
	 * 计算数量
	 */
	private void calculateNew(int curPage, int pageSize, int pageRange) {
		// 设置每页显示数量 / 设置当前页前后显示数�?
		setCalcuate(pageSize, pageRange);
		// 总数�?
		totalNumber = blessingBiz.fetchBlessingCount();
		page = pageUtil
				.createPage(curPage, this.pageSize, totalNumber, this.pageRange);
		fetchTempShowPage(page);
	}
	
	/**
	 * 计算分页显示数据
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
	 * 设置请求返回�?
	 * @param data
	 * @return
	 */
	private Map<String, Object> setMap(Map<String, Object> data, String key, Object value) {
		data.put(key, value);
		return data;
	}
	
	/**
	 * 获取对应祝福 Ip是否点赞
	 * @return
	 */
	public void fetchPraiseByIp() {
		String ip = request.getRemoteAddr();
		List<Praise> praiseLists = praiseBiz.fetchPraiseByIp(ip);
		List<Blessing> tempBlessings = new ArrayList<Blessing>();
		outBlessing:
		for (Blessing blessing : blessingList) {
			if (praiseLists.size() > 0) {
				for (Praise praise : praiseLists) {
					if (praise.getBlessingId() == blessing.getId()) {
						blessing.setPraiseStatus("minus");
						tempBlessings.add(blessing);
						continue outBlessing;
					}
				}
			}
			blessing.setPraiseStatus("add");
			tempBlessings.add(blessing);
		}
		blessingList = tempBlessings;
	}
}
