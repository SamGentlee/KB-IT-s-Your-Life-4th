package day_0725;

import java.util.HashMap;

public class MapExam {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("홍", 70);
		hm.put("김", 80);
		hm.put("강", 80);
		//Hashmap에 홍길동의 수학점수 90 영어점수 80을 저장하려한다.
		HashMap<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("수학",90);
		scoreMap.put("영어",80);
		HashMap<String, HashMap<String, Integer>> map =new HashMap<>();
		map.put("홍",scoreMap); 
	}

}
