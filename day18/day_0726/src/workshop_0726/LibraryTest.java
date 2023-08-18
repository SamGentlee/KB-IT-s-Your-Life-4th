package workshop_0726;

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
import workshop_0726.service.LibraryService;

public class LibraryTest {

	public static void main(String[] args) {
		LibraryService libSvc = new LibraryService();
		//회원등록
		try {
			libSvc.add(new Member("user01","홍","1111","010-111"));
			libSvc.add(new Member("user02","김","2222","010-222"));
			//libSvc.add(new Member("user01","박","3333","010-333"));//예외발생
			System.out.println("회원등록완료");
		} catch (회원아이디중복Exception e) {
			e.printStackTrace();
			System.err.println("회원아이디 중복으로 인한 회원등록 실패");
		}
		//물건등록
		libSvc.add(new Book(100,"자바기본",20000,"한빛출판사",3));
		libSvc.add(new Video(200,"자바강좌",15000,"명랑출판사",3));
		libSvc.add(new CD(300,"자바실습",15000,"자바출판사",3));
		libSvc.add(new Book(100,"자바기본",20000,"한빛출판사",3));//수량증가
		//회원검색
		ArrayList<Member> findArr = libSvc.findMemberByName("홍");
		Member m = libSvc.findMemberById("user01");
		//물건검색
		Item i = libSvc.findItemByTitle("자바기본");
		try {
			//대여  rent(대여물건id, 대여자id, 대여날짜,대여시,분,수량) 
			libSvc.rentItem( i.getManageNum(), m.getId(), "20230726",13,7,1  );
			libSvc.rentItem( i.getManageNum(), m.getId(), "20230725",10,20,1  );
			//반납  return(대여물건id, 대여자id, 반납날짜,반납시,반납분,수량);
			libSvc.returnItem( i.getManageNum(), m.getId(), "20230726",10,20,1);
		} catch (미등록회원idException | 미등록물건Exception | 수량부족Exception e) {
			e.printStackTrace();
		}
		libSvc.printInfo();
	}
}
