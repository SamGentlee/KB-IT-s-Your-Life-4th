package sw5521_bfs_생일파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
    
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<Integer>());
            }
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            cnt = 0;
            Queue<int[]> q = new LinkedList<int[]>();
            visited = new boolean[N+1];
            
            q.add(new int[] {1, 0});
            visited[1] = true;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int node = tmp[0];
                int depth = tmp[1];
                for (int n : graph.get(node)) {
                    if(visited[n] == false) {
                        q.add(new int[] {n, depth+1});
                        visited[n] = true;
                        if (depth < 2)
                            cnt++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);

        }
    }
}
