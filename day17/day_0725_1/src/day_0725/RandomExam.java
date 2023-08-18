package day_0725;

import java.util.Random;

public class RandomExam {
	public static void main(String[] args) {
		Random r = new Random();
		int ri = r.nextInt(45)+1;
		System.out.println(ri);
		ri = r.nextInt(45)+1;
		System.out.println(ri);
		ri = r.nextInt(45)+1;
		System.out.println(ri);
	}
}
