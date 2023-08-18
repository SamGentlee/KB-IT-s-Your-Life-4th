package kb1반_이성준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class kb1반_알고리즘3번_이성준 {
	
	  static int[] dx = { 0, 0, -1 };
	  static int[] dy = { -1, 1, 0 };
	  static boolean[][] black;
	  static boolean[][] white;
	  static int cnt;
	  
	public static void main(String[] args) throws IOException{
		int [][] pan = new int[20][20];
		Integer[] arr=new Integer [2];
		black= new boolean[21][21];
		white= new boolean[21][21];
		ArrayList<Integer[]> blist = new ArrayList<>();
		ArrayList<Integer[]> wlist = new ArrayList<>();
		StringTokenizer st;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int nx=0;
		int ny=0;
		for(int i=1;i<20;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<20;j++) {
				int n=Integer.parseInt(st.nextToken());
				if(n==1) {
					black[i][j]=true;
					arr[0]=j;
					arr[1]=i;
					blist.add(arr);
				}
				else if(n==2) {
					white[i][j]=true;
					arr[0]=j;
					arr[1]=i;
					wlist.add(arr);
				}
			}
		}
		cnt=0;
		for(int i=0;i<blist.size();i++) {
			nx=blist.get(i)[0];
			ny=blist.get(i)[1];
			search(nx,ny,1);
		}
	}
	
	private static void down(int nx, int ny,int team) {
		if(team==1) {
			if(!black[ny][nx]) {
				return;
			}
			
		}else {
			
		}
	}
	private static void up(int nx, int ny,int team) {
		
	}
	private static void left(int nx, int ny,int team) {
		
	}
	private static void right(int nx, int ny,int team) {
		
	}
	private static void search(int nx, int ny, int team) {
		
		
	}
}
