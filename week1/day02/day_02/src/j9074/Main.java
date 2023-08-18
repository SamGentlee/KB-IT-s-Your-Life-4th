package j9074;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * 1부터 10까지의 정수를 입력받다가 입력된 정수가 범위를 벗어나면 그 때까지 1번 이상 입력된 각 숫자의 개수를 작은 수부터 출력하는
 * 프로그램을 작성하시오. <br>
 * 예제 5 6 10 9 3 5 3 5 0 <br>
 * 출력<br>
 * 3 : 2개<br>
 * 5 : 3개<br>
 * 6 : 1개<br>
 * 9 : 1개<br>
 * 10 : 1개<br>
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열나누기 : StringTokenizer
		String line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		int num = st.countTokens(); // 숫자 갯수
		// System.out.println(num);

		int cnt[] = new int[11];
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			// String -> int 변환
			int i = Integer.parseInt(s);
			if (i > 0 && i <= 10) {
				cnt[i]++;
			} else break;
		} // while end
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] != 0) {
				System.out.println(i + " : " + cnt[i] + "개");
			}
		}// for end
	}
}
