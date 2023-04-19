package com.scy.todo.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberId(rs.getString(2));
				loginMember.setMemberName(rs.getString(3));
				loginMember.setEnrollDate(rs.getString(4));
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}

	public int signUp(Connection conn, Member mem) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("signUp");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberMail());
			pstmt.setString(4, mem.getMemberName());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	public int mailDubCheck(Connection conn, String mail) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("mailDubCheck");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mail);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int updateCertification(Connection conn, String mail, String cNumber) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("updateCertification");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);
			pstmt.setString(2, mail);

			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertCertification(Connection conn, String mail, String cNumber) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("insertCertification");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mail);
			pstmt.setString(2, cNumber);

			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int checkNum(Connection conn, String mail, String checkNum) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("checkNum");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mail);
			pstmt.setString(2, checkNum);
			pstmt.setString(3, mail);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int idDubCheck(Connection conn, String id) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("idDubCheck");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int nameDubCheck(Connection conn, String name) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("nameDubCheck");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
