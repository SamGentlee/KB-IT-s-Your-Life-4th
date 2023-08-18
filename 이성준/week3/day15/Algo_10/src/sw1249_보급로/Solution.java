package sw1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import sw1249_보급로.Solution.Minimum;

public class Solution {


	static int n,m;
	static int arr[][];
	static boolean visited[][];
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<tc+1;t++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			arr=new int[n][n];
			visited=new boolean[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j=0;j<n;j++) {
					arr[i][j]=(int)(str.charAt(j)-'0');
				}
			}
			
			bfs(0,0);
			
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i,j});
		visited[i][j]=true;
		while(!que.isEmpty()) {
			int[] now=que.poll();
			ArrayList<Minimum> mins=new ArrayList<>();
			for(int d=0;d<4;d++) {
				int row=now[0]+dx[d];
				int col=now[1]+dy[d];
				if(col >=0 && row >=0 && col <m && row<n) {
					if(!visited[row][col]) {
						mins.add(new Minimum(row,col,arr[row][col]));
					}
				}
			}
			Collections.sort(mins);
			que.add(new int[] {mins.get(0).row,mins.get(0).col});
			mins.clear();
			
		}
		
	}
	public static class Minimum implements Comparable<Minimum>{
		int row;
		int col;
		int time;
		
		public Minimum(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}
		
		@Override
		public int compareTo(Minimum o) {
			
			return Integer.compare(this.time, o.time);
		}
		
		
	}
}
