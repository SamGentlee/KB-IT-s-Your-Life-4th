package di_0828.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import di_0828.service.HelloService;

@Configuration
@ComponentScan(basePackages = {"di_0828.service"})
public class AppContext2 {
	@Bean
	public HelloService hs() {
		return new HelloService();
	}
}
