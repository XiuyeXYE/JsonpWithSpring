package com.xiuye.jsonp.callback;

import com.xiuye.jsonp.callback.manager.JsonpCallbackManager;

public abstract class AbstractJsonpCallback {

	public AbstractJsonpCallback() {
		
		JsonpCallbackManager.register(this);
		
	}

}
