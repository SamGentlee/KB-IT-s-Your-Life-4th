package 그림판;

import 그림판_Service.MyShapeService;

public class PainterServiceExam {
	public static void main(String[] args) {
		//도형을 관리할 객체 생성
		MyShapeService mss = new MyShapeService();
		
		MyShape ml = new MyLine(0, 0, 3, 3);
		mss.add(ml);
		ml = new MyLine(3,3,9,9);
		mss.add(ml);
		ml = new MyLine(6,6,19,19);
		mss.add(ml);
		ml = new MyLine(9,9,29,29);
		mss.add(ml);
		ml = new MyCircle(9,9,9);
		mss.add(ml);
		
		System.out.println("저장갯수 : "+mss.getCount());
		
		//검색. 시작좌표로 검색, 반환타입 -> 인덱스번호, 객체
		MyShape findShape = mss.findByPosition(3,3);
		if(findShape == null) {
			System.out.println("못찾음");
		}else {
			System.out.println("찾음 : "+findShape);
		}
		
		//삭제
		boolean b = mss.remove(findShape);
		//전체출력
		mss.printAll();
	}
}
