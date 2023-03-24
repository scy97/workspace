package edu.kh.ajaxsearchall.member.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.ajaxsearchall.common.JDBCTemplate.*;
import edu.kh.ajaxsearchall.member.model.dao.MemberDAO;
import edu.kh.ajaxsearchall.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	public List<Member> searchAll() throws Exception {
		Connection conn = getConnection();
		
		List<Member> memList = dao.searchAll(conn);
		
		close(conn);
		
		
		return memList;
	}

	public int input(String email, String pw, String name, String phone, String addr) throws Exception {
		Connection conn = getConnection();
		
		int input = dao.input(conn, email, pw, name, phone, addr);
		
		close(conn);
		
		return input;
	}

}
