package spring01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext2 {
	
	@Bean
	public MyFileLog filelog() { 
		return new MyFileLog();
	}
//	@Bean
//	public MyLog log() { 
//		return new MyLog();
//	}
//	
}
