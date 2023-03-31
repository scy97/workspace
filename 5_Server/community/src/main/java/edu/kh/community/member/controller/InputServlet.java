package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/input")
public class InputServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberService();
		try {
			String email = req.getParameter("email");
			String inputPw = req.getParameter("inputPw");
			String name = req.getParameter("nickname");
			String phone = req.getParameter("phone");
			String addr = req.getParameter("addr");
						
			int input = service.input(email, inputPw, name, phone, addr);
			
			new Gson().toJson(input, resp.getWriter());
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
