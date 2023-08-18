package board.service;
/** 게시판 기능을 제공 */

import java.util.List;

import board.dto.BoardDto;
import board.exception.BoardException;
import board.exception.RecordNotFoundException;

public interface BoardService {
	//게시물 목록
	public List<BoardDto> list() throws BoardException; //서버 오류
	//게시물 상세보기
	public BoardDto read(int no) throws BoardException,RecordNotFoundException;
	//게시물 등록
	public boolean add(BoardDto dto) throws BoardException;
	//게시물 수정
	public boolean update(BoardDto dto) throws BoardException,RecordNotFoundException;
	//게시물 삭제
	public boolean delete(int no) throws BoardException,RecordNotFoundException;
	//게시물 개수
	public int count() throws BoardException;
}
