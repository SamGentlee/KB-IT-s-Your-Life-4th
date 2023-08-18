package day_01;

public class WhileExam {
	public static void main(String[] args) {
		// 1~5까지 출력
		int i = 0;
		while (i <= 5) {
			i++;
			if (i == 2) 
				continue;
			if (i == 4)
				break;
			System.out.println(i);
		}
		System.out.println("End");
	}
}
