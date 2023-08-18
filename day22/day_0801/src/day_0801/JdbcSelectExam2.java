package day_0801;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectExam2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. JDBC Driver 메모리로 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Jdbc Driver 로딩 성공");
		
		// 2. DBMS 연결
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "HR";
		String pwd = "HR";
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("DBMS 로그인 성공");
		
		// 3. SQL 작성
		String sql = "SELECT * FROM MEMBERS where id = ?";
		
		// 4. Statement 생성
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. 데이터 설정
		ps.setString(1,"user03");
		
		// 6. SQL 전송 및 결과 수신
		// 		DML전송 : executeUpdate() : int 반환
		//		SELECT 전송 : executeQuery() : ResultSet 반환	
		ResultSet rs=ps.executeQuery();
		//id가 PK이면 0 개 또는 1 개 행을 반환
		String id = null;
		String name = null;
		String passwd = null;
		String status = null;
		if(rs.next()) {
			id = rs.getString(1);
			name = rs.getString("name");
			passwd = rs.getString("pwd");
			status = rs.getString(4);
		}
		
		// 7. 자원반환
		ps.close();
		con.close();
		System.out.println(id);
		System.out.println(name);
		System.out.println(passwd);
		System.out.println(status);
	}
}
