package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class signUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String pw = req.getParameter("pw");
		String pwCheck = req.getParameter("pwCheck");
		
		String result = null;
		
		if (pw.equals(pwCheck))
			result = "의 회원가입이 완료되었습니다.";
		else
			result = "의 회원가입이 실패하였습니다.";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
		
		req.setAttribute("r", result);
		
		dispatcher.forward(req, resp);
		
		
	}

}
