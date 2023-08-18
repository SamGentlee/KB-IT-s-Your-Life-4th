package b1976_여행계획짜기_유니온파인드;

import java.util.Scanner;

public class Main {
	static int node[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		node=new int[n+1];
		for(int i=1;i<n+1;i++) {
			node[i]=i;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				int a =sc.nextInt();
				if(a == 1) {
					union(i,j);
				}
			}
		}
		int[] plan = new int[m];
		for(int i=0;i<m;i++) {
			plan[i]=sc.nextInt();
		}
		if(check(plan)) {
			System.out.println("YES");
		}else System.out.println("NO");
	}
	
	public static int find(int a) {
		if(a==node[a]) {
			return a;
		}
		return node[a]=find(node[a]);
	}
	
	public static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a==b) return;
		else if(a>b) node[a] = b;
		else if( a<b) node[b]=a;
	}
	
	public static boolean check(int[] plan) {
		for(int i=0;i<plan.length-1;i++) {
			if(node[plan[i]]!=node[plan[i+1]]) return false; 
		}
		return true;
	}
}
