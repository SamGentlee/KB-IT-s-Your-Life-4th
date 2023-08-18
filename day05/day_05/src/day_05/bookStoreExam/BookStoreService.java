package day_05.bookStoreExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookStoreService {
	
	ArrayList<BookDto> bookList = new ArrayList<BookDto>();
	ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
	ArrayList<SaleDto> saleList = new ArrayList<SaleDto>();
	
	public BookStoreService() {
		bookList.add(new BookDto("123","자바기본",20000));
		bookList.add(new BookDto("456","자바응용",30000));
		bookList.add(new BookDto("789","자바코딩테스트",25000));
		memberList.add(new MemberDto(100,"홍길동","010-1111-1111"));
		memberList.add(new MemberDto(101,"최길동","010-2222-2222"));
		memberList.add(new MemberDto(102,"박길동","010-3333-3333"));
		saleList.add(new SaleDto(100,"123",2));
		saleList.add(new SaleDto(100,"456",5));
		saleList.add(new SaleDto(100,"789",3));
		saleList.add(new SaleDto(101,"789",2));
		saleList.add(new SaleDto(102,"456",1));
		saleList.add(new SaleDto(102,"123",3));
	}

	public MemberDto getMemberDetail(int mno) {
		for(MemberDto m : memberList) {
			if(m.getNo()==mno) {
				return m;
			}
		}
		return null;
	}
	
	/** 특정 회원이 구매한 도서목록 */
	public ArrayList<SaleDto> getSaleList(int mno) {
		ArrayList<SaleDto> result =new ArrayList<SaleDto>();
		for(SaleDto s : saleList) {
			if(mno == s.getMno()) {
				result.add(s);
			}
		}
		return result;
	}

	public ArrayList<SaleDto> getSaleList() {
		return saleList;
	}

	public ArrayList<MemberDto> getMemberList() {
		return memberList;
	}

	public ArrayList<BookDto> getBookList() {
		return bookList;
	}

	public ArrayList<SaleDto> getSaleListSortByQuatity() {
		QuatityComparator qc= new QuatityComparator(); 
		Collections.sort(saleList,qc);
		return saleList;
	}
	
}
