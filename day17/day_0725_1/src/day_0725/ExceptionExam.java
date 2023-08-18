package day_0725;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionExam {

	public static void main(String[] args) {
		try {
			readFile2();
			System.out.println("파일처리성공");
		} catch (FileNotFoundException e) {
			System.err.println("파일 처리 실패");
		}
	}

	private static void readFile2() throws FileNotFoundException {
		//파일에서 문자를 읽기
			FileReader fr = new FileReader("poem.txt");
			System.out.println("파일 열기 성공");
	}
	
	private static void readFile() {
		//파일에서 문자를 읽기
		try {
			FileReader fr = new FileReader("poem.txt");
			System.out.println("파일 열기 성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없음");
			System.err.println("파일 없음");
			e.printStackTrace();
		}
	}
}
