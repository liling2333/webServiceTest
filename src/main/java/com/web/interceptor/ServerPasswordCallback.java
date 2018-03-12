package com.web.interceptor;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
/**
 * 服务端密码设置类
 * @author liling
 *
 */
public class ServerPasswordCallback implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        if ("liling".equals(pc.getIdentifier())) {
               pc.setPassword("ling");
           }
	}

}
