package webServiceTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.controller.UserController;
import com.web.pojo.Person;

/**
 * 
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:/spring/**/*.xml"})
public class Test {
	@Autowired
	ApplicationContext  act;

	@org.junit.Test
	public void main(){
		UserController userController = act.getBean(UserController.class); 
		Person person = userController.getUserById(1);
		System.out.println(person.getName());
	}
}
