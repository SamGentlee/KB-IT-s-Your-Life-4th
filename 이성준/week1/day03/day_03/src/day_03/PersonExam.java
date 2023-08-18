package day_03;

public class PersonExam {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.printInfo();
		
		Person p2 = new Person("박길동", 40);
		//System.out.println(p2.name); // private이므로 접근 불가능		
		System.out.println(p2.getAge());
		p2.printInfo();
		
		Person p3 = new Person(34,"최길동");
		p3.printInfo();
		
	}
}
