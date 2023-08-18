package j1856;

import java.util.Scanner;

/**
 * 문제
사각형의 높이 n과 너비 m을 입력받은 후 
사각형 내부에 지그재그 형태로 1부터 n*m번까지 숫자가 차례대로 출력되는 프로그램을 작성하시오. 

< 처리조건 > 

숫자의 진행 순서는 처음에 왼쪽에서 오른쪽으로 너비 m만큼 진행 한 후 방향을 바꾸어서 이를 반복한다. 

입력
사각형의 높이n와 너비m( n과 m의 범위는 100 이하의 정수)을 입력받는다.

출력
위에서 형태의 직사각형을 입력에서 들어온 높이 n과 너비 m에 맞춰서 출력한다. 숫자 사이는 공백으로 구분한다.

 : 줄바꿈,  : 공백
예제
4 5
1 2 3 4 5 
10 9 8 7 6 
11 12 13 14 15 
20 19 18 17 16
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String nm=sc.nextLine();
		int n = Integer.parseInt(nm.split(" ")[0]);
		int m = Integer.parseInt(nm.split(" ")[1]);
		int[][] arr = new int[n][m];
		int cnt = 1;
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				for(int j=0;j<m;j++) {
					arr[i][j]=cnt++;
				}
			}else {
				for(int j=m-1;j>=0;j--) {
					arr[i][j]=cnt++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(j==m-1) System.out.println(arr[i][j]);
				else System.out.print(arr[i][j]+" ");
			}
		}
	}
}
