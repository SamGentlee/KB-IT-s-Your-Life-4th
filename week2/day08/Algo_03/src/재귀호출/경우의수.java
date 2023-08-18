package 재귀호출;

public class 경우의수 {
	
	static int[] arr; //원소 저장 배열
	static int[] result; // 답 저장
	static int n; //추출의 개수
	
	public static void main(String[] args) {
		//주어진 원소를 이용한 생성가능한 모든 경우의 수
		// {1, 2, 3} --> 123, 132, 112, 113... -중복허용
		// {1, 2, 3} --> 123, 132, 213, 231... -중복불가
		// {1, 2} 중복사용가능한 경우의 수 : 11, 12, 21, 22
		// {1, 2} 중복사용불가능한 경우의 수 : 12, 21
		arr = new int[]{1, 2, 3}; //원소 저장 배열
		n = 3; //추출하는 개수
		result = new int[n]; // 답 저장
		recur(0);
	}
	// recursive - 재귀호출
	private static void recur(int depth) {
		if( depth == n) {
			print(); //종료조건
			return;
		}
		//처리코드(깊이의 숫자 위치에 i값을 지정
		for(int i = 0; i < arr.length; i++) {
			result[depth] = arr[i];
			recur(depth+1);
		}
	}

	private static void print() {
		for (int i : result) {
			System.out.print(i); //가로로 붙여서 출력
		}
		System.out.println(); 
	}
}
