package day_03;

public class StaticExam {
	
	int age = 0;
	
	public static void main(String[] args) {
		new StaticExam().age = 100;
		//age = 100; 구문 오류
		
		//staic 내부에서는 this 사용불가
		test1(); //static 메서드안에서의 직접호출은 static만 가능
		
	}
	
	static void test1() {
		
	}
}
