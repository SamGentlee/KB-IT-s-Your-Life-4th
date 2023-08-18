package workshop_0726.exception;

public class 미등록물건Exception extends Exception {
	
	public 미등록물건Exception() {
		super("등록되어있는 물품 중에 해당 관리번호를 가진 물품이 없습니다.");
	}
	
	public 미등록물건Exception(String message) {
		super(message);
	}
}
