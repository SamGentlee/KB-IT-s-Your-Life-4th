package day_01;

public class Variables_01 {

	public static void main(String[] args) {
		int v; //선언
		v = 20; //대입
		int x = 50; //선언, 대입 동시에
		// 변수명 길이제한 없음
		
		int g = 65; //문자는 유니코드 사용(16bit)
		System.out.println(Integer.toBinaryString(g)); // 바이트코드로 표현 - 1000001
		
		int i2 = 0b101;
		System.out.println(i2);
		
		int i8 = 0107;
		System.out.println(i8);
		
		int i16 = 0x10A;
		System.out.println(i16);
		/*
		 * 2진수 : 0b or 0B 로 시작한다. ex- 0b101(2진수)=5(십진수)
		 * 8진수 : 0으로 시작한다. ex - 0107(8진수) = 71(십진수)
		 * 16진수 : 0x or 0X 로 시작한다. ex - 0x10a;(16진수) = 266(십진수)
		 * */
		
		char c1 = '가';
		char c2 = '나';
		System.out.println(c1<c2);
		System.out.println(c1);
		
		int ci1=c1;
		System.out.println(ci1); //44032 ('가'의 유니코드번호)
		ci1++; //44033
		System.out.println((char)ci1);
		ci1++; //44034
		System.out.println((char)ci1);
		
		//논리타입
		boolean b1 = true;
		boolean b2 = false;
		
		//문자열타입
		String s1 = "abc"; 
		
		//자동 타입 변환
		byte bt1 = 100;
		int it1 = bt1;
		// bt1 = it1; - 에러(int 타입이 byte타입보다 허용범위가 더 크기때문이다.)
		bt1 = (byte)it1; // 강제형변환
		
		// Big Endian - 가중치가 낮은것부터
		// Little Endian - 가중치가 큰것부터
		// MSB(큰 가중치) / LSB(작은가중치)
		
		// 타입명의 첫자가 대문자인것과 기본타입간의 형변환이 불가능하다. 예) String <-> int
		byte bt10 = 10;
		byte bt20 = 20;
		byte b22 = 10 + 20;
		//byte b22 = bt10 + bt20; //에러 int 보다 작은 byte, short타입 변수는 int 타입으로 자동변환되어 연산이 수행된다.
		b22 = (byte)(bt10 + bt20);
		
		
	}

}
