package j1158;

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
		int tmp;
		int j;
		
		for(int i=1;i<n;i++) {
			tmp=arr[i];
			for(j=i;j>0 && arr[j-1] > tmp;j--) {
				arr[j]=arr[j-1];
			}
			arr[j]=tmp;
			for(int k : arr) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		
	}
}
