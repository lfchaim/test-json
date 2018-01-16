package com.whs.testjson.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.whs.testjson.util.FileUtil;
import com.whs.testjson.util.MapUtil;

public class LoadHeaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = FileUtil.readContent("C:\\temp\\santander\\Joson-XML\\detalheProduto_1489448166555-OK.json");
		Gson gson = new Gson();
		Calendar c1 = Calendar.getInstance();
		Map<String,Object> map = gson.fromJson(content, LinkedHashMap.class);
		Calendar c2 = Calendar.getInstance();
		System.out.println("Leitura: "+(c2.getTimeInMillis()-c1.getTimeInMillis()));
		List<String> list = new ArrayList<String>();
		c1 = Calendar.getInstance();
		MapUtil.loadHeader(map, list, 0, "");
		c2 = Calendar.getInstance();
		System.out.println("Recursivo: "+(c2.getTimeInMillis()-c1.getTimeInMillis()));
		for( int i = 0; i < 100; i++ ) {
			System.out.println("KEYS: "+list.get(i));
		}
		
	}

}
