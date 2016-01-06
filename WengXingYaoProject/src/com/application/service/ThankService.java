package com.application.service;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.biz.ThankBiz;
import com.application.biz.UserBiz;
import com.application.biz.impl.ThankBizImpl;
import com.application.biz.impl.UserBizImpl;
import com.application.entity.Thank;
import com.application.entity.User;

@Controller
@RequestMapping(value = "/t")
@SessionAttributes(value = { "loginUser" })
public class ThankService {

	private ThankBiz thankBiz = new ThankBizImpl();
	
	private UserBiz userBiz = new UserBizImpl();

	private Thank thank;

	/**
	 * 前端显示感谢数据
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/showThank", method = RequestMethod.GET)
	public String showThank(Map<String, Object> data) {
		int creator = 1; // 创建人id
		thank = thankBiz.fetchThank(creator);
		data.put("thank", thank);
		// 获取导航
		data.put("action", "showThank");
		return "thank";
	}

	/**
	 * 后端显示感谢数据
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/thankManager", method = RequestMethod.GET)
	public String thankManager(Map<String, Object> data) {
		User user = (User) data.get("loginUser");
		if (user.getId() == null) {
			user = new User();
			user.setId(1); // 设置创建人为 1 管理员
		}
		thank = thankBiz.fetchThank(user.getId());
		user = userBiz.fetchUserById(user.getId());
		setMap(data, "thank", thank);
		setMap(data, "showUser", user);
		return "/admin/thank/index";
	}

	@RequestMapping(value = "/thankEdit/{id}", method = RequestMethod.GET)
	public String thankEdit(@PathVariable(value = "id") Integer id,
			Map<String, Object> data) {
		if (id != null) {
			thank = thankBiz.fetchThank(id);
			if (thank != null) {
				setMap(data, "el", "thank");
				setMap(data, "thankEdit", thank);
			}
			return "/admin/thank/edit-thank";
		}
		return "/admin/index";
	}

	@RequestMapping(value = "/thankEdit/{id}", method = RequestMethod.POST)
	public String thankEdit(Thank editThank, Map<String, Object> data) {
		thank = thankBiz.fetchThank(editThank.getCreator());
		if (thank != null) {
			thank.setTitle(editThank.getTitle());
			thank.setContent(editThank.getContent());
			if (thankBiz.updateThank(thank)) {
				return "redirect:/t/thankManager";
			}
			return "redirect:/t/thankManager";
		}
		return "redirect:/t/thankEdit/" + editThank.getId();
	}

	/**
	 * 设置请求返回值
	 * 
	 * @param data
	 * @return
	 */
	private Map<String, Object> setMap(Map<String, Object> data, String key,
			Object value) {
		data.put(key, value);
		return data;
	}

}
