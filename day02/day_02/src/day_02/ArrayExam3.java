package day_02;

import java.util.Iterator;

public class ArrayExam3 {

	public static void main(String[] args) {
		int[] oldArr = {10,20,30};
		int[] newArr = new int[5];
		System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
		System.out.println(newArr[1]);
		for (int i : newArr) {
			System.out.println(i);
		}
	}

}
