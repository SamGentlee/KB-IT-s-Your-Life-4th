package j1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int bigger;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(arr[j]>arr[j+1]) {
					bigger = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = bigger; 
				}
			}
			for(int j=0;j<n;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}
}
