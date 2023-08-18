package board;

import java.util.List;
import java.util.Scanner;

import board.dto.BoardDto;
import board.exception.BoardException;
import board.exception.RecordNotFoundException;
import board.service.BoardService;
import board.service.BoardServiceImpl;

public class BoardUi {
	
	public static void main(String[] args) {
		new BoardUi().go();
	}

	private void go() {
		init(); // 필요 변수 초기화
	while (true) {
//		list(); // 게시물 목록 출력
		mainMenu(); //메인 메뉴 출력
//		readMenu(); // 
	} 
		
	}
	
	private BoardService brdSvc; //게시판 서비스 객체
	private Scanner sc; //입출력
	private void init() {
		brdSvc = new BoardServiceImpl();
		sc = new Scanner(System.in);
	}

	private void readMenu() {
		
	}

	private void mainMenu() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("메인 메뉴 : (1)등록  |  (2)목록  |  (3)상세  |  (4)종료  |  (5)수정  |  (6)삭제");
		System.out.println("메뉴 선택 : ");
		int menu = Integer.parseInt(sc.nextLine());
		if(menu==1) {
			addBoard();
		}else if(menu==2) {
			list();
		}else if(menu==3) {
			readBoard();
		}else if(menu==4) {
			System.exit(0); //VM종료
		}else if(menu==5) {
			updateBoard(); 
		}else if(menu==6) {
			deleteBoard(); 
		}
	}

	private void deleteBoard() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("*** [게시물 삭제] ***");
		System.out.println("삭제할 게시물 번호를 입력하세요 >>> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			brdSvc.delete(no);
			System.out.println("삭제가 완료되었습니다.");
		} catch (BoardException e) {
			System.out.println("*** 게시물 삭제 오류 ***");
		} catch (RecordNotFoundException e) {
			System.out.println("없는 게시물입니다.");
		}
	}

	private void updateBoard() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("*** [게시물 수정] ***");
		System.out.println("수정할 게시물 번호를 입력하세요 >>> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			BoardDto check = brdSvc.read(no);
			System.out.println("수정 전 제목 : "+check.getTitle());
			System.out.println("수정할 제목을 입력하세요 >>> ");
			String title = sc.nextLine();
			System.out.println("수정 전 내용 : "+check.getContent());
			System.out.println("수정할 내용을 입력하세요 >>> ");
			String content = sc.nextLine();
			BoardDto dto = new BoardDto(no,title,null,null,content);
			brdSvc.update(dto);
			System.out.println("수정이 완료되었습니다.");
			list();
		} catch (BoardException e) {
			System.out.println("*** 게시물 수정 오류 ***");
		} catch (RecordNotFoundException e) {
			System.out.println("없는 게시물입니다.");
		}
		
		
	}

	private void readBoard() {//게시물 상세보기
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("게시물 번호를 입력하세요 >>> ");
		int no = Integer.parseInt(sc.nextLine());
		try {
			BoardDto dto = brdSvc.read(no);
			System.out.println("*** [게시물 상세보기] ***");
			System.out.println(" 번 호	: "+dto.getNo());
			System.out.println(" 제 목	: "+dto.getTitle());
			System.out.println(" 작성자 	: "+dto.getWriter());
			System.out.println(" 작성일 	: "+dto.getRegdate());
			System.out.println(" 내 용	: "+dto.getContent());
		} catch (BoardException e) {
			System.out.println("*** 게시물 상세보기 오류 ***");
		}catch (RecordNotFoundException e) {
			System.out.println("없는 게시물입니다.");
		}
		
		
	}

	private void addBoard() {
		System.out.println("*** [게시물 등록] ***");
		System.out.println("제목을 입력하세요 >>> ");
		String title = sc.nextLine();
		System.out.println("작성자를 입력하세요 >>> ");
		String writer = sc.nextLine();
		System.out.println("내용을 입력하세요 >>> ");
		String content = sc.nextLine();
		BoardDto dto = new BoardDto(0,title,writer,null,content);
		try {
			brdSvc.add(dto);
			list();
		} catch (BoardException e) {
			System.out.println("*** 게시물 등록 오류 ***");
		}
	}

	private void list() {
		try {
			int num = brdSvc.count();
			System.out.println("*** [ 게시물 목록 | 총 게시물수 : "+num+" ] ***");
			System.out.println("-------------------------------------------------------------------------");
			System.out.printf("%-4s%-16s%-10s%-16s%-100s\n","번호","제목","작성자","작성일","내용");
			System.out.println("-------------------------------------------------------------------------");
			
			List<BoardDto> list = brdSvc.list();
			for(BoardDto dto : list) {
				System.out.printf("%-4s%-16s%-10s%-16s%-100s\n",dto.getNo(),dto.getTitle(),dto.getWriter(),dto.getRegdate(),dto.getContent());
			}
		} catch (BoardException e) {
			System.out.println("*** 서버에 오류가 발생했습니다. ***");
		}
	}

}
