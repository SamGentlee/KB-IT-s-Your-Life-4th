package b1414_2주차과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] node;
	static PriorityQueue<Edge> que;
	
	public static void main(String[] args) throws IOException {
		//A=65, Z=90 a=97 z=122 , 0 = 48
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		
		node=new int[n+1];
		for(int i=1;i<n+1;i++) {
			node[i]=i;
		}
		
		que=new PriorityQueue<Edge>();
		int lan=0;
		for(int i=1;i<n+1;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=1;j<n+1;j++) {
				char weight=str.charAt(j-1);
				int length=0;
				if(weight>=65 && weight<=90) {
					length= (int)weight-38;
				}else if(weight>=97 && weight <=122) {
					length = (int)weight-96;
				}else if(weight=='0') {
					length = 0;
				}
				que.add(new Edge(i,j,length));
				lan+=length;
			}
		}
		int need =0;
		while(!que.isEmpty()) {
			Edge now = que.poll();
			if(!isUnion(now.first,now.last)) {
				union(now.first,now.last);
				need+=now.length;
			}
		}
		if(check())	System.out.println(lan-need);
		else System.out.println("-1");
	}
	
	public static boolean check() {
		for(int i=1;i<n;i++) {
			if(node[i]!=node[i+1])
				return false;
		}
		return true;
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
		int first;
		int last;
		int length;
		
		public Edge(int first, int last, int weight) {
			this.first = first;
			this.last = last;
			this.length = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.length, o.length);
		}
	}
}

