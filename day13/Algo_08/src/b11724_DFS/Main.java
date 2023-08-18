package b11724_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st=new StringTokenizer(br.readLine());
	     
	     n=Integer.parseInt(st.nextToken());
	     m=Integer.parseInt(st.nextToken());
	     
	     list=new ArrayList[n+1];
	     visited=new boolean[n+1];
	     for(int i=1;i<n+1;i++) {
	    	 list[i]=new ArrayList<Integer>();
	     }
	     
	     for(int i=0;i<m;i++) {
	    	 st=new StringTokenizer(br.readLine());
	    	 int front =Integer.parseInt(st.nextToken()); 
	    	 int back =Integer.parseInt(st.nextToken());
	    	 list[front].add(back);
	    	 list[back].add(front);
	     }
	     ans=0;
	     for(int i=1;i<n+1;i++) {
	    	 if(!visited[i]) {
	    		 ans++;
	    		 dfs(i);
	    	 }
	     }
	     System.out.println(ans);
	}

	private static void dfs(int index) {
		if(visited[index]) return;
		visited[index] = true;
		for(int i : list[index]) {
			dfs(i);
		}
		
	}
}
