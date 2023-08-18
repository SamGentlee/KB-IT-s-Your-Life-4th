package day_04;

public class ExtendsExam {
	public static void main(String[] args) {
		A a1 = new A();
		a1.i = 100;
		
		B b1 = new B();
		b1.i = 200;
		b1.j = 300;
		
		b1.prn();
	}
}
class A{
	int i;
}
class B extends A{
	int j;
	public void prn() {
		this.j=500; //현재클래스에 없으면 부모클래스에서 찾는다
	}
}
