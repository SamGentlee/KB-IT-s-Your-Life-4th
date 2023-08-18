package day_05;

public class StringExam2 {

	public static void main(String[] args) {
		String s = "홍길동";
		String s2 = "멀티캠퍼스 짱";
		System.out.println(s.length()); //문자열길이
		System.out.println(s.charAt(0)); //문자추출 -> char타입으로
		System.out.println(s2.indexOf("캠퍼스")); //글자 찾기 - 어느 인데스부터 시작되는지 / 없으면 -1 반환
		System.out.println(s.startsWith("홍")); //시작하는 글자 - 맞으면 true 틀리면 false
		System.out.println(s.startsWith("김")); //시작하는 글자 - 맞으면 true 틀리면 false
		System.out.println(s.endsWith("길동")); //끝나는 글자 - true/false (보통 확장자찾을때 사용)
		String s3="10, 20, 30";
		String[] split = s3.split(","); //구분자를 가지고 문자열을 나누어 배열에 저장
		System.out.println(split[1]);
		String s4= "abcd";
		String s5 = s4.toUpperCase(); //대문자로 바꾸기
		System.out.println(s4.toLowerCase()); //소문자로 바꾸기
		System.out.println( s4==s5);
		//String은 불변객체. 한번만들어진 후 내부값 변경 불가
		//문자열 변경 메서드 실행결과는 새로운 문자열을 반환한다.
		
		
	}
}
