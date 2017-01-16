package com.xiuye.jsonp.execute;

import java.util.List;
import java.util.Map;

import com.xiuye.jsonp.call.DefaultJsonpCall;
import com.xiuye.jsonp.call.JsonpCall;
import com.xiuye.jsonp.callback.JsonpCallback;
import com.xiuye.jsonp.callback.manager.JsonpCallbackManager;

public final class DefaultExecute {

	private static final JsonpCall jsonpCall = new DefaultJsonpCall();
	private static final List<JsonpCallback> callbacks;
	static {
		callbacks = JsonpCallbackManager.listCallbacks();
	}

	public String jsonp(String callback, Map<String, String[]> map) {

		for (JsonpCallback jsonpCallback : callbacks) {

			String s = jsonpCall.call(jsonpCallback, callback, map);
			if (s != null) {
				return s;
			}

		}
		return null;

	}

	public String jsonp(String callback) {

		for (JsonpCallback jsonpCallback : callbacks) {
			
			String s = jsonpCall.call(jsonpCallback, callback);
			if (s != null) {
				return s;
			}

		}
		return null;
	}

}
