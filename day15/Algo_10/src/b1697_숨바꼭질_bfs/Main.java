package b1697_숨바꼭질_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n,k,ans;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		arr=new int[100001];
		arr[k]=-1;
		visited=new boolean[100001];
		ans=0;
		if(n!=k) bfs(n);
		System.out.println(ans);
	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start]=true;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int d=0;d<3;d++) {
				int next = 0;
				switch(d) {
					case 0: 
						next=now+1;
						break;
					case 1:
						next=now-1;
						break;
					case 2: 
						next=2*now;
						break;
				}
				if(next >= 0 && next <= 100000) {
					if(arr[next]<0) {
						ans=arr[now]+1;
					}
					if(!visited[next]) {
						que.add(next);
						visited[next]=true;
						arr[next]=arr[now]+1;
					}
				}
			}
		}
	}
}
