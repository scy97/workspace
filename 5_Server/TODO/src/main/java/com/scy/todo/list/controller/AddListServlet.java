package com.scy.todo.list.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scy.todo.list.model.service.TodoService;

@WebServlet("/list/add")
public class AddListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputText = req.getParameter("inputText");
		
		System.out.println(inputText);
		
		TodoService service = new TodoService();
				
		int result = 0;
		
		try {
			result = service.addList(inputText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		resp.getWriter().print(result);
	}
}
