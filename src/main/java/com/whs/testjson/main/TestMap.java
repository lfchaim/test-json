package com.whs.testjson.main;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TestMap {

	public static void main(String[] args) {
		Gson gson = getGson();

		String json = "{\"listaCredencial\":[{\"login\":\"login\",\"nomeCompleto\":\"nomeCompleto\"},{\"login\":\"login\",\"nomeCompleto\":\"nomeCompleto\"}]}";
		System.out.println(" json: " + json);

		Map<String, Object> map = gson.fromJson(json, Map.class);
		String json2 = gson.toJson(map);
		System.out.println("json2: " + json2);

		json = "{\"listaDadosColaborador\":[{\"login\":\"login\",\"colaborador\":{\"pessoaDadosBasicos\":{\"tipoPessoa\":\"F\"},\"cargo\":{\"ativo\":true}},\"filialComercial\":\"\"},{\"login\":\"login\",\"colaborador\":{\"pessoaDadosBasicos\":{\"tipoPessoa\":\"F\"},\"cargo\":{\"ativo\":true}},\"filialComercial\":\"\",\"comission\":2.7539,\"area\":394728369888}]}";
		System.out.println(" json: " + json);
		map = gson.fromJson(json, Map.class);
		System.out.println(map.get("listaDadosColaborador"));
		json2 = gson.toJson(map);
		System.out.println("json2: " + json2);
	}

	private static Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
			public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
				if (Math.ceil(src) == Math.floor(src)) {
					Long value = (long) Math.round(src);
					return new JsonPrimitive(value);
				} else {
					return new JsonPrimitive(src);
				}
			}
		});
		gsonBuilder.registerTypeAdapter(Float.class, new JsonSerializer<Float>() {
			public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
				if (Math.ceil(src) == Math.floor(src)) {
					Long value = (long) Math.round(src);
					return new JsonPrimitive(value);
				} else {
					return new JsonPrimitive(src);
				}
			}
		});

		Gson gson = gsonBuilder.create();
		return gson;
	}
}
