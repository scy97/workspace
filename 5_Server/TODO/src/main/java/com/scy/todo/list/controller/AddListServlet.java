package com.scy.todo.list.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scy.todo.list.model.service.TodoService;
import com.scy.todo.member.model.vo.Member;

@WebServlet("/list/add")
public class AddListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodoService service = new TodoService();
		HttpSession session = req.getSession();
		
		String inputText = req.getParameter("inputText");
		int loginMemberNo = ((Member) session.getAttribute("loginMember")).getMemberNo();
		
				
		int result = 0;
		
		try {
			result = service.addList(inputText, loginMemberNo);
			
			if (result == 0) {
				session.setAttribute("message", "리스트 추가실패");
			}
			
			resp.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
