package day_0726;

public class LoginExam {
	public static void main(String[] args) {
		String id = "user100";
		String passwd="1111";
		try {
			// id 검사
			// 비번 검사
			// 잠김 검사
			login(id,passwd);
			System.out.println("로그인 성공");
		} catch (NoRegisterIdException e) {
			e.printStackTrace();
			System.out.println("메세지 : "+e.getMessage());
		} catch (IncorrectPwdException e) {
			e.printStackTrace();
			System.out.println("메세지 : "+e.getMessage());
		}
	}

	private static void login(String id, String passwd) throws NoRegisterIdException, IncorrectPwdException {
		if( id != "user100") {
			throw new NoRegisterIdException(id+"는 없는 아이디입니다.");
		}
		if( passwd != "1111") {
			throw new IncorrectPwdException("비밀번호가 틀립니다.");
		}
	}//end login
}
