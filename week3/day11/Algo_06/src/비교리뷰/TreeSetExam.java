package 비교리뷰;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetExam {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(200);
		ts.add(30);
		ts.add(100);
		ArrayList<Integer> arr = new ArrayList<Integer>(ts);
		System.out.println(arr); //TreeSet은 값이 정렬되면서 저장된다
		/////////////////////
		HashSet<Integer> hs =new HashSet<Integer>();
		hs.add(30);
		hs.add(100);
		hs.add(200);
		arr = new ArrayList<Integer>(hs);
		System.out.println(arr);
		
	}
}
