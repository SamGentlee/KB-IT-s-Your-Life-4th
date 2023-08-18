package 실습2.dao;

import java.sql.SQLException;
import java.util.List;

import 실습2.dto.MemberDto;
import 실습2.exception.DuplicatedIdException;
import 실습2.exception.RecordNotFoundException;

public class MembersDaoImplExam {
	public static void main(String[] args) {
		add();
//		update();
//		delete();
//		find();
//		count();
//		list();
	}

	private static void list() {
		MembersDao membersDao = new MembersDaoImpl();
		List<MemberDto> list;
		try {
			list=membersDao.list();
			System.out.println(" ** 전체 조회 ** ");
			for(MemberDto d : list) {
				System.out.println(d);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} 
		
	}

	private static void count() {
		MembersDao membersDao = new MembersDaoImpl();
		try {
			int count = membersDao.count();
			System.out.println("총 회원 수 : "+count);
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} 
	}

	private static void find() {
		MembersDao membersDao = new MembersDaoImpl();
		try {
			MemberDto dto = membersDao.findById("user07");
			System.out.println(dto);
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} 
	}

	private static void delete() {
		MembersDao membersDao = new MembersDaoImpl();
		try {
			membersDao.delete("user07");
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("해당 데이터가 없습니다.");
		}
	}

	private static void update() {
		MembersDao membersDao = new MembersDaoImpl();
		try {
			membersDao.update(new MemberDto("user07", "user7", "7777", "N"));
			System.out.println("수정 성공");
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("해당 데이터가 없습니다.");
		}
	}

	private static void add() {
		MembersDao membersDao = new MembersDaoImpl();
		try {
			membersDao.add(new MemberDto("user07", "유저7", "777", "Y"));
			System.out.println("등록 성공");
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} catch (DuplicatedIdException e) {
			System.out.println("ID가 중복됩니다");
			e.printStackTrace();
		}
	}
}