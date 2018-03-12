package com.web.interceptor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.LoggerFactory;

/** 
*继承一个拦截器类 
*/  
public class LogInterceptor extends LoggingInInterceptor{  
	 private static final Logger LOG = LogUtils.getLogger(LogInterceptor.class);
      
    public LogInterceptor(String phase) {  
        super(phase);  
    }  
    public LogInterceptor(){  
        super(Phase.RECEIVE);  
    }  
  
    public void handleFault(Message message) {  
        org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());  
        Exception exeption=message.getContent(Exception.class);  
        logger.error(exeption.getMessage(),exeption);  
    }  
    public void handleMessage(Message message) throws Fault {
    	try {
            String xml;
            InputStream is = message.getContent(InputStream.class);
            
            String encoding = (String)message.get(Message.ENCODING);
            xml = IOUtils.toString(is);
           
            System.out.println("输入报文为：" + xml);
            message.setContent(InputStream.class, new ByteArrayInputStream(xml.getBytes(encoding)));
            message.getExchange().put("idtest", xml);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
