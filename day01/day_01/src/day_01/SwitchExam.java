package day_01;

public class SwitchExam {
	public static void main(String[] args) {
		// 가위바위보 컴퓨터 정하기
		double d = Math.random(); // 0 <= r < 1
		d *= 3; // 0.0 ~ 2.99999999999
		int i = (int) d;
		System.out.println(i);

		if (i == 0) {
			System.out.println("가위");
		} else if (i == 1) {
			System.out.println("바위");
		} else {
			System.out.println("보");
		}
		// int lotto에 1~45에 로또번호 저장하는 코드를 작성
		int lotto = (int) (Math.random() * 45 + 1);
		System.out.println(lotto);

		switch (i) {
		case 0:
			System.out.println("가위");
			break;
		case 1:
			System.out.println("바위");
			break;
		case 2:
			System.out.println("보");
			break;
		}
	}
}
