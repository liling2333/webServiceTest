package com.client.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	private String userName;
	private String password;
	
	public AuthInterceptor(String userName, String password) {
		super(Phase.PREPARE_SEND); //表示准备发送soap消息的时候调用此方法
		this.userName = userName;
		this.password = password;
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Document document = DOMUtils.createDocument(); //生成Document对象
		
		//创建xml 代码片段
		Element element = document.createElement("AuthHeader");
		Element userNameEle = document.createElement("userName");
		userNameEle.setTextContent(userName);
		Element passwordEle = document.createElement("password");
		passwordEle.setTextContent(password);
		element.appendChild(userNameEle);
		element.appendChild(passwordEle);
		
		// 将element 对象包装成Header类，然后添加到SOAP消息的Header列表中
		List<Header> headers = message.getHeaders();
		headers.add(new Header(new QName("AuthHeader"), element));
	}

}
