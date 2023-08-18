package day_03;

public class Person {
	
	// 필드 - 객체 생성 시 객체 영역에 생성
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 기본생성자는 컴파일러가 자동 추가함(Ctrl+space)
	public Person() {
		
	}
	
	//오버로딩(Overloading-Constructor)
	public Person(String name, int age) { //자동 변수 생성 : 커서 올린후 -> Ctrl+1 -> assign new field
		this.name = name;
		this.age = age;
	}

	public Person(int age, String name) {
		this(name,age); //생성자호출은 선언한느 생성자내부에서 반드시 첫번째줄에 선언되야한다.
		System.out.println(" ");
	}
	
	//매개변수 타입과 순서가 같고 이름이 달라도 생성자는 중복정의이기 때문에 오버로딩 오류
//	public Person(int age2, String name2) { 
//		this.age = age2;
//		this.name = name2;
//	}
	
	/** 내부변수값을 출력 */
	public void printInfo() {
		System.out.println("이름 : "+this.name); //this.name이 아닌 바로 name을 적으면 먼저 로컬변수에 맞는 이름을 찾고 없으면 멤버변수에서 찾는다
		System.out.println("나이 : "+this.age);
	}
}