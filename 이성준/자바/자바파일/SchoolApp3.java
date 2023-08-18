package day05;

import java.util.*;

public class SchoolApp3 {

	private Scanner sc = new Scanner(System.in);
	
	private Student[] stuArr=new Student[2];//학생객체를 저장할 배열
	private int count=0;//등록한 학생수를 담을 변수
	//2, 5, 7, 8
	//학생 검색 : 학번으로 검색하기
	//"학번 입력하세요": 1
	// 1번학생의 정보만 출력
	// 없으면 =>"등록되지 않은 번호입니다"
	//학생 삭제: 학번으로 검색해서 있으면 배열에서 삭제 처리
	//			없으면 =>"등록되지 않은 번호입니다"
	//C (Create), R(Read), U(Update), D(Delete)
	public void menu() {
		System.out.println("****학사관리 프로그램 v1.1******");
		System.out.println("** 1. 학생 등록            ***");
		System.out.println("** 2. 교사 등록            ***");
		System.out.println("** 3. 직원 등록            ***");
		System.out.println("** 4. 학생 출력            ***");
		System.out.println("** 5. 교사 출력            ***");
		System.out.println("** 6. 직원 출력            ***");
		System.out.println("** 7. 학생 검색            ***");
		System.out.println("** 8. 학생 삭제            ***");
		System.out.println("** 9. 종    료            ***");
		System.out.println("*****************************");
		System.out.println("메뉴번호를 입력하세요 => ");
		System.out.println("*****************************");
	}
	/**학생객체를 배열에 저장하는 메서드*/
	public void addStudent(Student st) {
		st.inputInfo();//정보 입력받고
		st.printInfo();
		System.out.println("위 정보를 저장할까요? [1. 예  2. 아니오 ]");
		int no=sc.nextInt();
		if(no==1) {
			stuArr[count++]=st;
			System.out.println(count+"명 등록 완료!!");
		}
	}//----------------------------
	/**등록된 모든 학생들의 정보를 출력하는 메서드*/
	public void printStudents() {
		for(int i=0;i<count;i++) {
			stuArr[i].printInfo();
		}
	}//----------------------------

	public static void main(String[] args) {

		SchoolApp3 sa = new SchoolApp3();
		while (true) {
			sa.menu();
			int num = sa.sc.nextInt();
			if(num==9) {
				System.out.println("잘 가세요~~");
				//System.exit(0);
				return;
			}//----------
			
			switch (num) {
			case 1://학생등록
			{
				if(sa.count>=sa.stuArr.length) {
					System.out.println("등록 마감 되었어요!! 등록인원: "+sa.count);
					//return;
					continue;
				}
				Student s1=new Student();
				sa.addStudent(s1);				
			}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				//stuArr에 저장된 객체를 반복문 돌면서 그 정보 출력하기
				//s1.printInfo();
				sa.printStudents();
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("입력오류!! 메뉴에 없는 번호에요");
			}// switch-----
		} // while------
	}// main()-------------

}// class end-----------------------------
