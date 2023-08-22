package spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberService {
	
	@Autowired(required = false)
	@Qualifier("memberDao") //주입할 빈이름 지정
	private MemberDao dao;
	
	public boolean login(String id, String passwd) {
		System.out.println("dao = "+ dao);
		return false;
	}
}
