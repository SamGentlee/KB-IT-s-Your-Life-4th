package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		//xml설정파일 읽기
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		//설정파일에서 HelloService 검색
		HelloService hs = 
				context.getBean(HelloService.class); //객체(뒷)부분을 스프링에서 관리
		//서비스 메서드 호출		
		String msg = hs.hello();
		System.out.println(msg);
	}

}
