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
		
		close(conn);
		
		return result;
	}
}
