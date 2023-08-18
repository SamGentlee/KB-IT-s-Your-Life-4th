package day_0725;

public class Review03 {
	
	int i = 100;
	static int j = 200;
	final static int k = 300; // 상수 - 상수는 대문자로만 표기
	{//초기화 블록
		
	}
	static {//static 초기화 블록
		
	}
	
	public Review03(){
		this.i = 300;
	}
	
	public static void main(String[] args) {
		//System.out.println(i); //static선언이 안되어있기때문에 i 존재 X , Review03 객체를 먼저 선언해야한다.
		Review03 r = new Review03();
		System.out.println(r.i);
		System.out.println(Review03.j);
		System.out.println(Math.PI);
	}
}
