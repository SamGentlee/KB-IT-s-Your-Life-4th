package b10986_과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader를 통해 입력장치를 연결한다.
		StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer를 통해 입력받은 결과를 " " 띄어쓰기로 구분한다.
		int n = Integer.parseInt(st.nextToken()); // 처음 입력값
		int m = Integer.parseInt(st.nextToken()); // 두번째 입력값
		int[] a = new int[n+1]; //크기가 n보다 1이 더 큰 int배열을 만든다
		st=new StringTokenizer(bf.readLine());  //세번째 입력값을 StringTokenizer에 저장시킨뒤 띄어쓰기로 구분한다.
		for(int i=1;i<n+1;i++) { //배열에 첫부분을 비어둔 뒤, 세번째 입력값의 합들을 저장한다.
			a[i] += a[i-1]+Integer.parseInt(st.nextToken()); //세번째 입력값을 sum변수에 더한뒤 저장시킨다. 
			//배열에 sum을 저장시킨다. 세번째입력값의 첫번째 값부터 i번째까지의 값을 더한 값을 배열[i]에 저장시킨다.
			//예를 들면 1 3 2 4 라는 입력값이 주어지면 a[]안에 1 4 6 10 의 순서로 저장한다. 
		}
		int cnt=0; //m으로 나누어떨어지는 쌍의 개수를 담을 변수
		int sum=0; //a배열에서 부분구간합을 담을 변수
		for(int i=1;i<a.length;i++) { // a배열의 a[0]이 비어있으므로 a[1]부터시작하는 for반복문
			for(int j=0;j<a.length;j++) { //a배열의 a[0]=0이므로 0부터 시작하는 for반복문
				sum=a[i]-a[j]; //세번째 입력값인 n-1개의 값들을 첫번째값부터 i번째값까지의 합을 a[i]배열에 저장시켰기때문에 구간합을 구하는 공식
				// 예를 들어 - 1 3 2 4 라는 입력값이 주어지면 a배열은 1 4 6 10 의 배열이고 2번째 값과 4번째값의 부분구간합을 구하려면 a[4]-a[2-1]의 공식을 사용하여 9라는 값이 나온다.
				if(sum>=m && sum%m==0) cnt++; //나온 값이 나눌 변수인 m보다 크거나 같은 값일 때, 나머지가 0인 수를 카운트한다.
			}
		}
		System.out.println(cnt);
	}
}
