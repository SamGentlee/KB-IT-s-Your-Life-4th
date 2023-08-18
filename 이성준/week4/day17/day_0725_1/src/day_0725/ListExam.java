package day_0725;

import java.util.ArrayList;

public class ListExam {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("홍");
		arr.add("김");
		arr.add("박");
		System.out.println(arr);
		arr.add(1,"최");
		System.out.println(arr);
		arr.add(1,"강");
		System.out.println(arr);
		System.out.println(arr.get(2));
		arr.remove(0); //홍 삭제
		System.out.println(arr);
		arr.remove("김"); //김 삭제
		System.out.println(arr);
		
	}
}
