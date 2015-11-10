package com.application.servlet;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.util.DBUtil;

@Controller
@RequestMapping(value="/hello")
public class TestServlet {

	private DBUtil dbUtil;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() throws SQLException {
		dbUtil.getCon();
		return "index";
	}

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
	
}
