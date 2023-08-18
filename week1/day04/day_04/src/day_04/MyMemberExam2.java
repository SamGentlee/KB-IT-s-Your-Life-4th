package day_04;

public class MyMemberExam2 {
	public static void main(String[] args) {
		MyMemberService ms = new MyMemberService();
		MyMember mm = new MyMember("홍길동", 33);
		ms.add(mm);
		mm = new MyMember("김길동", 35);
		ms.add(mm);
		mm = new MyMember("박길동", 30);
		ms.add(mm);
		System.out.println("저장개수 : "+ms.getCount());
		System.out.println();
		//목록출현
		ms.printAll();
		
		//검색 - 김길동의 참조값 반환 / 순서번호 반환
		/* 검색의 성공/실패 -> 
		 * 1. 성공:양수(인덱스)/실패:-1 
		 * 2. 성공:true/실패:false -> 검색 기능에 부적합
		 * 3. 성공:참조값/실패:null */ 
		MyMember findMem = ms.searchByName("김길동");
		if(findMem == null) {
			System.out.println("못찾았음");
		}else {
			System.out.println("찾았음 : "+findMem);
		}
		
		//수정 - 김길동의 나이를 1 증가
		boolean check = ms.update("김길동",1);
		if(check) 
			System.out.println("수정 완료");
		else 
			System.out.println("수정 실패");
	}
}




