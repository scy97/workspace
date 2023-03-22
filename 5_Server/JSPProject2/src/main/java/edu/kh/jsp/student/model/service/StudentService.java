package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplate.*;

import edu.kh.jsp.student.model.dao.SearchDAO;
import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class StudentService {
	
	private StudentDAO dao = new StudentDAO();
	private SearchDAO srch = new SearchDAO();

	public List<Student> selectAll() throws Exception {
		// 커넥션 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Student> stdList = dao.selectAll(conn);
		
		// 커넥션 객체 반환
		close(conn);
		
		return stdList;
	}
	
	public List<Student> search(String dname) throws Exception {
		// 커넥션 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Student> stdList = srch.search(conn, dname);
		
		// 커넥션 객체 반환
		close(conn);
		
		return stdList;
	}
	
}
