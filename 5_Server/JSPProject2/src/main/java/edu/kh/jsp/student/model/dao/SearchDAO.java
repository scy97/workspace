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

public class SearchDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public SearchDAO() {
		try {
			String filePath = SearchDAO.class.getResource("/edu/kh/jsp/sql/search.xml").getPath();

			prop = new Properties();

			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> search(Connection conn, String dname) throws Exception {

		// 결과 저장용 변수 선언
		List<Student> stdList = new ArrayList<>();

		try {
			String sql = prop.getProperty("search");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String StudentNo = rs.getString("STUDENT_NO");
				String StudentName = rs.getString("STUDENT_NAME");
				String StudentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");

				stdList.add(new Student(StudentNo, StudentName, StudentAddress, departmentName));
			}

		} finally {
			close(rs);
			close(stmt);
			close(pstmt);
		}
		
		return stdList;
	}

}
