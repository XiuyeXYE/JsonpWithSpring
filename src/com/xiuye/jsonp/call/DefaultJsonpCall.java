package com.xiuye.jsonp.call;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.xiuye.jsonp.callback.JsonpCallback;

public final class DefaultJsonpCall implements JsonpCall {

	@Override
	public String call(String callback, String jsonData) {
		return callback + "(" + jsonData + ")";
	}

	@Override
	public String call(JsonpCallback callback, String intenedCallback) {

		Object o = callback.getMapper();
		Method[] ms = callback.getCallbacks();
		for (Method m : ms) {
			if (intenedCallback.trim().equalsIgnoreCase(m.getName().trim())) {
				try {
					return this.call(intenedCallback, (String) m.invoke(o));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public String call(JsonpCallback callback, String intenedCallback,
			Map<String, String[]> map) {

		Object o = callback.getMapper();
		Method[] ms = callback.getCallbacks();
		for (Method m : ms) {
			if (intenedCallback.trim().equalsIgnoreCase(m.getName().trim())) {
				try {
					
					return this
							.call(intenedCallback, (String) m.invoke(o, map));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
