package com.whs.testjson.main;

import java.util.List;
import java.util.Map;

import com.whs.testjson.util.GsonUtil;
import com.whs.testjson.util.JsonUtil;

public class TestNumber {

	public static void main(String[] args) {
		String jsonList = "[{\"id\":4077395,\"field_id\":242566,\"body\":\"\"},{\"id\":4077398,\"field_id\":242569,\"body\":[[273019,0],[273020,1],[273021,0]]},{\"id\":4077399,\"field_id\":242570,\"body\":[[273022,0],[273023,1],[273024,0]]}]";
		String jsonObj = "{\"listOfItem\":[{\"id\":4077395,\"field_id\":242566,\"body\":\"\"},{\"id\":4077398,\"field_id\":242569,\"body\":[[273019,0],[273020,1],[273021,0]]},{\"id\":4077399,\"field_id\":242570,\"body\":[[273022,0],[273023,1],[273024,0]]}]}";
		testJsonList(jsonList);
		testJsonObject(jsonObj);
	}

	private static void testGson( String json ){
		if( GsonUtil.isList(json) ){
			List<Map<String,Object>> listMap = GsonUtil.getGson().fromJson(json, List.class);
			System.out.println(listMap.get(0).get("field_id"));
		}
	}
	
	private static void testJsonList( String json ){
		List<Map<String,Object>> listMap = JsonUtil.fromJson(json);
		String strJson = JsonUtil.toJson(listMap);
		System.out.println(json);
		System.out.println(strJson);
	}
	
	private static void testJsonObject( String json ){
		Map<String,Object> map = JsonUtil.fromJson(json);
		String strJson = JsonUtil.toJson(map);
		System.out.println(json);
		System.out.println(strJson);
	}
	
}
