package web0817_mvc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ConnectionPoolExamServlet")
public class ConnectionPoolExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    Context init = new InitialContext(); //context = 현재실행환경정보
		    
		    //java:comp/env까지는 기본 그뒤 /jdbc/oraxe는 지정한 이름
		    //DataSource가 ConnectionPool의 기능을 가지고있다
		    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oraxe");
		    
		    Connection con = ds.getConnection();
		    System.out.println("연결 성공");
		    PreparedStatement pstmt = con.prepareStatement("select * from board");
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		        System.out.println(rs.getInt("no"));
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
