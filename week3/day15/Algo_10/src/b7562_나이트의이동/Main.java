package b7562_나이트의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int l;
	static int[][] pan;
	static boolean[][] visited;
	static int[] dx=new int[] { 1,  2, 2, 1, -1, -2, -2,-1};
	static int[] dy=new int[] {-2, -1, 1, 2, -2, -1,  1, 2};
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=0;t<tc;t++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int desx = Integer.parseInt(st.nextToken());
			int desy = Integer.parseInt(st.nextToken());
			
			pan=new int[l][l];
			visited = new boolean[l][l];
			ans = 0;
			pan[desx][desy] = -1;
			if(startx == desx && starty == desy) System.out.println(ans);
			else {
				bfs(startx,starty);
				System.out.println(ans);
			}
		}
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		visited[x][y]=true;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int d=0;d<8;d++) {
				int row = now[0]+dx[d]; 
				int col = now[1]+dy[d];
				if(row >= 0 && col >= 0 && row < l && col < l) {
					if(!visited[row][col]) {
						if(pan[row][col]<0) {
							ans=pan[now[0]][now[1]];
							ans++;
							return;
						}
						que.add(new int[] {row,col});
						visited[row][col]=true;
						pan[row][col] = pan[now[0]][now[1]]+1;
					}
				}
			}
		}
	}
	
}
