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

@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myPage-info.jsp";

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int result = 0;
			String memberNickname = req.getParameter("memberNickname");
			String memberTel = req.getParameter("memberTel");

			HttpSession session = req.getSession();

			Member loginMember = (Member) session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			MemberService service = new MemberService();
			
			System.out.println(memberNickname.length());
			System.out.println(memberTel.length());

			if (memberNickname.length() > 0 && memberTel.length() > 0) {
				result = service.updateInfo(memberNo, memberNickname, memberTel);
			} else if (memberNickname.length() == 0 || memberTel.length() == 0) {
				session.setAttribute("message", "변경할 회원 정보를 입력해주세요.");
			}

			if (result > 0) {
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);

				session.setAttribute("message", "회원 정보가 변경되었습니다.");
			} else {
				session.setAttribute("message", "회원 정보 변경 실패");
			}

			resp.sendRedirect("info");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
