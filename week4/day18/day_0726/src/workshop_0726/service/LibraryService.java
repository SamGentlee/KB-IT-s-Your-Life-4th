package workshop_0726.service;

import java.util.ArrayList;

import workshop_0726.exception.미등록물건Exception;
import workshop_0726.exception.미등록회원idException;
import workshop_0726.exception.수량부족Exception;
import workshop_0726.exception.회원아이디중복Exception;
import workshop_0726.item.Book;
import workshop_0726.item.CD;
import workshop_0726.item.Item;
import workshop_0726.item.Video;
import workshop_0726.member.Member;
import workshop_0726.rent.RentInfo;

public class LibraryService {
	
	private ArrayList<Member> mems = new ArrayList<Member>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Video> videos = new ArrayList<Video>();
	private ArrayList<CD> cds = new ArrayList<CD>();
	private ArrayList<RentInfo> rents = new ArrayList<RentInfo>();
	private int num= 1;
	
	/** 회원등록 - id 중복시 예외 처리 */
	public void add(Member member) throws 회원아이디중복Exception {
		for(Member m : mems) {
			if(m.getId().equals(member.getId())) {
				throw new 회원아이디중복Exception(member.getId()+"id가 이미 존재합니다.");
			}
		}
		mems.add(member);
	}
	
	//회원 이름으로 회원검색
	public ArrayList<Member> findMemberByName(String name){
		ArrayList<Member> mem = new ArrayList<Member>();
		for(Member m : mems) {
			if(m.getName().equals(name)) {
				mem.add(m);
			}
		}
		if(mem.isEmpty()) return null;
		return mem;
	}
	//회원아이디로 회원검색
	public Member findMemberById(String id) {
		for(Member m : mems) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	// 책 등록
	public void add(Book item) {
		for(Book b : books) {
			if(b.getTitle().equals(item.getTitle())) {
				b.setQty(b.getQty()+item.getQty());
				return;
			}
		}
		books.add(item);
	}	
	//비디오 등록
	public void add(Video item) {
		for(Video v : videos) {
			if(v.getTitle().equals(item.getTitle())) {
				v.setQty(v.getQty()+item.getQty());
				return;
			}
		}
		videos.add(item);
	}
	//CD 등록
	public void add(CD item) {
		for(CD c : cds) {
			if(c.getTitle().equals(item.getTitle())) {
				c.setQty(c.getQty()+item.getQty());
				return;
			}
		}
		cds.add(item);
	}
	
	//관리번호로 물품 검색
	public Item findItemByManageNum(int manageNum) {
		for(Book b : books) {
			if(b.getManageNum() == manageNum) {
				return b;
			}
		}
		for(Video v : videos) {
			if(v.getManageNum() == manageNum) {
				return v;
			}
		}
		for(CD c : cds) {
			if(c.getManageNum()==manageNum) {
				return c;
			}
		}
		return null;
	}
	
	//제목으로 물품 검색
	public Item findItemByTitle(String title) {
		for(Book b : books) {
			if(b.getTitle().equals(title)) {
				return b;
			}
		}
		for(Video v : videos) {
			if(v.getTitle().equals(title)) {
				return v;
			}
		}
		for(CD c : cds) {
			if(c.getTitle().equals(title)) {
				return c;
			}
		}
		return null;
	}
	
	//대여(회원 id, 물건관리번호, 수량)
	public void rentItem(int manageNum, String id, String rentDate, int hour, int min , int qty) 
			throws 미등록회원idException, 미등록물건Exception, 수량부족Exception {
		if(findMemberById(id)==null) {
			throw new 미등록회원idException("해당 id를 가진 회원이 없습니다.");
		}
		if(findItemByManageNum(manageNum)==null) {
			throw new 미등록물건Exception("해당 관리번호를 가진 물품이 없습니다.");
		}
		
		Item item = findItemByManageNum(manageNum);
		if(item.getQty()<qty || item.getQty()==0) {
			throw new 수량부족Exception("수량이 부족합니다.");
		}
		item.setQty(item.getQty()-qty);
		
		//대여 날짜 & 시간 구하기
		String rentTime = hour+"시"+min+"분";
		
		//대여번호 날짜이용하여 만들기
		String rentNumMake=rentDate+(num++);
		int rentNum = Integer.parseInt(rentNumMake);
		
		//RentInfo 리스트에 저장
		RentInfo rent = new RentInfo(rentNum,id,manageNum,rentDate,rentTime);
		rents.add(rent);
	}
	
	//반납(회원 id, 물건관리번호, 수량)
	public void returnItem(int manageNum, String id, String returnDate, int hour, int min , int qty) throws 미등록물건Exception, 미등록회원idException {
		if(findMemberById(id)==null) {
			throw new 미등록회원idException("해당 id를 가진 회원이 없습니다.");
		}
		if(findItemByManageNum(manageNum)==null) {
			throw new 미등록물건Exception("해당 관리번호를 가진 물품이 없습니다.");
		}
		Item item = findItemByManageNum(manageNum);
		item.setQty(item.getQty()+qty);
		//반납날짜 구하기
		String returnTime = hour+"시"+min+"분";
		RentInfo rent=null;
		for(RentInfo r : rents) {
			if(r.getId().equals(id) && r.getManageNum()==manageNum && r.getReturnDate()==null && r.getReturnTime()==null) {
				rent = r;
			}
		}
		if(rent != null) {
			rent.setRentDate(returnDate);
			rent.setRentTime(returnTime);
		}
	}
	
	//전체 정보 출력
	public void printInfo() {
		System.out.println(" ****** 전체 정보 출력 ****** ");
		System.out.println(" 회원 수 : "+mems.size());
		System.out.println();
		System.out.println( "-- 회원 목록 --");
		for(int i=1;i<mems.size()+1;i++) {
			System.out.println(i+" : "+mems.get(i-1));
		}
		System.out.println();
		System.out.println( "-- 종류 별 물건수 --");
		System.out.println(" 책 : "+books.size());
		System.out.println(" 비디오 : "+videos.size());
		System.out.println(" CD : "+cds.size());
		System.out.println();		
		System.out.println( " -- 물건 목록 -- ");
		System.out.println(" - 책 - ");
		for(int i=1;i<books.size()+1;i++) {
			System.out.println(i+" : "+books.get(i-1));
		}
		System.out.println(" - 비디오 - ");
		for(int i=1;i<videos.size()+1;i++) {
			System.out.println(i+" : "+videos.get(i-1));
		}
		System.out.println(" - CD - ");
		for(int i=1;i<cds.size()+1;i++) {
			System.out.println(i+" : "+cds.get(i-1));
		}
		
		
		
			
	}
}
