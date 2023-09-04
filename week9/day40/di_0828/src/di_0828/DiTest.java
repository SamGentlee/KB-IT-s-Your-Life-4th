package di_0828;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di_0828.config.AppContext2;
import di_0828.service.HelloService;

public class DiTest {
	public static void main(String[] args) {
		//스프링은 서비스 클래스 등록후 검색, 사용
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("beans.xml");
//		ApplicationContext context =
//				new GenericXmlApplicationContext("classpath:beans.xml");
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppContext2.class);
		//클래스 검색
		//HelloService hs = context.getBean(HelloService.class); 
		//이름검색 id, name 속성값 또 메서드명
		HelloService hs = (HelloService)context.getBean("helloService"); 
		String hello = hs.hello();
		System.out.println(hello);
	}
}
