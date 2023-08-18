package day_03;

public class MyInfo {
	
	private int age; // Encapsulation(캡슐화)
	
	int age2; // 접근제한자 생략(default) : 같은패키지 내 다른 클래스에서 접근 가능
	
	protected int age3; // 다른패키지에 있는 자식 객체는 접근가능
	
	public int age4; //모든 범위
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
