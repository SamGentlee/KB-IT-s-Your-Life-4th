package day_05;

public class StringExam3 {
	
	public static void main(String[] args) {
//		StringBuilder : 고속 문자열 처리객체
		String s="01234556789";
		String s2 ="";
		//실행시간
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			s2 = s2 + s; //계속 새로운 메모리 사용(계속 메모리가 생성된다)
		}
		System.out.println(s2);
		long end = System.currentTimeMillis();
		System.out.println("실행시간 : "+(end-start)+"ms");
		/////////////
		StringBuilder sb = new StringBuilder();
		long start2 = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			sb.append(s);
		}
		sb.toString();
		long end2 = System.currentTimeMillis();
		System.out.println("실행시간(StringBuilder) : "+(end2-start2)+"ms");
		//////////////
		// StringBuilder가 더 효율 좋음
		StringBuffer ssb = new StringBuffer(); //멀티쓰레드환경에서 동기화 코드가 들어가있다 - 작업이 진행중인지 물어보고 기다렸다가 작업을 시작한다
	}
}
