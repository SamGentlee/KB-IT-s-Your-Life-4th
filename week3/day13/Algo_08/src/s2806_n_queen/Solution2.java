package s2806_n_queen;

import java.util.Scanner;

public class Solution2 {
    static int answer;
    static int N;
    static int[] col;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	for(int test_case = 1 ; test_case<test+1; test_case++) {
    		N = sc.nextInt();
    		col = new int[N];
    		answer=0;
    		nQueen(0);
    		System.out.println("#"+test_case+" "+answer);
    	}
    }
	private static void nQueen(int row) {
		if(row == N) {
			answer++;
			return;
		}
		for(int i = 0;i < N;i++) {
			col[row] = i;
			if(check(row)) {
				nQueen(row+1);
			}
		}
	}
	private static boolean check(int row) {
		for(int i = 0; i<row ; i++) {
			if(col[row]==col[i] || Math.abs(col[row]-col[i]) == Math.abs(row-i)) {
				return false;
			}
		}
		return true;
	}

}