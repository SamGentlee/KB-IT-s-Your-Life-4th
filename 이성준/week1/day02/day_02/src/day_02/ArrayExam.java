package day_02;

public class ArrayExam {
	public static void main(String args[]) {
		int[] arr; // 선언
		arr = new int[3]; // 대입
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		System.out.println(arr); // [I@3d012ddd
		/*
		 * [ : 배열 I : Integer 3d012ddd : 참조값
		 */

		// 변수 선언시 배열 대입
		int[] arr2 = { 100, 200, 300 }; // 선언과 대입 한번에 1
		// arr2={100,200,300}; - 오류, 변수초기화시에만 사용할 수 있는 구문
		System.out.println(arr2[2]);
		//
		int[] arr3 = new int[] { 100, 200, 300 }; // 선언과 대입 한번에 2 - Heap영역에 생성되므로 메모리자동관리가 된다.
		arr3 = new int[] { 100, 200, 300 };
		/////////////////////////////////////////
		String s = "Kim"; // <- Literal : 타입을 값으로 표현하는것, Method영역에 생성
		// new String("Kim"); <- Heap영역에 생성
		int i = 50; // 기본데이터타입이므로 Stack영역에 주소가 있는것이 아닌 값 자체가 있다.
		System.out.println(arr3.length);

	}
}
