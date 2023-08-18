package board.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {
	
	public static Connection connect() throws Exception {
		// 1. ConnectionPool 로딩
		Context init = new InitialContext();
	    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oraxe");
	    Connection con = ds.getConnection();
		
		return con;
	}

	public static void close(PreparedStatement ps, Connection con) {
			try {
				if(ps != null) 	ps.close();
			} catch (SQLException e) { }
			try {
				if(con != null)	con.close();
			} catch (SQLException e) {}
	}
	
}
