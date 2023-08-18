package workshop_0726.exception;

public class 수량부족Exception extends Exception {
	
	public 수량부족Exception() {
		super("수량이 부족합니다.");
	}
	public 수량부족Exception(String message) {
		super(message);
	}
	
}
