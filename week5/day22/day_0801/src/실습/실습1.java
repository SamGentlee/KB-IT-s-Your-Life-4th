package 실습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 실습1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		// 1. JDBC Driver 메모리로 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC 로딩 성공");
		
		// 2. DBMS 연결
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "HR";
		String pwd = "HR";
		con = DriverManager.getConnection(url,user,pwd);
		System.out.println("DBMS 로그인 성공");
		
		// 3. SQL 작성
		String sql = "INSERT INTO LOGIN(member_id,login_date,login_time) ";
		sql += "VALUES(?,?,?)";
		
		// 4.Statement 생성
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. 데이터설정
		ps.setString(1, "user03");
		ps.setString(2, "20230730");
		ps.setString(3, "1010");
		
		// 6. SQL전송, 결과 수신
		int count = ps.executeUpdate();
		
		// 7. 자원 반환
		ps.close();
		con.close();
		System.out.println("로그인 정보 등록 "+count+"건 완료");
	}
}
