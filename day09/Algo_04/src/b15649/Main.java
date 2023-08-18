package b15649;

import java.util.Scanner;

public class Main {
	
	static int m;
	static int n;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		result = new int[m];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		
		recur(0);
	}

	private static void recur(int depth) {
		if(depth == m) {
			print();
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				result[depth]=arr[i];
				visited[i] = true;
				recur(depth+1);
				visited[i] = false;
			}
			
		}
	}

	private static void print() {
		for(int i:result) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
