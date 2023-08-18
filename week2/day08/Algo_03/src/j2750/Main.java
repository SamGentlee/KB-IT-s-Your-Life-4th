package j2750;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(); //과자 한개의 가격
		int n = sc.nextInt(); //과자의 개수
		int m = sc.nextInt(); //소지 금액
		if(k*n<m) System.out.println(0);
		else System.out.println(n);
		
	}

}
