package day_04;

public class MyMemberExam {

	public static void main(String[] args) {
		// 회원정보 관리 - 4가지 기본구성(등록, 검색, 수정, 삭제 : CRUD)
		// 회원 : 이름, 나이
		// Ctrl + . : 컴파일 오류로 바로 이동
		MyMember[] mems = new MyMember[4];
		int count = 0; // 객체 저장할 위치 인덱스 -> 동시에 저장 개수 의미
		mems[count++] = new MyMember("홍길동", 33);
		mems[count++] = new MyMember("김길동", 35);
		mems[count++] = new MyMember("박길동", 30);
		mems[count++] = new MyMember("최길동", 29);
		System.out.println("count=" + count);
		// 목록 출력
		for (int i = 0; i < count; i++) {
			System.out.println(mems[i]);
		}
		// 회원 검색
		String findName = "김길동";
		System.out.println("*** 회원검색 ***");
		int targetIndex = -1; // 찾은 회원의 위치번호.
		for (int i = 0; i < count; i++) {
			if (findName == mems[i].getName()) {
				targetIndex = i;
			}
		}
		if (targetIndex == -1) {
			System.out.println("못찾았음");
		} else {
			System.out.println("찾았음 : " + mems[targetIndex]);
		}

		// 수정 - 김길동의 나이를 1 증가
		findName = "김길동";
		System.out.println("*** 회원수정 ***");
		targetIndex = -1; // 찾은 회원의 위치번호.
		for (int i = 0; i < count; i++) {
			if (findName == mems[i].getName()) {
				targetIndex = i;
			}
		}
		if (targetIndex == -1) {
			System.out.println("못찾았음");
		} else {
			System.out.println("찾았음 : " + mems[targetIndex]);
			int age = mems[targetIndex].getAge();
			mems[targetIndex].setAge(age + 1);
			System.out.println("수정 후 : " + mems[targetIndex]);
		}
		// 삭제
		findName = "김길동";
		System.out.println("** 회원삭제 **");
		targetIndex = -1;// 찾은회원의 위치번호.
		for (int i = 0; i < count; i++) {
			if (findName == mems[i].getName()) {
				targetIndex = i;
			}
		}
		if (targetIndex == -1) {
			System.out.println("못찾았음");
		} else {
			mems[targetIndex] = mems[targetIndex + 1];
			count--;
		}
		// 삭제 후 목록출력
		System.out.println("** 목록 ***");
		for (int i = 0; i < count; i++) {
			System.out.println(mems[i]);
		}
	}

}
