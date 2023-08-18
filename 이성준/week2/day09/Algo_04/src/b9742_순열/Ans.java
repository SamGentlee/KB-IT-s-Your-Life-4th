package b9742_순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ans {
	static String[] arr; // 원소
    static String[] result; // 답 저장배열
    static boolean[] visited; // 사용 여부
    static String str;
    static int n; // 몇번째 위치
    static int cnt; // 순서 카운트

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            str = st.nextToken();
            n = Integer.parseInt(st.nextToken());
            arr = new String[str.length()];
            arr = str.split(""); // 문자열을 쪼개서 배열에 넣음
            cnt = 0;

            result = new String[arr.length]; // 정답 저장할 배열
            visited = new boolean[arr.length]; // 방분 여부

            recur(0); // 깊이 0 전달

            if (cnt < n) {
                System.out.println(str + " " + n + " = No permutation");
            }
        }
    }

    private static void recur(int depth) {
        // 종료 조건
        if (depth == arr.length) { // 깊이와 답길이가 동일 답출력
            cnt++;
            if (cnt == n) {
                printResult();
            }
            return;
        }
        // 처리 코드(result에 숫자 누적)
        for (int i = 0; i < arr.length && cnt != n; i++) {
            if (!visited[i]) {
                result[depth] = arr[i]; // 깊이 자리에 i번째 숫자 저장
                visited[i] = true;
                recur(depth + 1); // 깊이 증가 후 재귀호출
                visited[i] = false;
            }
        }
    }

    // 답 출력
    private static void printResult() {
        System.out.print(str + " " + n + " = ");
        for (String i : result) { // result에서 순서대로 추출
            System.out.print(i); // 붙여서 출력
        }
        System.out.println(); // 줄바꿈
    }
}
