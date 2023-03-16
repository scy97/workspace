package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	public static void main(String[] args) {
		
	}
		/*
		 * DB 연결(Connection 생성),
		 * 자동 커밋 off,
		 * 트랜잭션 제어,
		 * JDBC 객체 자원 반환(close)
		 * 
		 * 이러한 JDBC에서 반복 사용되는 코드를 모아둔 클래스
		 * 
		 * 모든 필드, 메서드 static
		 * -> 어디서든지 클래스명.필드명 / 클래스명.메서드명
		 * 		호출 가능(별도 객체 생성X)
		 */
		
		private static Connection conn = null;
		
		/**	DB 연결 정보를 담고있는 Conenction 객체 생성 및 반환 메서드
		 * @return conn
		 */
		public static Connection getConnection() {
			try {
				// 현재 커넥션 객체가 없을 경우 -> 새 커넥션 객체를 생성
				if(conn == null || conn.isClosed()) {
					// conn.close() : 커넥션이 close 상태면 true 반환
					Properties prop = new Properties();
					
					prop.loadFromXML(new FileInputStream("driver.xml"));
					
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String user = prop.getProperty("user");
					String password = prop.getProperty("password");
					
					Class.forName(driver);
					
					conn = DriverManager.getConnection(url, user, password);
					
					// 개발자가 직접 트랜잭션 제어 할 수 있도록
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
		 * (다형성, 동적 바인딩)
		 * @param stmt
		 */
		public static void close(Statement stmt) {
			try {
				if (stmt != null && !stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/** ResultSet 객체 자원 반환 메서드
		 * @param rs
		 */
		public static void close(ResultSet rs) {
			try {
				if (rs != null && !rs.isClosed()) rs.close();
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
