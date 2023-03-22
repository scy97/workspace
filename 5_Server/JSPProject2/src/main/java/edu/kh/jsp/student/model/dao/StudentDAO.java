package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.vo.Student;

public class StudentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public StudentDAO() {
		try {
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();

			prop = new Properties();

			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> selectAll(Connection conn) throws Exception {

		// 결과 저장용 변수 선언
		List<Student> stdList = new ArrayList<>();

		try {
			// SQL 작성하기
			String sql = prop.getProperty("selectAll");

			// Statement 객체 생성
			stmt = conn.createStatement();

			// SQL 수행 후 결과() 반환 받기
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String StudentNo = rs.getString("STUDENT_NO");
				String StudentName = rs.getString("STUDENT_NAME");
				String StudentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");

				stdList.add(new Student(StudentNo, StudentName, StudentAddress, departmentName));
			}

		} finally {
			// 사용한 객체 자원 반환
			close(rs);
			close(stmt);
		}
		
		// 결과반환
		return stdList;
	}
	
	public List<Student> search(Connection conn) throws Exception {

		// 결과 저장용 변수 선언
		List<Student> stdList = new ArrayList<>();

		try {
			// SQL 작성하기
			String sql = prop.getProperty("search");

			// Statement 객체 생성
			stmt = conn.createStatement();

			// SQL 수행 후 결과() 반환 받기
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String StudentNo = rs.getString("STUDENT_NO");
				String StudentName = rs.getString("STUDENT_NAME");
				String StudentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");

				stdList.add(new Student(StudentNo, StudentName, StudentAddress, departmentName));
			}

		} finally {
			// 사용한 객체 자원 반환
			close(rs);
			close(stmt);
		}
		
		// 결과반환
		return stdList;
	}

}
