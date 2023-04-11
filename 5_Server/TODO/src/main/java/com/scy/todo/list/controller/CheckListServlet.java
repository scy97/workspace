package com.scy.todo.list.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scy.todo.list.model.service.TodoService;import oracle.net.aso.l;

@WebServlet("/list/check")
public class CheckListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int listNo = Integer.parseInt(req.getParameter("listNo"));
		boolean listCheck = Boolean.valueOf(req.getParameter("listCheck"));
		
		try {
			TodoService service = new TodoService();
			
			int result = service.CheckList(listNo, listCheck);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
