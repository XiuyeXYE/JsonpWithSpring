package com.xiuye.jsonp.callback.manager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.xiuye.jsonp.call.DefaultJsonpCall;
import com.xiuye.jsonp.call.JsonpCall;
import com.xiuye.jsonp.callback.JsonpCallback;
import com.xiuye.jsonp.execute.DefaultExecute;

public class JsonpCallbackManager {

	private static final List<Object> callbackMappers = new ArrayList<Object>(); 

	public static void register(Object callbackMapper){
		callbackMappers.add(callbackMapper);
	}
	
	public static void remove(Object callbackMapper){
		callbackMappers.remove(callbackMapper);
	}
	public static void remove(int index){
		callbackMappers.remove(index);
	}
	
	public static List<JsonpCallback> listCallbacks(){
		List<JsonpCallback> list = new ArrayList<JsonpCallback>();
		for(Object o : callbackMappers){
			list.add(jsonpCallback(o));
		}
		return list;
	}
	
	private static JsonpCallback jsonpCallback(Object callbackMapper){
		
		Method[] ms = callbackMapper.getClass().getDeclaredMethods();
		
		JsonpCallback jsonCallback = new JsonpCallback(callbackMapper,ms);
		return jsonCallback;
	}
	
	public static List<Object> listCallbackMappers(){
		return callbackMappers;
	}
	
	public static JsonpCall defaultJsonpCall(){
		return new DefaultJsonpCall();
	}
	public static DefaultExecute defaultExecute(){
		return new DefaultExecute();
	}
	
	
}
