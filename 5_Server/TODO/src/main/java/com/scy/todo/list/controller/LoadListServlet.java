package com.scy.todo.list.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.scy.todo.list.model.service.TodoService;
import com.scy.todo.list.model.vo.Todo;
import com.scy.todo.member.model.vo.Member;

@WebServlet("/list/load")
public class LoadListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodoService service = new TodoService();
		HttpSession session = req.getSession();
		
		int loginMemberNo = ((Member) session.getAttribute("loginMember")).getMemberNo();
		String option = req.getParameter("option");
		
		try {
			List<Todo> todoList = service.loadList(option, loginMemberNo);
			
			new Gson().toJson(todoList, resp.getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
