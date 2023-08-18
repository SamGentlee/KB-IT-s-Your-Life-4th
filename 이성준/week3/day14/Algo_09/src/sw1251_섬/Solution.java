package sw1251_섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] node;
	static int n;
	static int[][] location;
	static PriorityQueue<Edge> que;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			node=new int[n+1];
			for(int i=1;i<n+1;i++) {
				node[i]=i;
			}
			
			location= new int[n+1][2];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<n+1;i++) {
				location[i][0]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<n+1;i++) {
				location[i][1]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			double e = Double.parseDouble(st.nextToken());
			
			que=new PriorityQueue<Edge>();
			
			for(int i=1;i<n;i++) { //i는 환경부담금을 구하는 첫번째섬의 인덱스
				for(int j=i+1;j<n+1;j++) { //j는 환경부담금을 구하는 두번째섬의 인덱스
					double x = Math.abs(location[i][0]-location[j][0]);
					double y = Math.abs(location[i][1]-location[j][1]);
					double z = ((x*x)+(y*y));
					z=z*e; //환경부담금
					que.add(new Edge(i,j,z));
				}
			}
			double result = 0;
			while(!que.isEmpty()) {
				Edge now = que.poll();
				if(!isUnion(now.first,now.last)) {
					union(now.first,now.last);
					result += now.weight;
				}
			}
			System.out.printf("#%d %.0f\n",t,result);
//			System.out.println("#"+t+" "+Math.round(result));
		}
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
		private double weight;
		
		Edge(int first, int last, double weight){
			this.first=first;
			this.last=last;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge edge) {
			return Double.compare(this.weight, edge.weight); 
		}
	}
}
