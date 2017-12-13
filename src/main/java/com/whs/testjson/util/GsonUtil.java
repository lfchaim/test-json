package com.whs.testjson.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonUtil {

	public static Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
			public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
				if( Math.ceil(src) == Math.floor(src) ){
					Integer value = (int) Math.round(src);
					return new JsonPrimitive(value);
				}else{
					return new JsonPrimitive(src);
				}
			}
		});
		gsonBuilder.registerTypeAdapter(Float.class, new JsonSerializer<Float>() {
			public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
				if( Math.ceil(src) == Math.floor(src) ){
					Integer value = (int) Math.round(src);
					return new JsonPrimitive(value);
				}else{
					return new JsonPrimitive(src);
				}
			}
		});
		Gson gson = gsonBuilder.create();
		return gson;
	}
	
	public static boolean isList( String json ){
		return json.trim().startsWith("[");
	}
}
