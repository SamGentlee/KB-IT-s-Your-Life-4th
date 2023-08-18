package day_04;

public class InterfaceExam {
	public static void main(String[] args) {
		// 수영동호회 구성
		// 수영 가능한 사람만 모음
		// 수영하기() 메서드가 있는 객체를 정의
		PersonSwim p1 = new PersonSwim("100","홍길동");
		Swimmable[] sma = new Swimmable[100];
		sma[0] = p1;
		sma[0].swim();
	}
}

interface Swimmable{
	
	public void swim();
	
}
class PersonSwim extends Person implements Swimmable{
	
	public PersonSwim(String id, String name) {
		super(id,name);
	}
	
	@Override
	public void swim() {
		System.out.println("사람.페트병으로 수영");
	}
	
}
