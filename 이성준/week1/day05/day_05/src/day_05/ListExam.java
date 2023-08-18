package day_05;

import java.util.ArrayList;

public class ListExam {

	public static void main(String[] args) {
		//회원이름관리
		ArrayList<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("김길동");
		names.add("박길동");
		System.out.println(names);
		names.add(1,"박길동");
		System.out.println(names);
		names.remove("박길동"); //중복된 값은 맨 처음 나온 값만 삭제된다
		System.out.println(names);
		String remove = names.remove(2);
		System.out.println(remove);
		
	}

}
