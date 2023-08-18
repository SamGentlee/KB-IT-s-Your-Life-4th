package day_05.bookStoreExam;

import java.util.ArrayList;

public class BookStoreExam {
	
	public static void main(String[] args) {
		BookStoreService bsSvc = new BookStoreService();
		MemberDto m = bsSvc.getMemberDetail(100);
		System.out.println(m);
		
		ArrayList<SaleDto> saleList = bsSvc.getSaleList(100);
		System.out.println(saleList);
		//
		ArrayList<SaleDto> saleList2 = bsSvc.getSaleList();
		ArrayList<MemberDto> memberList = bsSvc.getMemberList();
		ArrayList<BookDto> bookList = bsSvc.getBookList();
		
		ArrayList<SaleDto> saleList3 = bsSvc.getSaleListSortByQuatity();
		System.out.println(saleList3);
	}
}
