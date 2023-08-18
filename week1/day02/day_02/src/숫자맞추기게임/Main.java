package 숫자맞추기게임;

import java.util.Scanner;

/**
 * 1. 컴퓨터가 1~100사이 임의의 정수를하나 저장
 * 2. "1~100 사이 숫자를 입력하세요" 출력
 * 3. 사용자 1~100사이 임의의 숫자를 입력
 * 4. 사용자 입력값이 컴퓨터 숫자와 같으면 "정답" 출력
 * 5. 작으면 "올려주세요" 출력
 * 6. 크면 "내려주세요" 출력
 * 7. 사용자가 정답을 맞힐때까지 2. 부터 반복
 * */
public class Main {
	
	public static void main(String[] args) {
		int com = (int)(Math.random()*100+1);
		//System.out.println(com);
		System.out.println("1~100 사이 숫자를 입력하세요");
		Scanner sc=new Scanner(System.in);
		int user = sc.nextInt();
		while(com!=user) {
			if(com>user) System.out.println("올려주세요");
			else if(com<user) System.out.println("내려주세요");
			user=sc.nextInt();
		}
		System.out.println("정답");
	}
	
	
}
