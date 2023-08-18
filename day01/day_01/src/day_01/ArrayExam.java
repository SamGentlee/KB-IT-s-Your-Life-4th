package day_01;

public class ArrayExam {
	public static void main(String[] args) {
		int [] arr; //선언
		arr = new int[3]; //대입 - 자동 초기화 : 0 (int의 초기값)
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
