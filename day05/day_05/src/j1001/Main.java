package j1001;

import java.util.Scanner;

/** 
 * 문제 
강아지와 병아리의 합과 다리의 수를 입력받아 강아지와 병아리가 각각 몇 마리씩인지 구하는 프로그램을 작성하시오. 

입력
강아지와 병아리의 합 1,000 이하 다리의 합 4,000 이하의 음이 아닌 정수가 공백으로 구분하여 입력된다.
하나의 결과가 나온 후에도 계속 새로운 입력을 받다가 0 0 이 입력되면 프로그램을 종료한다.

출력
강아지와 병아리가 각각 몇 마리씩인지 공백으로 구분하여 출력한다.
주어진 데이터로 마리수를 정할 수 없을 때는 "0" 을 출력한다.
데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력한다.

예제

입력
25 80
15 10
1500 20000
0 0

출력
15 10
0
INPUT ERROR!
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = " ";
		int sum = 1;
		int leg = 1;
		int dog =0;
		int chick =0;
		while(sum != 0 && leg != 0) {
			input = sc.nextLine();
			sum = Integer.parseInt(input.split(" ")[0]);
			leg = Integer.parseInt(input.split(" ")[1]);
			//if(sum == 0 && leg == 0) break;
			if(sum > 1000 || leg > 4000 || sum < 0 || leg <0 ) {
				System.out.println("INPUT ERROR!");
				continue;
			}else if(sum <= 1000 && leg <= 4000){        
				dog=2*sum-(leg/2);
				chick=sum-dog;
				if(dog > sum || chick > sum || dog < 0 || chick < 0 || chick > leg || dog > leg) {
					System.out.println("0"); 
					continue;
				}
				else {
					System.out.println(chick+" "+dog);
				}
			}
		}
	}
}
