package workshop_0726.exception;

public class 미등록회원idException extends Exception {
	
	public 미등록회원idException() {
		super("해당 id가 존재하지 않습니다.");
	}
	
	public 미등록회원idException(String message) {
		super(message);
	}
}
