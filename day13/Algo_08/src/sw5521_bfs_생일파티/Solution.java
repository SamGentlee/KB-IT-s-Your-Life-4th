package sw5521_bfs_생일파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			list=new ArrayList[n+1];
			for(int i=1;i<n+1;i++) {
				list[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(bf.readLine());
				int front = Integer.parseInt(st.nextToken());
				int back = Integer.parseInt(st.nextToken());
				list[front].add(back); 
				//list[back].add(front); 
			}
			
			ans=0;
			visited=new boolean[n+1];
			bfs(1);
			System.out.println("#"+test+" "+ans);
		}
	}

	private static void bfs(int index) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[]{index,0});
		visited[index] = true;
		while(!que.isEmpty()) {
			int[] a = que.poll();
			int node = a[0];
			int depth = a[1];
			for(int q:list[node]) {
				if(!visited[q]) {
					que.add(new int[] {q,depth+1});
					visited[q]=true;
					if(depth<2)
						ans++;
				}
			}
		}
		
	}

}
