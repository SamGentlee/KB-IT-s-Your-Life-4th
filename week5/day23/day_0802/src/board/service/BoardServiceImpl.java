package board.service;

import java.sql.SQLException;
import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.dto.BoardDto;
import board.exception.BoardException;
import board.exception.DuplicatedIdException;
import board.exception.RecordNotFoundException;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();
	
	//게시물 목록
	@Override
	public List<BoardDto> list() throws BoardException {
		List<BoardDto> list = null;
		try {
			list = boardDao.list();
		} catch (SQLException e) { //dao에서 받은 SQL예외를 board예외로 넘긴다
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		}
		return list;
	}
	//게시물 등록
	@Override
	public boolean add(BoardDto dto) throws BoardException {
		try {
			boardDao.add(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		} catch (DuplicatedIdException e) {
			e.printStackTrace();
		}
		return true;
	}
	//게시물 상세보기
	@Override
	public BoardDto read(int no) throws BoardException,RecordNotFoundException{
		BoardDto dto = null;
		try {
			dto=boardDao.findByNo(no);
			if(dto==null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		} 
		return dto;
	}
	//게시물 수정
	@Override
	public boolean update(BoardDto dto) throws BoardException,RecordNotFoundException {
		try {
			if(dto==null) {
				throw  new RecordNotFoundException();
			}
			boardDao.update(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		} 
		return true;
	}
	//게시물 삭제
	@Override
	public boolean delete(int no) throws BoardException, RecordNotFoundException {
		try {
			BoardDto dto = boardDao.findByNo(no);
			if(dto==null) {
				throw  new RecordNotFoundException();
			}
			boardDao.delete(no);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		}
		return true;
	}
	//게시물 개수
	@Override
	public int count() throws BoardException {
		int num=-1;
		try {
			num = boardDao.count();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException(e.getMessage());
		}
		return num;
	}

}
