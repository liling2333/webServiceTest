package com.web.test;

import java.io.IOException;  

import javax.security.auth.callback.Callback;  
import javax.security.auth.callback.CallbackHandler;  
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

  
  
public class UTPasswordServerCallBack implements CallbackHandler {  
  
    public void handle(Callback[] callbacks) throws IOException,  
            UnsupportedCallbackException {  
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];  
        pc.setPassword("keypass");  
        System.out.println("Server Identifier=" + pc.getIdentifier());  
        System.out.println("Server Password=" + pc.getPassword());  
    }  
}  
