package com.whs.testjson.main;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.whs.testjson.util.FileUtil;

public class TestJsonPath {

	public static void main(String[] args) {
		String jsonDataSourceString = FileUtil.readContent("C:\\temp\\santander\\Joson-XML\\detalheProduto_MULTIPLO.json");
		DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
		System.out.println(jsonContext.toString());
	}

}
