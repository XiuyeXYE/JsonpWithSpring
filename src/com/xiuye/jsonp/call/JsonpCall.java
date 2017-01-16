package com.xiuye.jsonp.call;

import java.util.Map;

import com.xiuye.jsonp.callback.JsonpCallback;

public interface JsonpCall {

	public String call(String callback,String jsonData);
	public String call(JsonpCallback callback,String intenedCallback);
	public String call(JsonpCallback callback,String intenedCallback, Map<String,String[]> map);

}
