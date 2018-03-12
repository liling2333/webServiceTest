package com.web.interceptor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 * 拦截器
 * @author liling
 *
 */
public class AuthIntercepter extends AbstractPhaseInterceptor<SoapMessage>{

	/**
	 * 显式调用父类有参构造器，因为父类没有无参构造方法
	 * @param phase 
	 */
	public AuthIntercepter() {
		super(Phase.PRE_INVOKE); //表示在调用前让拦截器起作用
	}

	//自定义拦截器时需要实现此方法，其中的形参就是拦截到的soap消息
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Fault fault = new Fault(new Exception(""));
		System.out.println("拦截消息开始-----" + "\r\n");
		System.out.println(message + "\r\n");
		
		Header header = message.getHeader(new QName("AuthHeader"));
		if(header == null){
			System.out.println("认证消息为空");
			fault.setMessage("认证消息为空");
			throw fault;
		}
		Element el = (Element) header.getObject();
		NodeList userNames = el.getElementsByTagName("userName");
		NodeList passwords = el.getElementsByTagName("password");
		if(userNames.getLength() != 1 || passwords.getLength() != 1){
			System.out.println("用户名或密码格式不正确");
			fault.setMessage("用户名或密码格式不正确");
			throw fault;
		}
		String userName = userNames.item(0).getTextContent();
		String password = passwords.item(0).getTextContent();
		if(!userName.equals("ling") || !password.equals("ling")){
			System.out.println("用户名或密码错误");
			fault.setMessage("用户名或密码错误");
			throw fault;
		}
		System.out.println("登录成功");
		System.out.println("拦截消息结束-----" );
	}


}
