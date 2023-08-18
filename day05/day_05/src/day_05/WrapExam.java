package day_05;

import java.util.ArrayList;

public class WrapExam {
	
	public static void main(String[] args) {
		int i = 5;
//		Integer ii = new Integer(i);
		Integer ii = i; //컴파일러가 박싱해준다(오토박싱) - 기본타입자료형을 포장클래스(Wrapper Class)로 자동변화시켜준다
		int j = ii; //언박싱
		
		String ss =ii.toString();
		String ss2 = "200";
		int k = Integer.parseInt(ss2,10); // String 객체를 int 타입으로 바꾸기위해서 Wrapper클래스를 사용한다.
		// Integer.parseInt(String s,int i) = s문자열을 i진수로 바꿔준다
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(i);
	}
}
