package j1002;
import java.util.Arrays;
/**
 * 문제
n개의 정수를 입력받아서 최대공약수와 최소공배수를 구하는 프로그램을 작성하여 보자.

입력
첫째 줄에 N (2≤N≤10) 을 입력 받고 다음 줄에 N개의 정수를 공백으로 구분하여 입력 받는다.

입력 받는 정수는 2이상 10,000 이하이다. 데이터의 크기가 주어진 범위를 벗어나는 입력은 없다.

출력
입력받은 정수들의 최대공약수와 최소공배수를 공백으로 구분하여 출력한다.

최소공배수는 20억 이하의 정수이다.

 : 줄바꿈,  : 공백
예제
3
2 8 10
출력
2 40
 * */
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Scanner sc2=new Scanner(System.in);
        String line = sc2.nextLine();
        String strArr[]=line.split(" ");
        
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++) {
        	arr[i]=Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);
        int a=0; 
        int r=0;
        int b = arr[0];
        for(int i=1;i<arr.length;i++) {
        	a=arr[i];
        	r=a%b;
        	while(r!=0) {
        		r=a%b;
        		a=b;
        		b=r;
        	}
        	b=a;
        }
        System.out.println(a);
	}
}
