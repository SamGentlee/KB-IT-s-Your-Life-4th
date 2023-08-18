package kb1반_이성준;

import java.util.Scanner;

public class kb1반_알고리즘1번_이성준 {

	static int[] node;
	static int n;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 마을사람수
		int m = sc.nextInt(); // 관계수

		node = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			node[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int id1 = sc.nextInt();
			int id2 = sc.nextInt();

			if (!isUnion(id1, id2)) {
				union(id1, id2);
			}
		}
		int count=0;
		for(int i=2;i<n+1;i++) {
			if(node[i]==1){
				count++;
			}
		}
		System.out.println(count);
	}
	public static int find(int a) {
		if (a == node[a]) {
			return a;
		}
		return node[a] = find(node[a]);
	}

	private static boolean isUnion(int id1, int id2) {
		id1 = find(id1);
		id2 = find(id2);
		if (id1 == id2)
			return true;
		return false;
	}

	public static void union(int id1, int id2) {
		id1 = find(id1);
		id2 = find(id2);
		if (id1 == id2)
			return;
		else if (id1 > id2)
			node[id1] = id2;
		else if (id1 < id2)
			node[id2] = id1;
	}
}
