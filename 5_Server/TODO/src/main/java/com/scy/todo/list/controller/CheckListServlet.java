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

import oracle.net.aso.l;

@WebServlet("/list/check")
public class CheckListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodoService service = new TodoService();
		HttpSession session = req.getSession();
		
		int listNo = Integer.parseInt(req.getParameter("listNo"));
		boolean listCheck = Boolean.valueOf(req.getParameter("listCheck"));
		
		try {
			int result = service.CheckList(listNo, listCheck);
			
			if(result == 0) {
				session.setAttribute("message", "문제가 발생했습니다. 잠시 후 다시 시도해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
