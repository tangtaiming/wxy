package com.application.util;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrintUtil {

	/**
	 * 打印公用方法
	 * @param object
	 */
	public static void printUtil(Object object) {
		System.out.println("++++++++++++++++++++++++++++++++");
		try {
			Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues()
					.serializeNulls().setPrettyPrinting().create();
			System.out.println(gson.toJson(object));
		} catch (Exception e) {
			System.out.println(ToStringBuilder.reflectionToString(object,
					ToStringStyle.MULTI_LINE_STYLE));
		}
		System.out.println("++++++++++++++++++++++++++++++++");
	}
	
}