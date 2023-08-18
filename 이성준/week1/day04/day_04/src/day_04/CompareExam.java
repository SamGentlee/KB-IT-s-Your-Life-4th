package day_04;

import java.util.Arrays;

public class CompareExam {
	public static void main(String[] args) {
		MyMember[] mems = new MyMember[4];
		int count = 0; // 객체 저장할 위치 인덱스 -> 동시에 저장 개수 의미
		mems[count++] = new MyMember("홍길동", 33);
		mems[count++] = new MyMember("김길동", 35);
		mems[count++] = new MyMember("박길동", 30);
		mems[count++] = new MyMember("최길동", 29);
		Arrays.sort(mems);
		for(int i=0;i<count;i++) {
			System.out.println(mems[i]);
		}
	}
}
