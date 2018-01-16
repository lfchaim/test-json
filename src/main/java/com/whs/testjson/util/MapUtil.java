package com.whs.testjson.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static void hashMapper(Map<String, Object> map) {
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
	        String key = entry.getKey();
	        Object value = entry.getValue();
	        if (value instanceof Map) {
	            Map<String, Object> subMap = (Map<String, Object>)value;
	            hashMapper(subMap);
	        } else {
	             System.out.println(key + "::" + value);
	        }
	    }
	}
	
	public static void changeValue(Map<String, Object> map, String key, Object objectNew) {
		List<String> listKey = new ArrayList<>();
		if( key.indexOf("|") > 0 ){
			String[] strKey = key.split("\\|");
			listKey = new ArrayList<String>(Arrays.asList(strKey));
		}else{
			listKey.add(key);
		}
		changeObject(map, listKey, objectNew, 0);
	}
	
	public static void changeObject(Map<String, Object> map, List<String> listKey, Object objectNew, int level) {
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
	        String key = entry.getKey();
	        if( level == (listKey.size()-1) && key.equals(listKey.get(level)) ){
	        	map.replace(key, objectNew);
	        }
	        Object value = entry.getValue();
	        if (value instanceof Map) {
	        	level++;
	            Map<String, Object> subMap = (Map<String, Object>)value;
	            changeObject(subMap, listKey, objectNew, level);
	        } else {
	             System.out.println(key + "::" + value);
	        }
	    }
	}

	public static void main(String[] args){
		Map<String,Object> map = new LinkedHashMap<>();
		map.put("name", "Name level 0");
		map.put("code", "001");
		Map<String,Object> map1 = new LinkedHashMap<>();
		map1.put("name", "Name level 1");
		map1.put("doc", "987654");
		Map<String,Object> map2 = new LinkedHashMap<>();
		map2.put("name", "Name level 2");
		map2.put("date", "2017-12-01");
		Map<String,Object> map3 = new LinkedHashMap<>();
		map3.put("name", "Name level 3");
		map3.put("value", "19.45");
		map2.put("map", map3);
		map1.put("map", map2);
		map.put("map", map1);
		changeValue(map, "name|name|name", "Name changed");
		String json = GsonUtil.toJson(map);
		System.out.println("json: "+json);
	}
	
	public static void loadHeader(Map<String, Object> map, List<String> listHeader, int level, String parentName) {
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
	        String key = entry.getKey();
	        if( !listHeader.contains(""+level+"_"+key) )
	        	listHeader.add(parentName+"/"+key);
	        Object value = entry.getValue();
	        if (value instanceof Map) {
	            Map<String, Object> subMap = (Map<String, Object>)value;
	            loadHeader(subMap,listHeader,level++,parentName+"/"+key);
	        } else if (value instanceof List) {
	        	List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>)value;
	        	for( int i = 0; i < list.size(); i++ ) {
	        		if( list.get(i) instanceof Map ) {
	        			loadHeader(list.get(i), listHeader, level++, parentName+"/"+key);
	        		} else {
	        			// System.out.println(key + "::" + value + "::" +level);
	        		}
	        	}
	        } else {
	            // System.out.println(key + "::" + value + "::" +level);
	        }
	    }
	}
}
