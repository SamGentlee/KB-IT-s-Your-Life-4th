package 실습2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import 실습2.dto.LoginDto;
import 실습2.dto.MemberDto;
import 실습2.exception.DuplicatedIdException;
import 실습2.exception.RecordNotFoundException;
import 실습2.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public void add(LoginDto l) throws SQLException, DuplicatedIdException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findById(l.getMember_id())!=null) {
				throw new DuplicatedIdException(l.getMember_id()+"는 이미 사용중입니다.");
			}
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO Login(member_id, login_date, login_time,logout_date,logout_time)";
			sql += "VALUES(?,?,?,?,?)";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,l.getMember_id());
			ps.setString(2,l.getLogin_date());
			ps.setString(3,l.getLogin_time());
			ps.setString(4,null);
			ps.setString(5,null);
			
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
	public void update(LoginDto l) throws SQLException, RecordNotFoundException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findById(l.getMember_id())==null) {
				throw new RecordNotFoundException("해당 계정이 없습니다.");
			}
			
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE LOGIN SET login_date=?,login_time=?, logout_date=? , logout_time=? ";
			sql += "WHERE member_id=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,l.getLogin_date());
			ps.setString(2,l.getLogin_time());
			ps.setString(3,l.getLogout_date());
			ps.setString(4,l.getLogout_time());
			ps.setString(5,l.getMember_id());
			
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
	public void delete(String member_id) throws SQLException, RecordNotFoundException {
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//등록여부검사
			if(findById(member_id)==null) {
				throw new RecordNotFoundException("해당 계정이 없습니다.");
			}
			
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE LOGIN WHERE member_id=?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,member_id);
			
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
			String sql = "SELECT COUNT(*) FROM LOGIN";
			
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
	public List<LoginDto> list() throws SQLException {
		List<LoginDto> result = new ArrayList<>();
		//DBMS 연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM LOGIN ORDER BY 1";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			while(rs.next()) { //조회결과가 있다.
				String member_id = rs.getString("member_id");
				String login_date = rs.getString("login_date");
				String login_time = rs.getString("login_time");
				String logout_date = rs.getString("logout_date");
				String logout_time = rs.getString("logout_time");
				LoginDto dto = new LoginDto(member_id,login_date,login_time,logout_date,logout_time);
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
	public LoginDto findById(String member_id) throws SQLException {
		//DBMS 연결
		LoginDto dto = null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM LOGIN where member_id = ?";
			
			// 4. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 5. 데이터 설정
			ps.setString(1,member_id);
			
			// 6. SQL 전송 및 결과 수신
			// 		DML전송 : executeUpdate() : int 반환
			//		SELECT 전송 : executeQuery() : ResultSet 반환	
			ResultSet rs=ps.executeQuery();
			//id가 PK이면 0 개 또는 1 개 행을 반환
			if(rs.next()) { //조회결과가 있다.
				String login_date = rs.getString("login_date");
				String login_time = rs.getString("login_time");
				String logout_date = rs.getString("logout_date");
				String logout_time = rs.getString("logout_time");
				dto = new LoginDto(member_id,login_date,login_time,logout_date,logout_time);
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
