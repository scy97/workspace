package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/secession")
public class MyPageSecessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myPage-secession.jsp";

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String memberPw = req.getParameter("memberPw");
			int result = 0;

			HttpSession session = req.getSession();

			Member loginMember = (Member) session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			MemberService service = new MemberService();

			String checkPw = service.checkPw(memberNo);
			
			if(checkPw.equals(memberPw)) {
				result = service.secession(memberNo);
			} else {
				session.setAttribute("message", "비밀번호가 틀립니다.");
				resp.sendRedirect("secession");
			}
			
			if(result > 0) {
				session.setAttribute("message", "회원 탈퇴되었습니다.");
				resp.sendRedirect(req.getContextPath());
				session.invalidate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}