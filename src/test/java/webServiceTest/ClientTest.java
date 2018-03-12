package webServiceTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.web.client.RestTemplate;

import com.client.Person;
import com.client.UserService;
import com.client.UserServiceImplService;
import com.client.interceptor.PasswordHandler;
import com.mysql.jdbc.Util;
import com.web.pojo.User;

import antlr.Utils;

/**
 * 客户端调用测试
 * 
 * @author liling
 *
 */
public class ClientTest {

	public static void main(String args[]) throws Exception {
		
		// 测试soap webservice 客户端调用  方式1
		URL wsdlURL = new URL("http://localhost:8080/webServiceTest/webservice/getPersonById?wsdl");
		 QName SERVICE_NAME = new QName("http://outputService.web.com/", "UserServiceImplService");
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
	    Client client = dcf.createClient(wsdlURL, SERVICE_NAME);  
	    client.getInInterceptors().add(new LoggingInInterceptor());
	    client.getOutInterceptors().add(new LoggingOutInterceptor());
	    
	    Object[] response = client.invoke("getPersonById", 1);
        Person person = new Person();
        BeanUtils.copyProperties(response[0], person);
		System.out.println(person.getName());
		
		// 测试soap webservice 客户端调用  方式2
		/*try {
			URL wsdlURL = new URL("http://localhost:8080/webServiceTest/webservice/getPersonById?wsdl");
			QName SERVICE_NAME = new QName("http://outputService.web.com/", "UserServiceImplService");
			// 实例化接口对象
			UserServiceImplService ss = new UserServiceImplService(wsdlURL, SERVICE_NAME);
			UserService port = ss.getUserServiceImplPort();
			BindingProvider bindingProvider = (BindingProvider) port;

			setClient(bindingProvider); //客户端设置

			Person person = port.getPersonById(1); //发送请求
			System.out.println(person.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
*/
		// 测试restful webservice 客户端调用
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8080/webServiceTest/webservice/myservice" + "/user/1/",
				User.class);
		if (user != null) {
			System.out.println("User : id=" + user.getId() + ", Name=" + user.getName());
			;
		} else {
			System.out.println("No user exist----------");
		}

	}

	/**
	 * 客户端设置
	 * @param bindingProvider
	 * @throws FileNotFoundException 
	 */
	private static void setClient(BindingProvider bindingProvider) throws FileNotFoundException {
		// 添加客户端拦截器
		File file = new File("E:\\Testworkspace\\test4.log");
		OutputStream out = new FileOutputStream(file, true);
		Client client = ClientProxy.getClient(bindingProvider);
		client.getInInterceptors().add(new LoggingInInterceptor(new PrintWriter(out, true)));
		//client.getInInterceptors().add(new AuthInterceptor("ling", "ling"));
		client.getOutInterceptors().add(new LoggingOutInterceptor(new PrintWriter(out, true)));
		
		// 设置客户端超时时间
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy clientPolicy = new HTTPClientPolicy();
		clientPolicy.setConnectionTimeout(30000); // 连接超时时间
		clientPolicy.setReceiveTimeout(180000); // 请求超时时间
		conduit.setClient(clientPolicy);

		// 客户端请求信息设置
		Map<String, Object> props = new HashMap<String, Object>();
		//验证方式
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		// 密码类型 明文:PasswordText密文：PasswordDigest
		// props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		// 用户名
		props.put(WSHandlerConstants.USER, "liling");
		// 将PasswordHandler 的类名传递给服务器，相当于传递了密码给服务器。验证回调函数
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordHandler.class.getName());
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
		client.getOutInterceptors().add(wssOut);

	}
}
