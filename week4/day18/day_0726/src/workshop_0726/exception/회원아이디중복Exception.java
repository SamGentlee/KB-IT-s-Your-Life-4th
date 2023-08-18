package workshop_0726.exception;

public class 회원아이디중복Exception extends Exception {
	
	public 회원아이디중복Exception() {
		super("해당 아이디가 이미 존재합니다.");
	}
	public 회원아이디중복Exception(String message) {
		super(message);
	}
	
	
}
