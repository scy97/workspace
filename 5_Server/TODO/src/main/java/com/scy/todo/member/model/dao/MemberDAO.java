package com.scy.todo.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static com.scy.todo.common.JDBCTemplate.*;
import com.scy.todo.member.model.vo.Member;

public class MemberDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/com/scy/todo/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member login(Connection conn, Member member) throws Exception {
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
	
}
