package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.dto.BoardDto;
import board.exception.DuplicatedIdException;
import board.exception.RecordNotFoundException;
import board.util.JdbcUtil;
import 실습2.dto.MemberDto;


public class BoardDaoImpl implements BoardDao {

	@Override
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO BOARD(no,title,writer,regdate,content)";
			sql += "VALUES(BOARD_SEQ.NEXTVAL,?,?,SYSDATE,?)";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getWriter());
			ps.setString(3,dto.getContent());
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			int count = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
	}

	@Override
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findByNo(dto.getNo())==null) {
				throw new RecordNotFoundException("해당 계정이 없습니다.");
			}
			
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE BOARD SET title=? , regdate = sysdate ,content=?";
			sql += "WHERE no=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getContent());
			ps.setInt(3,dto.getNo());
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			int count = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
	}

	@Override
	public void delete(int no) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findByNo(no)==null) {
				throw new RecordNotFoundException("해당 계정이 없습니다.");
			}
			
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE BOARD WHERE no=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setInt(1,no);
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			int count = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
	}

	@Override
	public int count() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int num = -1;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT COUNT(*) FROM BOARD";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			if(rs.next()) { //조회결과가 있다.
				num = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
		return num;
	}

	@Override
	public List<BoardDto> list() throws SQLException {
		List<BoardDto> result = new ArrayList<>();
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM BOARD ORDER BY 1 DESC";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			while(rs.next()) { //조회결과가 있다.
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				Date regdate = rs.getDate(4);
				String content = rs.getString(5);
				BoardDto dto = new BoardDto(no,title,writer,regdate,content);
				result.add(dto);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
		return result;
	}

	@Override
	public BoardDto findByNo(int no) throws SQLException {
		//DBMS 연결
		BoardDto dto = null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM BOARD where no = ?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setInt(1,no);
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			if(rs.next()) { //조회결과가 있다.
				String title = rs.getString(2);
				String writer = rs.getString(3);
				Date regdate = rs.getDate(4);
				String content = rs.getString(5);
				dto = new BoardDto(no,title,writer,regdate,content);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
		return dto;
	}

}
