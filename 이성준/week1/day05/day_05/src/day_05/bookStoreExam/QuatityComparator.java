package day_05.bookStoreExam;

import java.util.Comparator;

public class QuatityComparator implements Comparator<SaleDto> {

	@Override
	public int compare(SaleDto o1, SaleDto o2) {
		return o1.getQuatity()-o2.getQuatity();
	}
}
