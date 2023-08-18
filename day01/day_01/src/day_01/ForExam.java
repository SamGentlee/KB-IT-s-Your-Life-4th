package day_01;

public class ForExam {
	public static void main(String[] args) {
		// 1~5까지 출력
		for (int i = 1; i < 6; i++) {
			System.out.println(i);
		}

		for (int i = 1, j = 100; i <= 5 && j >= 5; i++, j--) {
			System.out.println(i + ":" + j);
		}
	}
}
