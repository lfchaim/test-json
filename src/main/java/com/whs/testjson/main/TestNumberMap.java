package com.whs.testjson.main;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class TestNumberMap {

	public static void main(String[] args) {

		Map<String, Number> map = new HashMap<String, Number>();
		map.put("int", 123);
		map.put("long", 1234567890123456789L);
		map.put("double", 1234.5678D);
		map.put("float", 1.2345F);
		Type mapType = new TypeToken<Map<String, Number>>() {
		}.getType();
		Gson gson = new GsonBuilder().registerTypeAdapter(Number.class, new NumberTypeAdapter()).create();
		String json = gson.toJson(map, mapType);
		System.out.println(json);

		Map<String, Number> deserializedMap = gson.fromJson(json, mapType);
		System.out.println(deserializedMap);
	}

	public static class NumberTypeAdapter
			implements JsonSerializer<Number>, JsonDeserializer<Number>, InstanceCreator<Number> {

		public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src);
		}

		public Number deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive();
			if (jsonPrimitive.isNumber()) {
				return jsonPrimitive.getAsNumber();
			} else {
				throw new IllegalStateException("Expected a number field, but was " + json);
			}
		}

		public Number createInstance(Type type) {
			return 1L;
		}
	}
}
