package com.whs.testjson;

import com.google.gson.Gson;
import com.whs.testjson.model.Customer;

public class TestGson2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = "{\"code\":2,\"name\":\"First Last 2\",\"document\":\"999.999.999-99\",\"active\":true,\"createDate\":\"Dec 11, 2017 6:38:27 PM\",\"listAddress\":[{\"code\":2,\"address\":\"2, 1st Avenue\",\"number\":\"1001\",\"complement\":\"compl. 2\",\"zipCode\":\"33100\",\"Neighbor\":\"Neighbor \"},{\"code\":2,\"address\":\"2, 1st Avenue\",\"number\":\"1001\",\"complement\":\"compl. 2\",\"zipCode\":\"33101\",\"Neighbor\":\"Neighbor \"},{\"code\":2,\"address\":\"2, 1st Avenue\",\"number\":\"1001\",\"complement\":\"compl. 2\",\"zipCode\":\"33102\",\"Neighbor\":\"Neighbor \"}],\"default\":false}";
		Gson gson = new Gson();
		Customer c = gson.fromJson(json, Customer.class);
		System.out.println(c.isDefault());
	}

}
