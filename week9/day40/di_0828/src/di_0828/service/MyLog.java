package di_0828.service;

import org.springframework.stereotype.Component;

@Component
public class MyLog {
	
	public void log(String string) {
		System.out.println("화면 : "+string);
	}
	
}
