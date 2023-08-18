package b2961_부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] sour, bitter; // 원소
	static int n; // 답의 길이
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		sour = new int[n];
		bitter = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i]= Integer.parseInt(st.nextToken());
		}
		min = 1000000000;
	
		for (int i = 1; i < 1 << n; i++) {
			int mul = 1;
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0) {
					mul *= sour[j];
					sum += bitter[j];
				}
			}
			min = Math.min(min, Math.abs(mul - sum));
		}
		System.out.println(min);

	}
}
