package kb1반_이성준;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고리즘2번 {
    static int M, N, cnt;                    //    열, 행, 저글링개수 카운트
    static int[][] arr, v;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));    //    파일로부터 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+2][M+2];            //    외부에 여분공간처리
        v = new int[N+2][M+2];                //    외부에 여분공간처리

        cnt = 0;
        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j+1] = (int)(line.charAt(j)-'0');
                if(arr[i][j+1]==1) cnt++;    //    1인 개수 카운트
            }
        }

        st = new StringTokenizer(br.readLine());
        int SJ = Integer.parseInt(st.nextToken());//코로나 감염학생 좌표
        int SI = Integer.parseInt(st.nextToken());//코로나 감염학생 좌표
        
        int ans = bfs(SI, SJ);
        System.out.println(ans);
        System.out.println(cnt);
    }
    
    public static int bfs(int si, int sj) {
        Queue<Pos> q = new LinkedList<>();

        q.add(new Pos(si,sj));
        v[si][sj] = 3;                        //    시작위치에 3 (3초후 저글링 사망)
        cnt--;

        Pos c = null;
        while (!q.isEmpty()) {
            c = q.poll();
            for (int k=0; k<4; k++) {//4방향 검색
                int ni = c.i + di[k];
                int nj = c.j + dj[k];
                if (v[ni][nj]==0 && arr[ni][nj]>0) {//미방문 & 학생있으면
                    v[ni][nj] = v[c.i][c.j]+1;
                    q.add(new Pos(ni,nj));
                    cnt--;//감영학생발생으로인해 정상학생수 감소
                }
            }
        }
        return v[c.i][c.j];
    }
}
class Pos{
    public int i, j;
    Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}
