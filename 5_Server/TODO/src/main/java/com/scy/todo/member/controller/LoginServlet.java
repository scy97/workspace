package com.scy.todo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scy.todo.member.model.service.MemberService;
import com.scy.todo.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Member member = new Member();
		
		member.setMemberId(req.getParameter("inputId"));
		member.setMemberPw(req.getParameter("inputPw"));
		
		try {
			MemberService service = new MemberService();
			
			Member loginMember = service.login(member);
			
			HttpSession session = req.getSession();
			if (loginMember != null) {
				session.setAttribute("loginMember", loginMember);
				
				session.setMaxInactiveInterval(3600);
				
			} else {
				session.setAttribute("message", "로그인 실패");
			}
			
			resp.sendRedirect(req.getContextPath() + "/main");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
