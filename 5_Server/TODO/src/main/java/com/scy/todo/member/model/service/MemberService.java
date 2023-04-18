package com.scy.todo.member.model.service;

import java.sql.Connection;

import static com.scy.todo.common.JDBCTemplate.*;
import com.scy.todo.member.model.dao.MemberDAO;
import com.scy.todo.member.model.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	public Member login(Member member) throws Exception {
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, member);
		
		close(conn);
		
		return loginMember;
	}

	public int signUp(Member mem) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, mem);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int mailDubCheck(String mail) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.mailDubCheck(conn, mail);
		
		close(conn);
		
		return result;
	}

	public int insertCertification(String mail, String cNumber) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateCertification(conn, mail, cNumber);
		
		if (result == 0) {
			result = dao.insertCertification(conn, mail, cNumber);
		}
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkNum(String mail, String checkNum) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.checkNum(conn, mail, checkNum);

		close(conn);
		
		return result;
	}

	public int idDubCheck(String id) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.idDubCheck(conn, id);
		
		close(conn);
		
		return result;
	}

	public int nameDubCheck(String name) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.nameDubCheck(conn, name);
		
		close(conn);
		
		return result;
	}
}
