package 리뷰;

public class AnonymousExam {
	public static void main(String[] args) {
		//일회용 임시 자식 클래스 만드는법
		A a = new A() {//A를 상속받은 자식 클래스를 정의, 이름없는 클래스
			int j=100;
			@Override
			public void p() {
			System.out.println("B "+j);	
			}
		};
		a.p();
		System.out.println(a.getClass().getName());
		/////////////////////////////////////
		MySwim ms = new MySwim() {

			@Override
			public void swimming() {
				System.out.println("자유형 수영`~~`");
			}
		};
		System.out.println(ms.getClass().getName());
	}
}

class A{
	public void p() {
		System.out.println("A");
	}
}
class B extends A{
	@Override
	public void p() {
		System.out.println("B");
	}
}

interface MySwim{
	void swimming();
}

class MySwimImpl implements MySwim{
	@Override
	public void swimming() {
		// TODO Auto-generated method stub
		
	}
}