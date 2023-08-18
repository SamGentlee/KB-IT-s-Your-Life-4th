package b1260_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int start;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st=new StringTokenizer(br.readLine());
	     
	     n=Integer.parseInt(st.nextToken());
	     m=Integer.parseInt(st.nextToken());
	     start=Integer.parseInt(st.nextToken());
	     
	     list=new ArrayList<ArrayList<Integer>>();
	     
	     for(int i=0;i<n+1;i++) {
	    	 list.add(new ArrayList<Integer>());
	     }
	     
	     for(int i=0;i<n+1;i++) {
	    	 st=new StringTokenizer(br.readLine());
	    	 int front =Integer.parseInt(st.nextToken()); 
	    	 int back =Integer.parseInt(st.nextToken());
	    	 list.get(front).add(back);
	    	 list.get(back).add(front);
	     }
	     
	     visited=new boolean[n+1];
	     dfs(start);
	     System.out.println();
	     visited=new boolean[n+1];
	     bfs(start);
	     
	}

	private static void dfs(int start) {
		System.out.print(start+" ");
		visited[start]=true;
		for(int i : list.get(start)) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start]=true;
		while(!que.isEmpty()) {
			int node = que.poll();
			System.out.print(node+" ");
			for(int i:list.get(node)) {
				if(!visited[node]) {
					que.add(i);
					visited[node]=true;
				}
			}
		}
	}
}
