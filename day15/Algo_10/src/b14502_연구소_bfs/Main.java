package b14502_연구소_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 
 * 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 
직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 
벽은 칸 하나를 가득 차지한다. 
일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 
새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.

출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.

예제 입력 1 
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
예제 출력 1 
27
 *  */

/**N제한이 8이라는 매우 작은 수 
3개의 벽을 세우는 모든 경우의 수를 만드는 DFS
벽을 만들고 바이러스를 퍼트리는 과정의 BFS -> 인접한 다른 정점으로 갈때 가중치가 1 
 
*주의!! = 원본 배열을 바꾸면 안되기 때문에 복사된 배열을 사용해야 하는데  a = b 와 같은 대입연산자를 사용하면 얕은 복사가 생겨 원본 배열 값에 영향을 미치기 때문에 깊은복사를 해야한다.

문제를에 벽의개수는 3개이고 3개를 모두 사용해야 한다는 조건이 있다.
1. 연구소 모든 칸에 벽을 세우려면 빈칸인지 확인을 하고 벽을 세워야 하기 때문에 dfs 방식으로 해결 할 수 있다.
2. 바이러스는 상하좌우 인접한 방향으로 퍼지고 각 1*1정사각형으로 나누어져 있어 가중치가 1이기 떄문에 BFS를 사용하여 바이러스를 퍼트릴 수 있다.
3. 바이러스를 퍼트려 얻을 수 있는 안전 영역의 최대 크기값을 계속 구한다.
4. 안전 영역의 최대 크기를 출력한다.
아래 코드 주석에 설명을 보면 쉽게 이해가 갈 것이다.
*/

public class Main {
	static final int dx[] = {0,0,1,-1};  //상하좌우 방향 설정
    static final int dy[] = {1,-1,0,0};  //상화좌우 방향 설정
    static int originalMap[][];
    static int n,m;
    static int maxSafeZone = Integer.MIN_VALUE; //최대값을 찾기 위한 최소값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    static void dfs(int wallCnt) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(wallCnt+1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(originalMap[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int copyMap[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        //BFS 탐색 시작
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x; // 현재 값
            int y = now.y; //

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                //연구소 범위 밖이 아니고 빈칸일 경우에만 바이러스를 퍼트린다.
                if(0<=nx && nx<n && 0<=ny && ny<m) {
                    if(copyMap[nx][ny] == 0) {
                        q.add(new Node(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        //SafeZone 확인
        funcSafeZone(copyMap);
    }

    private static void funcSafeZone(int[][] copyMap) {
        int safeZone =0;
        for(int i=0; i<n ; i++) {
            for(int j=0; j<m; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    //Queue에 좌표값 x,y를 넣기 위함.
    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
