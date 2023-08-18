package kb1반_이성준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb1반_알고리즘3번_이성준 {

	static int n, m;
	static int[] way;
	static int[] res;
	static int size;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		System.out.println(m);
		way = new int[n + 1];
		res = new int[m + 1];
		way[0]=1;
		size=0;
		res[0]=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			way[i]=Integer.parseInt(st.nextToken());
		}
		
		backT(0,0);
		System.out.println(size);
	}

	private static void backT(int depth, int now) {
		if(depth > m || now > n-1) {
			for(int i:res) {
				System.out.print(i);			
			}
			System.out.println();
			return;
		}
		if(!check(depth,now)) {
			for(int i=1;i<=2;i++) {
				switch(i) {
				case 1:
					res[depth]=size+way[now+1];
					backT(depth+1,now+1);
					break;
				case 2:
					res[depth]=(size/2)+way[now+2];
					backT(depth+1,now+2);
					break;
				}
			}
		}else return;
	}

	private static boolean check(int depth, int now) {
		if(depth < m && now <n-1) {
			return false;
		}
		return true;
	}
}
