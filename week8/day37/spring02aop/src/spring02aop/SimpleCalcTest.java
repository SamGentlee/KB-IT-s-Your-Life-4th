package spring02aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleCalcTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AopContext.class);
		SimpleCalc sm = context.getBean(SimpleCalc.class);
		
		System.out.println(sm.plus(3, 4));
		System.out.println(sm.minus(3, 4));
	}
}
