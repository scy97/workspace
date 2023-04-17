package com.scy.todo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scy.todo.member.model.service.MemberService;
import com.scy.todo.member.model.vo.Member;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/signUp.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member mem = new Member();
		
		mem.setMemberId(req.getParameter("inputMail"));
		mem.setMemberPw(req.getParameter("inputId"));
		mem.setMemberMail(req.getParameter("inputPw"));
		mem.setMemberName(req.getParameter("inputName"));
		
		HttpSession session = req.getSession();
		
		try {
			MemberService service = new MemberService();
			
			int result = service.signUp(mem);
			
			if (result == 0) {
				session.setAttribute("message", "회원가입에 실패했습니다. 잠시 후 다시 시도해주세요.");
				resp.sendRedirect(req.getContextPath());
			} else {
				session.setAttribute("message", "회원가입에 성공했습니다.");
				resp.sendRedirect(req.getContextPath());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
