package b1325_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
		m = Integer.parseInt(st.nextToken()); //컴퓨터신뢰 관계 수
		
		list = new ArrayList[n+1]; //인접리스트
		arr = new int[n+1];
		for(int i=1; i<n+1;i++) { //i는 컴퓨터 번호
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) { //신뢰관계 수
			st = new StringTokenizer(bf.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			list[front].add(back); //list[front]는 front컴퓨터에 대한 신뢰 컴퓨터번호(back)
		}
		
		for(int i=1;i<n+1;i++) {
			visited = new boolean[n+1]; //컴퓨터 번호대로 visited를 판별하여 bfs()실행
			bfs(i);
		}
		int max=0;
		for(int i=1;i<n+1;i++) {
			max = Math.max(max, arr[i]);
		}
		for(int i=1;i<n+1;i++) {
			if(max==arr[i])
				System.out.print(i+" ");
		}
		
	}
	private static void bfs(int com) {
		Queue<Integer> que = new LinkedList<Integer>(); //컴퓨터 번호 com에대한 queue 생성
		que.add(com); //que에 com번 컴퓨터 삽입
		visited[com] = true; //com번 확인여부체크
		
		while(!que.isEmpty()) { 
			int a = que.poll(); //큐에서 처음에있던값을 a에 삽입
			for(int q: list[a]) {  //a번 컴퓨터 리스트(신뢰컴퓨터번호)
				if(!visited[q]) { //a번 확인여부체크
					visited[q]=true; //확인 체크
					arr[q]++; //a번 컴퓨터에 대한 신뢰 컴퓨터의 정답수 +1 
					que.add(q); //a번 컴퓨터에 대한 신뢰 컴퓨터 큐에 삽입
				}
			}
		}
	}
}
