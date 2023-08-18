package kb1반_이성준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb1반_알고리즘2번_이성준 {

	static int arr[];
	static int res[];
	static int N;
	static int M;
	static boolean visited[];
	static int sum;
	static int max;

	// 조합
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		res = new int[3];
		visited = new boolean[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sum=0;
		max=0;
		recur(0,0);
		System.out.println(max);
	}

	private static void recur(int depth, int start) {
		if(depth == 3) {
			sum();
			if(sum<M) max=Math.max(max, sum);
			sum=0;
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				res[depth]=arr[i];
				visited[i]=true;
				recur(depth+1,start+1);
				visited[i]=false;
			}
		}
	}

	private static void sum() {
		for(int i=0; i<3; i++) {
			sum+=res[i];
		}
	}
}
