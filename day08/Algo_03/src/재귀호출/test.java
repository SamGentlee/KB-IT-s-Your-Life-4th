package 재귀호출;

public class test {

	static int[] arr;
	static int[] result;
	static int n;
	static boolean[] visited;

	public static void main(String[] args) {
		arr = new int[] { 1, 2, 3 };
		n = 3; // 추출개수
		result = new int[n];
		visited = new boolean[arr.length];
		recur(0);
	}

	private static void recur(int depth) {
		if (depth == n) {
			print();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false) {
				result[depth] = arr[i];
				visited[i] = true;
				recur(depth + 1);
				visited[i] = false;
			}
		}

	}

	private static void print() {
		for (int i : result) {
			System.out.print(i);
		}
		System.out.println();
	}
}
