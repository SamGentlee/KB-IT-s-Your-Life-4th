package spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppContext2.class)
public class AppContext {
	@Autowired
	private MyLog log;
	
	@Bean
	public MyCalc mc() {
		//return new MyCalc(filelog()); //생성자를 통한 DI
		
		MyCalc mc = new MyCalc();
		mc.setMyLog(log); //setter를 통한 DI
		return mc;
	}
	
	
	@Bean
	public HelloService hello() {
		return new HelloServiceEn();
	}
}
