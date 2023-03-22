package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.service.StudentService;
import edu.kh.jsp.student.model.vo.Student;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentService service = new StudentService();

		try {

			String dname = req.getParameter("departmentName");
			// 학생 전체 조회 서비스 호출 후 결과 반환 받기
			List<Student> stdList = service.search(dname);

			req.setAttribute("stdList", stdList);

			// 요청 위임
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/search.jsp");

			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
