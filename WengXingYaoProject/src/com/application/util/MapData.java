package com.application.util;

import java.util.HashMap;
import java.util.Map;

public class MapData {

	/**
	 * 给传入的Map设置值
	 * @param map
	 * @param key
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> and(Map<String, Object> map, String key, Object obj) {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		map.put(key, obj);
		return map;
	}
	
}
