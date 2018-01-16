package com.whs.testjson.main;

import java.io.File;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

public class ParseJsonSample {
	public static void main(String[] args) throws Exception {
		test2();
	}
	
	private static void test2() {
		String fileName = "C:\\temp\\santander\\Joson-XML\\detalheProduto_1489448166555-OK.json";
		try {
			JsonParser parser = new JsonFactory().createParser(new File(fileName));
			parser.nextToken(); // JsonToken.START_OBJECT;
			while (parser.nextToken() != JsonToken.END_OBJECT) {
			    final String name = parser.getCurrentName();
			    parser.nextToken(); // JsonToken.START_ARRAY;
			    parser.nextValue();
			    String value = parser.getText();
			    System.out.println(name + ": " + value);
			    parser.nextToken(); // JsonToken.END_ARRAY;
			}
			parser.close();
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private static void test1() {
		String fileName = "C:\\temp\\santander\\Joson-XML\\detalheProduto_1489448166555-OK.json";
		try {
			JsonFactory f = new MappingJsonFactory();
			JsonParser jp = f.createJsonParser(new File(fileName));
			JsonToken current;
			current = jp.nextToken();
			if (current != JsonToken.START_OBJECT) {
				System.out.println("Error: root should be object: quiting.");
				return;
			}
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = jp.getCurrentName();
				// move from field name to field value
				current = jp.nextToken();
				if( fieldName.equals("records") || true ) {
					if (current == JsonToken.START_ARRAY) {
						// For each of the records in the array
						while (jp.nextToken() != JsonToken.END_ARRAY) {
							// read the record into a tree model,
							// this moves the parsing position to the end of it
							JsonNode node = jp.readValueAsTree();
							// And now we have random access to everything in the object
							//System.out.println("field1: " + node.get("field1").getValueAsText());
							//System.out.println("field2: " + node.get("field2").getValueAsText());
							System.out.println("field1: " + node.get("field1"));
							System.out.println("field2: " + node.get("field2"));
						}
					} else {
						System.out.println("Error: records should be an array: skipping.");
						jp.skipChildren();
					}
				} else {
					System.out.println("Unprocessed property: " + fieldName);
					jp.skipChildren();
				}
			}
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
}