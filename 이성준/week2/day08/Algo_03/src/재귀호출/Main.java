package 재귀호출;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 ");
		int n = sc.nextInt();
		int ans = factorial(n);
		System.out.println(ans);
	}

	private static int factorial(int n) {
		if(n>0) { //종료조건
			return n * factorial(n-1);
		}
		else return 1;
	}

}
