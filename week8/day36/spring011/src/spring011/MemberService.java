package spring011;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
	
	@Autowired(required = false)
	//같은타입의 빈이 여러개 등록된 경우 빈이름으로 지정
	private MemberDao dao;
	
	public boolean login(String id, String passwd) {
		System.out.println("dao = "+ dao);
		return false;
	}
}
