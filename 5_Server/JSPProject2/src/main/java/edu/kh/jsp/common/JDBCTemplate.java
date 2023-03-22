package edu.kh.jsp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	// DB 연결(Connection 생성), 자동커밋 off
	// 트랜잭션 제어, JDBC 객체 자원반환(close)
	
	// 이러한 JDBC에서 반복 사용되는 코드를 모아둔 클래스
	
	// 모든 필드, 메서드가 static *
	// -> 어디서든지 클래스명.필드명 / 클래스명.메서드명
	// 호출가능 (별도 객체 생성X)
	
	private static Connection conn = null;
	// -> static 메서드에서 필드를 사용하기 위해서는
	// 필드도 static 필드여야한다.
	
	
	/** DB연결 정보를 담고있는 Connection 객체 생성 및 반환 메서드
	 * @return
	 */
	public static Connection getConnection() {
		try {
			if(conn == null || conn.isClosed()) {
				Properties prop = new Properties();
				// Map<String, String> 형태의 객체, XML 입출력 특화
				
				String filePath = 
						JDBCTemplate.class.getResource("/edu/kh/jsp/sql/driver.xml").getPath();
				// driver.xml 파일 읽어오기
				prop.loadFromXML(new FileInputStream(filePath));
				// XML 파일에 작성된 내용이 Properties 객체에 모두 저장됨
				
				// XML에서 읽어온 값을 모두 String 변수에 저장
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				// 커넥션 생성
				Class.forName(driver);
				
				// DriverManager를 이용해 Connection 객체 생성
				conn = DriverManager.getConnection(url, user, password);
				
				// 자동 커밋 비활성화
				conn.setAutoCommit(false);
			}
		} catch (Exception e) {
			System.out.println("[Connection 생성 중 예외 발생]");
			e.printStackTrace();
		}
		
		return conn;
	}
	/** Connection 객체 자원 반환 메서드
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Statement(부모), PreparedStatement(자식) 객체 자원 반환 메서드
	 * @param conn
	 */
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** ResultSet 객체 자원 반환 메서드
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 Commit 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 트랜잭션 Rollback 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}









