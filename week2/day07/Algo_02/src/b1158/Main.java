package b1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		int[] arr=new int[n];
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1;i<n+1;i++) {
			que.add(i);
		}
		
		for(int i=0;i<n;i++) {
		}
	}	

}
