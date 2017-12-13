package com.whs.testjson.main;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TestString {

	public static void main(String[] args) {
		// Previne que na conversao, seja adicionado ponto decimal
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Double.class,  new JsonSerializer<Double>() {
		    public JsonElement serialize(Double src, Type typeOfSrc,JsonSerializationContext context) {
		    	if( Math.ceil(src) == Math.floor(src) ) {
		    		Integer value = (int)Math.round(src);
		            return new JsonPrimitive(value);
		    	}else {
		            return new JsonPrimitive(src);
		    	}
		        }
		    });

		Gson gson = gsonBuilder.create();
		//Gson gson = new Gson();
		String strJson = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":25,\"ranking\":76.25,\"address\":[{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10021\"},{\"streetAddress\":\"211 3th Street\",\"city\":\"New York\",\"state\":\"NY\",\"postalCode\":\"10071\"}],\"phoneNumber\":[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]}";
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(strJson, map.getClass());
		String newJson = gson.toJson(map);
		System.out.println(strJson.equals(newJson)+" :: strJson: "+strJson.length()+" newJson: "+newJson.length());
		System.out.println(strJson);
		System.out.println(newJson);
	}
}
