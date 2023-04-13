package com.scy.todo.list.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scy.todo.list.model.service.TodoService;

@WebServlet("/list/remove")
public class RemoveListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoService service = new TodoService();
			
			int listNo = Integer.parseInt(req.getParameter("listNo"));
			
			int result = service.removeList(listNo);
			
			HttpSession session = req.getSession();
			
			if(result == 0) {
				session.setAttribute("message", "문제가 발생했습니다. 잠시 후 다시 시도해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
