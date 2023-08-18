package sw1486_장훈이_백트랙킹;
import java.util.Scanner;

/** 장훈이는 서점을 운영하고 있다.

서점에는 높이가 B인 선반이 하나 있는데 장훈이는 키가 매우 크기 때문에, 선반 위의 물건을 자유롭게 사용할 수 있다.

어느 날 장훈이는 자리를 비웠고, 이 서점에 있는 N명의 점원들이 장훈이가 선반 위에 올려놓은 물건을 사용해야 하는 일이 생겼다.

각 점원의 키는 Hi로 나타나는데, 점원들은 탑을 쌓아서 선반 위의 물건을 사용하기로 하였다.

점원들이 쌓는 탑은 점원 1명 이상으로 이루어져 있다.

탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합과 같다.

탑의 높이가 B 이상인 경우 선반 위의 물건을 사용할 수 있는데 탑의 높이가 높을수록 더 위험하므로 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑을 알아내려고 한다.

 

입력

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 두 정수 N, B(1 ≤ N ≤ 20, 1 ≤ B ≤ S)가 공백으로 구분되어 주어진다.

S는 두 번째 줄에서 주어지는 점원들 키의 합이다.

두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며, 각 정수는 각 점원의 키 Hi (1 ≤ Hi ≤ 10,000)을 나타낸다.

출력

각 테스트 케이스마다 첫 번째 줄에는 ‘#t’(t는 테스트 케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 만들 수 있는 높이가 B 이상인 탑 중에서 탑의 높이와 B의 차이가 가장 작은 것을 출력한다.

예시
입력	출력
1
5 16
1 3 3 5 6	#1 1
*/

public class Solution {
    static int[] a;
    static int n;
    static int k;
    static int min;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            a = new int[n];
            k = sc.nextInt();
            min = 0;
            
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                min += a[i];
            }
            min++;
            dfs(0, 0);
            System.out.println("#" + t + " " + (min - k));
        }
    }

    public static void dfs(int idx, int sum) {    
        if(sum >= k) {
            min = Math.min(sum, min);
            return;
        }
        if(idx == n) {
            if(sum >= k)
                min = Math.min(sum, min);
            return;
        }
        dfs(idx+1, sum+a[idx]);
        dfs(idx+1, sum);
    }
}