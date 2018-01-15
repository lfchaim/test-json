package com.whs.testjson.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.whs.testjson.util.FileUtil;
import com.whs.testjson.util.MapUtil;

public class LoadHeaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = FileUtil.readContent("C:\\temp\\santander\\Joson-XML\\detalheProduto_MULTIPLO.json");
		Gson gson = new Gson();
		Map<String,Object> map = gson.fromJson(content, LinkedHashMap.class);
		List<String> list = new ArrayList<String>();
		MapUtil.loadHeader(map, list, 0, "");
		for( int i = 0; i < list.size(); i++ ) {
			System.out.println("KEYS: "+list.get(i));
		}
		
	}

}
