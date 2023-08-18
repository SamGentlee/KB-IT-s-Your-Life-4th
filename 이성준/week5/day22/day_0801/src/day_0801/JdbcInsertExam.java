package day_0801;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertExam {
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
		String sql = "INSERT INTO MEMBERS(id, name, pwd, status)";
		sql += "VALUES('user04','유저4','444','N')";
		
		// 4. Statement 생성
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. 데이터 설정
		
		// 6. SQL 전송 및 결과 수신
		// 		DML전송 : executeUpdate() : int 반환
		//		SELECT 전송 : executeQuery() : ResultSet 반환	
		int count = ps.executeUpdate();
		System.out.println(count + "행 입력완료");
		
		// 7. 자원반환
		ps.close();
		con.close();
	}
}
