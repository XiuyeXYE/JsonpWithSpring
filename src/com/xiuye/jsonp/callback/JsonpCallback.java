package com.xiuye.jsonp.callback;

import java.lang.reflect.Method;

public class JsonpCallback {

	private Object mapper;
	
	private Method[] callbacks;

	
	
	

	public JsonpCallback(Object mapper, Method[] callbacks) {
		this.mapper = mapper;
		this.callbacks = callbacks;
	}

	@Override
	public String toString() {
		return "JsonpCallback [mapper=" + mapper + ", callbacks=" + callbacks
				+ "]";
	}

	public Object getMapper() {
		return mapper;
	}

	public void setMapper(Object mapper) {
		this.mapper = mapper;
	}

	public Method[] getCallbacks() {
		return callbacks;
	}

	public void setCallbacks(Method[] callbacks) {
		this.callbacks = callbacks;
	}

	

	

	
	

}
