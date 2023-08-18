package 실습2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public void delete(MemberDto m) throws SQLException, RecordNotFoundException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE MEMBERS WHERE id=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,m.getId());
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDto> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
