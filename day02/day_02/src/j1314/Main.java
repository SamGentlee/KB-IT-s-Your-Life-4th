package j1314;

import java.util.Scanner;

/**
 * 정사각형의 한 변의 길이 n을 입력받은 후 다음과 같은 문자로 된 정사각형 형태로 출력하는 프로그램을 작성하시오.

< 처리조건 > 

문자의 진행 순서는 왼쪽 위에서부터 아래쪽으로 ‘A'부터 차례대로 채워나가고 

다시 오른쪽 아래부터 위쪽으로 채워나가는 방법으로 아래 표와 같이 채워 넣는다.

'Z' 다음에는 다시 'A'부터
 
입력
정사각형 한 변의 길이 n(n의 범위는 1이상 100 이하의 정수)을 입력받는다.

출력
위의 형식과 같이 한변의 길이가 n인 문자 사각형을 출력한다. 문자 사이는 공백으로 구분하여 출력한다.

 : 줄바꿈,  : 공백
예제
4
A H I P
B G J O
C F K N
D E L M
 * */
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a =65;
		char[][] res = new char[n][n];
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				for(int j=0;j<n;j++) {
					if(a==91) {
						a=65;
					}
					res[j][i]=(char)a++;
				}	
			}else {
				for(int j=n-1;j>=0;j--) {
					if(a==91) {
						a=65;
					}
					res[j][i]=(char)a++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==n-1) System.out.println( res[i][j]);
				else System.out.print(res[i][j]+" ");
			}
		}
	}
}
	

