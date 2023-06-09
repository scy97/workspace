package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.ResultSet;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dao.TestDAO;
import edu.kh.jdbc.model.vo.TestVO;

public class TestService {
	// Service : 비즈니스 로직 (데이터 가공, 트랜잭션 제어) 처리

	private TestDAO dao = new TestDAO();
	
	public ResultSet select(String table_name) throws Exception {
		Connection conn = getConnection();
		
		ResultSet result = dao.select(conn, table_name);
		
//		if(result > 0)
//			commit(conn);
//		else
//			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 1행 삽입 서비스
	 * 
	 * @param vo1
	 * @return
	 */
	public int insert(TestVO vo1, TestVO vo2, TestVO vo3) throws Exception {
		// 커넥션 생성
		Connection conn = getConnection();

		// 결과 반환 받기
		int result1 = dao.insert(conn, vo1); // 1 or 0
		int result2 = dao.insert(conn, vo2); // 1 or 0
		int result3 = dao.insert(conn, vo3); // 1 or 0

		// 트랜잭션 제어
		if (result1 > 0 && result2 > 0 && result3 > 0)
			commit(conn);
		else
			rollback(conn);

		// 커넥션 반환
		close(conn);
		
		
		// 결과 반환
		return result1;
	}
	
	public int update(TestVO vo1, int no) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.update(conn, vo1, no);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}
}
