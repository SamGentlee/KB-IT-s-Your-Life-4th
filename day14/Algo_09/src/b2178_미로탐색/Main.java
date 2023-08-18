package b2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int n,m;
	static int arr[][];
	static boolean visited[][];
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<m;j++) {
				arr[i][j]=(int)(str.charAt(j)-'0');
			}
		}
		
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);
	}

	private static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {y,x});
		visited[x][y]=true;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int k=0;k<4;k++) {
				int row = now[0] + dy[k];
				int col = now[1] + dx[k];
				if(col >=0 && row >=0 && col <m && row<n) {
					if(arr[row][col] != 0 && !visited[row][col]) {
						que.add(new int[]{row,col});
						visited[row][col]=true;
						arr[row][col] = arr[now[0]][now[1]]+1;
					}
				}
			}
		}
	}
	
}
