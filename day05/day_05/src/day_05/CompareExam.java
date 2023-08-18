package day_05;

import java.util.Arrays;


public class CompareExam {

	public static void main(String[] args) {
		MyMember[] mems = new MyMember[4];
		int count = 0; // 객체 저장할 위치 인덱스 -> 동시에 저장 개수 의미
		mems[count++] = new MyMember("홍길동", 33);
		mems[count++] = new MyMember("김길동", 35);
		mems[count++] = new MyMember("박길동", 30);
		mems[count++] = new MyMember("홍길동", 33);
		//배열 정렬(Arrays.sor(배열))
		Arrays.sort(mems, new NameComparator());
		System.out.println("정렬 후");
		for(MyMember mem : mems) {
			System.out.println(mem);
		}
		//
		System.out.println("mems[0] == mems[1] : "+( mems[0] == mems[1])); // 객체 주소값이 달라 false
		System.out.println("mems[0].equals(mems[1]) : "+ (mems[0].equals(mems[1]))); //객체는 값이 같아도 equlas()수정이 없으면 false 
	}
}
