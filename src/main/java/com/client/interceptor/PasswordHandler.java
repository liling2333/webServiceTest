package com.client.interceptor;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
/**
 * 客户端密码设置类
 * @author liling
 *
 */
public class PasswordHandler implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {  
            WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];  
            pc.setPassword("ling");  
        }  
	}

}
