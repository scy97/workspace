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

@WebServlet("/member/myPage/changePw")
public class MyPageChangePwServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myPage-changePw.jsp";

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String currentPw = req.getParameter("currentPw");
			String newPw = req.getParameter("newPw");
			String newPwConfirm = req.getParameter("newPwConfirm");
			int result = 0;

			HttpSession session = req.getSession();

			Member loginMember = (Member) session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			MemberService service = new MemberService();

			int checkPw = service.checkPw(memberNo);

			if (newPw == newPwConfirm && checkPw > 0) {
				result = service.changePw(memberNo, newPw);
			} else {

			}

			if (result > 0) {

			} else {

			}
		} catch (Exception e) {

		}
	}
}
