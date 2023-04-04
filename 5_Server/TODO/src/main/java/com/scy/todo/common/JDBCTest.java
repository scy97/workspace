package com.scy.todo.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "community";
			String pw = "1234";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "select member_no from member";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int no = rs.getInt(1);
				System.out.println(no);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
