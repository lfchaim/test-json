package com.whs.testjson.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ParseJson {

	private static String margin = "   ";
	private static String indent = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fileName = "C:\\temp\\santander\\Joson-XML\\detalheProduto_1489448166555-OK.json";
			JsonParser parser = new JsonFactory().createParser(new File(fileName));
			if( parser.nextToken() == JsonToken.START_OBJECT )
				processJSONObject(parser,indent);
			else if( parser.nextToken() == JsonToken.START_ARRAY )
				processJSONArray(parser,indent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void processJSONObject(JsonParser parser, String indent) throws IOException {
		System.out.println(margin + "JSON Object");
		indent += " ";
		while (!parser.isClosed()) {
			JsonToken token = parser.nextToken();
			if (JsonToken.END_OBJECT.equals(token)) {
				// The end of the JSON object has been reached
				break;
			}
			if (!JsonToken.FIELD_NAME.equals(token)) {
				System.out.println("Error. Expected a field name");
				break;
			}
			System.out.println(indent + "Field: " + parser.getCurrentName());
			token = parser.nextToken();
			processJSONValue(token, parser, indent);
		}
	}

	private static void processJSONArray(JsonParser parser, String margin) throws IOException {
		System.out.println(margin + "JSON Array");
		indent += " ";
		while (!parser.isClosed()) {
			JsonToken token = parser.nextToken();
			if (JsonToken.END_ARRAY.equals(token)) {
				// The en of the array has been reached
				break;
			}
			processJSONValue(token, parser, indent);
		}
	}

	private static void processJSONValue(JsonToken token, JsonParser parser, String indent) throws IOException {
		if (JsonToken.START_OBJECT.equals(token)) {
			processJSONObject(parser, indent);
		} else if (JsonToken.START_ARRAY.equals(token)) {
			processJSONArray(parser, indent);
		} else {
			System.out.println(margin + "Value: " + parser.getValueAsString());
		}
	}
}
