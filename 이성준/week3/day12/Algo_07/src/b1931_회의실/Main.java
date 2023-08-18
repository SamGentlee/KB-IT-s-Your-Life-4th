package b1931_회의실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[][] = new int [n][2];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(bf.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[1] == arr2[1]) 
					return arr1[0] - arr2[0];
			return arr1[1] - arr2[1];
			}
		});
		int count = 0;
		int end = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0] >= end) {
				end = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
		
	}
}
