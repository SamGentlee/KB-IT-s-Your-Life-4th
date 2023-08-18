package 실습2.dao;

import java.sql.SQLException;
import java.util.List;

import 실습2.dto.LoginDto;
import 실습2.exception.DuplicatedIdException;
import 실습2.exception.RecordNotFoundException;

public class LoginDaoImplExam {
	public static void main(String[] args) {
		add();
		update();
		delete();
		find();
		count();
		list();
	}

	private static void list() {
		LoginDao loginDao = new LoginDaoImpl();
		List<LoginDto> list;
		try {
			list=loginDao.list();
			System.out.println(" ** 전체 조회 ** ");
			for(LoginDto l : list) {
				System.out.println(l);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} 
		
	}

	private static void count() {
		LoginDao loginDao = new LoginDaoImpl();
		try {
			int count = loginDao.count();
			System.out.println("총 로그인 수 : "+count);
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} 
	}

	private static void find() {
		LoginDao loginDao = new LoginDaoImpl();
		try {
			LoginDto dto = loginDao.findById("user07");
			System.out.println(dto);
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} 
	}

	private static void delete() {
		LoginDao loginDao = new LoginDaoImpl();
		try {
			loginDao.delete("user07");
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("해당 데이터가 없습니다.");
		}
	}

	private static void update() {
		LoginDao loginDao = new LoginDaoImpl();
		try {
			loginDao.update(new LoginDto("user07", "20230801", "0900","20230801","1800"));
			System.out.println("수정 성공");
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("해당 데이터가 없습니다.");
		}
	}

	private static void add() {
		LoginDao loginDao = new LoginDaoImpl();
		try {
			loginDao.add(new LoginDto("user07", "20230801", "0900"));
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
