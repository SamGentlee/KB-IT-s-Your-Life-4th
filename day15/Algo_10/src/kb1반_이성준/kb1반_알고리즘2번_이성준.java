package kb1반_이성준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kb1반_알고리즘2번_이성준 {
	
	static int n,m;
	static int arr[][];
	static boolean visited[][];
	static int total; //전체 학생 수
	static int corona; //코로나 걸린 학생 수
	static int day; //마지막으로 코로나 걸린 학생의 퇴소일
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int x,y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		
		arr=new int[n+2][m+2];
		visited=new boolean[n+2][m+2];
		
		total = 0 ;
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=1;j<m+1;j++) {
				arr[i][j]=(int)(str.charAt(j-1)-'0');
				if(arr[i][j]==1) total++;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		y= Integer.parseInt(st.nextToken());
		x= Integer.parseInt(st.nextToken());
		
		corona=1;
		day=3;
		bfs(x,y);
		System.out.println(day);
		System.out.println(total-corona);
	}

	private static void bfs(int x, int y) {
		Queue<Corona> que = new LinkedList<>();
		que.add(new Corona(x,y,day));
		visited[x][y]=true;
		while(!que.isEmpty()) {
			Corona now = que.poll();
			for(int d=0;d<4;d++) {
				int row = now.row+dx[d];
				int col = now.col+dy[d];
				if(col >=1 && row >=1 && col <m+1 && row<n+1) {
					if(arr[row][col] == 1 && !visited[row][col]) {
						que.add(new Corona(row,col,now.depth+1));
						visited[row][col]=true;
						corona++;
					}
				}
			}
			day=now.depth;
		}
	}
	
	static class Corona{
		
		int row;
		int col;
		int depth;
		
		public Corona(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
}
