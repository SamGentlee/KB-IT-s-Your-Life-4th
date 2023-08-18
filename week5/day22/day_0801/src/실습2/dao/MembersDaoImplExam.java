package 실습2.dao;

import java.sql.SQLException;

import 실습2.dto.MemberDto;
import 실습2.exception.DuplicatedIdException;
import 실습2.exception.RecordNotFoundException;

public class MembersDaoImplExam {
	public static void main(String[] args) {
		MembersDao membersDao = new MembersDaoImpl();
		//insert
		try {
			membersDao.add(new MemberDto("user07", "유저7", "777", "Y"));
		} catch (SQLException e) {
			System.out.println("DBMS 오류 발생");
		} catch (DuplicatedIdException e) {
			System.out.println("ID가 중복됩니다");
		}
		//update
		try {
			membersDao.update(new MemberDto("user07", "user7", "7777", "N"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBMS 오류 발생");
		} catch (RecordNotFoundException e) {
			System.out.println("ID가 중복됩니다");
		}
		//delete
		try {
			membersDao.delete(new MemberDto("user07", "user7", "7777", "N"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBMS 오류 발생");
		} catch (RecordNotFoundException e) {
			System.out.println("해당 데이터가 없습니다.");
		}
	}
}
