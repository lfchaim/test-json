package com.whs.testjson.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static <T> T fromJson( String json ) throws JsonUtilException {
		try{
			ObjectMapper mapper = new ObjectMapper();
			if( json.trim().startsWith("[") ){
				return mapper.readValue(json, new TypeReference<List<Map<String,Object>>>(){});
			}else{
				return mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
			}
		}catch( JsonMappingException e ){
			throw new JsonUtilException(e.getMessage(),e.getCause());
		}catch( JsonParseException e ){
			throw new JsonUtilException(e.getMessage(),e.getCause());
		}catch( IOException e ){
			throw new JsonUtilException(e.getMessage(),e.getCause());
		}
	}
	
	public static String toJson( Object obj ) throws JsonUtilException {
		try{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		}catch( JsonProcessingException e ){
			throw new JsonUtilException(e.getMessage(),e.getCause());
		}
	}
}
