package 실습2.dao;

import java.sql.*;
import java.util.List;

import 실습2.dto.MemberDto;
import 실습2.exception.DuplicatedIdException;
import 실습2.exception.RecordNotFoundException;

public interface MembersDao{
	
	//등록
	public void add(MemberDto m) throws SQLException, DuplicatedIdException;
	
	//수정
	public void update(MemberDto m) throws SQLException, RecordNotFoundException;
	
	//삭제
	public void delete(MemberDto m) throws SQLException, RecordNotFoundException;
	
	//갯수
	public int count() throws SQLException;
	
	//목록
	public List<MemberDto> list() throws SQLException;
	
	//검색
	public MemberDto findById(String id) throws SQLException;
	
}
