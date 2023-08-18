package board.dao;

import java.sql.SQLException;
import java.util.List;

import board.dto.BoardDto;
import board.exception.DuplicatedIdException;
import board.exception.RecordNotFoundException;


public interface BoardDao {
	//등록
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException;
	//수정
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException;
	//삭제
	public void delete(int no) throws SQLException, RecordNotFoundException;
	//개수
	public int count() throws SQLException;
	//목록
	public List<BoardDto> list() throws SQLException;
	//검색
	public BoardDto findByNo(int no) throws SQLException;
}
