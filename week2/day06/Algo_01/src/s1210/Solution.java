package s1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int[][] arr = new int[100][100];
		ArrayList<Integer> start = new ArrayList<>();
		int last = 0;
		int left =0;
		int right=0;
		for(int i=0;i<arr.length;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[99][j]==1) start.add(j);
				else if(arr[99][j]==2) last = j;
			}
		}
		for(int i = 99 ; i >=0 ; i--) {
			if(arr[i][last-1]==1) {
				left=i;
				break;
			}else if(arr[i][last+1]==1) {
				right=i;
				break;
			}
		}
		System.out.println(right);
		System.out.println(left);
	}
}
