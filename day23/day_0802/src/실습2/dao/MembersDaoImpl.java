package 실습2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import 실습2.dto.MemberDto;
import 실습2.exception.DuplicatedIdException;
import 실습2.exception.RecordNotFoundException;
import 실습2.util.JdbcUtil;

public class MembersDaoImpl implements MembersDao {
	
	@Override
	public void add(MemberDto m) throws SQLException, DuplicatedIdException{
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findById(m.getId())!=null) {
				throw new DuplicatedIdException(m.getId()+"는 이미 사용중입니다.");
			}
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO MEMBERS(id, name, pwd, status)";
			sql += "VALUES(?,?,?,?)";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,m.getId());
			ps.setString(2,m.getName());
			ps.setString(3,m.getPwd());
			ps.setString(4,m.getStatus());
			
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
	public void update(MemberDto m) throws SQLException, RecordNotFoundException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findById(m.getId())==null) {
				throw new RecordNotFoundException("해당 계정이 없습니다.");
			}
			
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE MEMBERS SET name=? , pwd=?, status=?";
			sql += "WHERE id=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,m.getName());
			ps.setString(2,m.getPwd());
			ps.setString(3,m.getStatus());
			ps.setString(4,m.getId());
			
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
	public void delete(String id) throws SQLException, RecordNotFoundException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findById(id)==null) {
				throw new RecordNotFoundException("해당 계정이 없습니다.");
			}
			
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE MEMBERS WHERE id=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,id);
			
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
		//DBMS 연결
		int count = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT COUNT(*) FROM MEMBERS";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			rs.next();//조회결과가 무조건 있기때문에 if 생략 
			count = rs.getInt(1);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			//DBMS 해제
			JdbcUtil.close(ps,con);
		}
		return count;
	}

	@Override
	public List<MemberDto> list() throws SQLException {
		List<MemberDto> result = new ArrayList<>();
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM MEMBERS ORDER BY 1";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			while(rs.next()) { //조회결과가 있다.
				String id = rs.getString(1);
				String name = rs.getString("name");
				String passwd = rs.getString("pwd");
				String status = rs.getString(4);
				MemberDto dto = new MemberDto(id,name,passwd,status);
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
	public MemberDto findById(String id) throws SQLException {
		//DBMS 연결
		MemberDto dto = null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM MEMBERS where id = ?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,id);
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			if(rs.next()) { //조회결과가 있다.
				String name = rs.getString("name");
				String passwd = rs.getString("pwd");
				String status = rs.getString(4);
				dto = new MemberDto(id,name,passwd,status);
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