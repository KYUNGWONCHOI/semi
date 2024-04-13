package kh.mclass.jdbc.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	// Connection 생성 및 close
	// 트랜잭션 메서드

	private JdbcTemplate() {
	}

	public static Connection getSemiConnection(boolean isLocalHost) {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			String currentPath = JdbcTemplate.class.getResource("./").getPath();
			prop.load(new FileReader(currentPath + "driver.properties"));
			Class.forName(prop.getProperty("jdbc.driver"));

			if(isLocalHost) {
				conn = DriverManager.getConnection(prop.getProperty("jdbc.url")
						, prop.getProperty("jdbc.semi.username")
						, prop.getProperty("jdbc.semi.password"));
			} else {
				conn = DriverManager.getConnection(prop.getProperty("jdbc.semi.dbserver.url")
						, prop.getProperty("jdbc.semi.username")
						, prop.getProperty("jdbc.semi.password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getConnection() {
		Properties prop = new Properties();
		Connection conn = null;
		try {
			String currentPath = JdbcTemplate.class.getResource("").getPath();
			System.out.println(currentPath);
			prop.load(new FileReader(currentPath + "driver.properties"));
//			System.out.println(prop.getProperty("jdbc.url"));
			Class.forName(prop.getProperty("jdbc.driver"));
			conn = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"),
					prop.getProperty("jdbc.password"));
//			if(conn != null) System.out.println("생성성공"); 
//			else if (conn == null) System.out.println("생성실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void autoCommit(Connection conn, boolean autocommit) {
		try {
			if (conn != null)
				conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			if (conn != null)
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null)
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
