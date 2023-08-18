package b1197_최소신장트리;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	

	static int[] node; //부모노드값들의 배열
	static PriorityQueue<Edge> que; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		node=new int[n+1];
		for(int i=1;i<n+1;i++) {
			node[i]=i;
		}
		que=new PriorityQueue<>();
		
		for(int i=0;i<m;i++) {
			int first = sc.nextInt();
			int last = sc.nextInt();
			int weight = sc.nextInt();
			que.add(new Edge(first,last,weight));
		}
		int result = 0;
		while(!que.isEmpty()){
			Edge now = que.poll();
			if(!isUnion(now.first, now.last)) {
				union(now.first,now.last);
				result += now.weight;
			}
		}
		System.out.println(result);
		
	}
	
	public static int find(int a) {
		if(node[a]==a) return a;
		return node[a]=find(node[a]);
	}
	
	public static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a<b) node[b]=a;
		else if(a>b) node[a]=b;
	}
	
	public static boolean isUnion(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) return false;
		return true;
	}
	
	public static class Edge implements Comparable<Edge>{
		
		private int first;
		private int last;
		private int weight;
		
		Edge(int first, int last, int weight){
			this.first=first;
			this.last=last;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight-e.weight;
		}
	}
}
