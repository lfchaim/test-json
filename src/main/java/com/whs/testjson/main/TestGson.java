package com.whs.testjson.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.whs.testjson.model.Address;
import com.whs.testjson.model.Customer;

/**
 * Hello world!
 *
 */
public class TestGson {
	
	public static void main(String[] args) throws Exception {
		int limit = 1000000;
		Gson gson = new Gson(); 
		List<Customer> list = createData(limit);
		List<String> list2 = createDataJson(limit);
		List<Map> list3 = createDataMap(limit);
		Calendar c1 = Calendar.getInstance();
		for( int i = 0; i < list.size(); i++ ){
			String str = gson.toJson(list.get(i));
		}
		Calendar c2 = Calendar.getInstance();
		System.out.println("Tempo Customer: "+(c2.getTimeInMillis()-c1.getTimeInMillis())+" ms");
		c1 = Calendar.getInstance();
		for( int i = 0; i < list2.size(); i++ ){
			String str = gson.toJson(list2.get(i));
		}
		c2 = Calendar.getInstance();
		System.out.println("Tempo String: "+(c2.getTimeInMillis()-c1.getTimeInMillis())+" ms");
		c1 = Calendar.getInstance();
		for( int i = 0; i < list3.size(); i++ ){
			String str = gson.toJson(list3.get(i));
		}
		c2 = Calendar.getInstance();
		System.out.println("Tempo Map: "+(c2.getTimeInMillis()-c1.getTimeInMillis())+" ms");
	}
	
	private static List<Customer> createData(int limit){
		List<Customer> list = new ArrayList<Customer>();
		for( int i = 0; i < 1000; i++ ){
			Customer customer = new Customer();
			customer.setCode(i+1);
			customer.setName("First Last "+(1+1));
			customer.setDocument("999.999.999-99");
			customer.setCreateDate(new Date());
			customer.setActive(true);
			for( int j = 0; j < 3; j++ ){
				Address addr = new Address();
				addr.setCode(i+1);
				addr.setAddress((i+1)+", 1st Avenue");
				addr.setComplement("compl. "+(i+1));
				addr.setNeighbor("Neighbor ");
				addr.setNumber(""+(1000+i));
				addr.setZipCode("33"+(100+j));
				customer.addAddress(addr);
			}
			list.add(customer);
		}
		return list;
	}
	
	private static List<String> createDataJson(int limit){
		Gson gson = new Gson(); 
		List<Customer> list = createData(limit);
		List<String> ret = new ArrayList<String>();
		for( int i = 0; i < list.size(); i++ ){
			String json = gson.toJson(list.get(i));
			ret.add(json);
		}
		return ret;
	}

	private static List<Map> createDataMap(int limit){
		Gson gson = new Gson(); 
		List<Customer> list = createData(limit);
		List<Map> ret = new ArrayList<Map>();
		for( int i = 0; i < list.size(); i++ ){
			String json = gson.toJson(list.get(i));
			Map map = gson.fromJson(json, LinkedHashMap.class);
			ret.add(map);
		}
		return ret;
	}

}
