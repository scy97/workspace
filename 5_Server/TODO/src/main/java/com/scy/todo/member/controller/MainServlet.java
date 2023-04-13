package com.scy.todo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scy.todo.member.model.vo.Member;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		Member loginMember = (Member) session.getAttribute("loginMember");

		if (loginMember == null) {
			session.setAttribute("message", "로그인이 필요합니다.");
			resp.sendRedirect(req.getContextPath());
		} else {
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}
	}
}
