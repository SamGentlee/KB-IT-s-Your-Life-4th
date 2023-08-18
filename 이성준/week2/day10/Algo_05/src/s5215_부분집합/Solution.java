package s5215_부분집합;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		int res;
		int[] tas;
		int[] cal;
		int n;
		int limit;
		int t;
		StringTokenizer st;
		
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//st=new StringTokenizer(bf.readLine());
		//t=Integer.parseInt(st.nextToken());
		//st=new StringTokenizer(bf.readLine());
		//n=Integer.parseInt(st.nextToken());
		//limit=Integer.parseInt(st.nextToken());
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		n=sc.nextInt();
		limit=sc.nextInt();
		
		tas = new int[n];
		cal = new int[n];
		
		for(int i=0;i<n;i++) {
//			tas[i]=Integer.parseInt(st.nextToken());
			tas[i]=sc.nextInt();
			cal[i]=sc.nextInt();
//			cal[i]=Integer.parseInt(st.nextToken());
		}
		res=0;
		// 0001부터 2^n -1 (1111)까지 .. n자리수
        // 1씩 증가시키면서 모든 부분집합 경우의 수를 구함과 동시에 신맛 쓴맛 값 비교
		for(int i=1;i < 1 << n;i++) { // 최대 n-1칸 / 왼쪽으로 시프트 1을
			int sum=0;
			int max=0;
			for(int j=0;j<n;j++) {
				if((i & 1 << j)>0) {
					sum+=cal[j];
					if(sum<=limit) max+=tas[j]; 
				}
			}
			res=Math.max(res,max);
		}
		
		System.out.println("#"+t+" "+res);
		
		}
	
}
