package com.scy.todo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scy.todo.member.model.service.MemberService;

@WebServlet("/member/signUp/idDubCheck")
public class IdDubCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberService();
		
		String id = req.getParameter("id");
		
		try {
			
			int result = service.idDubCheck(id);
			
			resp.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
