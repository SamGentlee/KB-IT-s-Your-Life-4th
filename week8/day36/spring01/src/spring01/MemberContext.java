package spring01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberContext {
	
	@Bean
	public MemberDaoImpl memberDao() {
		return new MemberDaoImpl();
	}
	
	@Bean
	public MemberDaoMySqlImpl memberMySqlDao() {
		return new MemberDaoMySqlImpl();
	}
	
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDaoMySqlImpl();
//	}
	
	@Bean
	MemberService memberService() {
		return new MemberService();
	}
}
