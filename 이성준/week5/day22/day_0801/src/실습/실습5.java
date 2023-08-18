package 실습;

import java.sql.*;
import java.util.ArrayList;

public class 실습5 {
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
		String sql = "SELECT L.member_id, L.login_date, L.login_time, L.logout_date, L.logout_time ";
				sql+= ", M.name";
				sql+= " FROM LOGIN L JOIN MEMBERS M ";
				sql+= "ON(M.id = L.member_id)";
		
		// 4.Statement 생성
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. 데이터설정
		
		// 6. SQL전송, 결과 수신
		ArrayList<LoginDto> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String member_id = rs.getString(1);
			String login_date = rs.getString(2);
			String login_time = rs.getString(3);
			String logout_date = rs.getString(4);
			String logout_time = rs.getString(5);
			String name = rs.getString(6);
			LoginDto login = new LoginDto(name,member_id,login_date,login_time,logout_date,logout_time);
			list.add(login);
		}
		
		// 7. 자원 반환
		ps.close();
		con.close();
		System.out.println(list);
	}
}
