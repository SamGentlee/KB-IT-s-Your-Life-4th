package b1920_이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		st=new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<m;i++) {
			boolean find = false;
			int key = Integer.parseInt(st.nextToken());
			
			int pl = 0;
			int pr = n-1;
			int pc = (pr+pl)/2;
			while(pl<=pr) {
				if(key < arr[pc]) {
					pr=pc-1;
					pc=(pr+pl)/2;
				}else if(key > arr[pc]){
					pl=pc+1;
					pc=(pr+pl)/2;
				}else {
					find = true;
					break;
				}
			}
			if(find) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		
	}
}
