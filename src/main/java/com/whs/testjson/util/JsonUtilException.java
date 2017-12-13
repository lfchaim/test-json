package com.whs.testjson.util;

public class JsonUtilException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JsonUtilException(){}
	
	public JsonUtilException(String msg){
		super(msg);
	}

	public JsonUtilException(String msg, Throwable cause){
		super(msg,cause);
	}

	public JsonUtilException(Throwable cause){
		super(cause);
	}

}
