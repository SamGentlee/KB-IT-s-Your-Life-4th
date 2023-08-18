package day_05;

public class StringExam {
	public static void main(String[] args) {
		System.out.println("ab".compareTo("b"));

		// String 비교
		String s1 = "abc"; //메소드 영역에 생성 s2와 같은 주소값 - 기본 상수
		String s2 = "abc"; //메소드 영역에 생성 s1와 같은 주소값 - 기본 상수
		String s3 = new String("abc"); //Heap에 new 로 생성
		String s4 = new String("abc"); //Heap에 new 로 생성
		System.out.println("s1=s2 "+(s1==s2)); //같은 주소
		System.out.println("s3=s4 "+(s3==s4)); //다른 주소
		
		//내부 문자열비교 (값을 비교)
		System.out.println("s3.equals(s4) "+s3.equals(s4)); //true
		System.out.println("s1.equals(s4) "+s1.equals(s4)); //true
	}
}
