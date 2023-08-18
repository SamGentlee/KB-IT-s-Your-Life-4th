package 비교리뷰;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableExam {
	
	static class Person implements Comparable<Person>{
		String name;
		int age;
		
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		@Override
		public int compareTo(Person person) {
			//항상 this.xx - o.xx
			//음수 : this가 선순위, 양수 : this가 후순위, 0: 동일순위
			return this.age - person.age; 
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
		
	}//end Person
	
	static class NameComparator implements Comparator<Person>{

		@Override
		public int compare(Person o1, Person o2) {
			//o1 - o2 기본/ 음수 : o1이 선순위, 양수 : o2가 선순위
			return o1.name.compareTo(o2.name);
		}
		
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("홍",30);
		Person p2 = new Person("김",35);
		System.out.println(p1.compareTo(p2));
		ArrayList<Person> arr = new ArrayList<Person>();
		arr.add(p2);
		arr.add(p1);
		System.out.println(arr);
		Collections.sort(arr);
		System.out.println(arr);
		//이름기준 정렬 - Comparator -> Person 자체적으로 나이기준 정렬법이 정해져있음
		NameComparator nc = new NameComparator();
		Collections.sort(arr,nc);
		System.out.println(arr);
	}
}
