package day_05;

import java.util.Comparator;

/* 이름 기준 정렬*/
public class NameComparator implements Comparator<MyMember>{
	
	@Override
	public int compare(MyMember o1, MyMember o2) {
		//String.compareTo() 메서드를 사용한다. 사전 순서
		return o2.getName().compareTo(o1.getName());
	}


}
