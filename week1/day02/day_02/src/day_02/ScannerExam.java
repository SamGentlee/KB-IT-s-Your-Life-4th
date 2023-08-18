package day_02;

import java.util.Scanner;

public class ScannerExam {
	public static void main(String[] args) {
		System.out.println("이름을 입력하세요>>>");
		Scanner sc=new Scanner(System.in);
//		sc.next(); //글자 한개씩 추출
//		sc.nextInt();//숫자 한개씩 추출
//		sc.nextLine(); //한줄씩 추출
		String name = sc.next();
		System.out.println("이름은 "+name);
		System.out.println("태어난 연도를 4자리로 입력하세요(예:1999>>>");
		int year = sc.nextInt();
		System.out.println(year+"년생입니다.");
		int age = 2023 - year;
		System.out.println("나이는 만"+age+"살입니다.");
		
	}
}
