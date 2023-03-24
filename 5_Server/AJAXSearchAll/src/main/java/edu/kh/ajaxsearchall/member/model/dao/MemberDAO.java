package edu.kh.ajaxsearchall.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.ajaxsearchall.common.JDBCTemplate.*;
import edu.kh.ajaxsearchall.member.model.vo.Member;

public class MemberDAO {	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/ajaxsearchall/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Member> searchAll(Connection conn) throws Exception {
		List<Member> memList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("searchAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				int MemberNo = rs.getInt("MEMBER_NO");
				String MemberEmail = rs.getString("MEMBER_EMAIL");
				String MemberNickname = rs.getString("MEMBER_NICK");
				
				memList.add(new Member(MemberNo, MemberEmail, MemberNickname));
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return memList;
	}

	public int input(Connection conn, String email, String pw, String name, String phone, String addr) throws Exception {
//		List<Member> input = new ArrayList<>();
		int input = 0;
		
		try {
			String sql = prop.getProperty("input");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, addr);
			
			input = pstmt.executeUpdate();
			commit(conn);
			
		} finally {
			close(pstmt);		
		}
		
		return input;
	}

}
