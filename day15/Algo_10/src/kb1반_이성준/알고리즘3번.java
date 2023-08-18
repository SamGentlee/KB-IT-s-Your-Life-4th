package kb1반_이성준;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고리즘3번 {
    static int N, M, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));    //    파일로부터 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        ans = 0;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    public static void dfs(int n, int m, int sum) {
        if (n>N || m==M+1) {
            return;
        }
        ans = Math.max(ans, sum);
        
        if (n<=N-1) {
            dfs(n+1, m+1, sum+arr[n+1]);    //    굴리는 경우
        }
        if (n<=N-2) {
            dfs(n+2, m+1, sum/2+arr[n+2]);    //    던지는 경우
        }
    }
}