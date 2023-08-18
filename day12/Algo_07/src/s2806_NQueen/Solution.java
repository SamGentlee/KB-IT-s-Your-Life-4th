package s2806_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int[] arr;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			count = 0;
			nQueen(0);
			System.out.println("#"+test+" "+count);
		}//for(test)
	}
	
	public static void nQueen(int depth) {
		if(depth == n) { //depth 는 행의 값
			count++;
			return;
		}
		for(int i=0;i<n;i++) {//i는 열의값
			arr[depth] = i;
			
			if(check(depth)) {
				nQueen(depth+1);
			}
		}
	}

	public static boolean check(int depth) {
		for(int i=0;i<depth;i++) {
			if(arr[depth]==arr[i]) {
				return false;
			}//열의값들의 차와 행의값들의 차가 같으면 같은 대각선상에 있다
			else if(Math.abs(arr[depth]-arr[i])==Math.abs(depth - i)){
				return false;
			}
		}
		return true;
	}
}
