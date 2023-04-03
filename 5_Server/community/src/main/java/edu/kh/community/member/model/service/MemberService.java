package edu.kh.community.member.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.community.common.JDBCTemplate.*;
import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	public Member selectOne(String memberEmail) throws Exception {
		Connection conn = getConnection();

		Member member = dao.selectOne(conn, memberEmail);

		close(conn);

		return member;
	}

	public Member login(Member mem) throws Exception {
		// Connection 얻어오기
		Connection conn = getConnection();

		// DAO 수행
		Member loginMember = dao.login(conn, mem);

		// Connection 반환
		close(conn);

		// 결과 반환
		return loginMember;
	}

	/**
	 * 이메일 중복검사 Service
	 * 
	 * @param memberEmail
	 * @return
	 */
	public int emailDupCheck(String memberEmail) throws Exception {
		Connection conn = getConnection();

		int result = dao.emailDupCheck(conn, memberEmail);

		close(conn);

		return result;
	}

	/**
	 * 인증번호 DB 추가 Service
	 * 
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 */
	public int insertCertification(String inputEmail, String cNumber) throws Exception {
		Connection conn = getConnection();

		// 1) 입력한 이메일과 일치하는 값이 있으면 수정(Update)
		int result = dao.updateCertification(conn, inputEmail, cNumber);

		// 2) 일치하는 이메일이 없는 경우 -> 처음으로 인증번호 발급받음 -> 삽입(Insert)
		if (result == 0) {
			result = dao.insertCertification(conn, inputEmail, cNumber);
		}
		
		// 트랜잭션 제어 (DML 구문)
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		// 커넥션 반환
		close(conn);

		return result;
	}
	
	/** 인증번호 확인 sevice
	 * @param inputEmail
	 * @param cNumber
	 * @return result
	 */
	public int checkNumber(String inputEmail, String cNumber) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkNumber(conn, inputEmail, cNumber);
		
		close(conn);
		
		return result;
	}
	
	/** 닉네임 중복 검사 Service
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNickname) throws Exception{
		
		// DBCP에서 Connection 얻어오기
		Connection conn = getConnection();
		
		// DAO 메서드 수행 후 결과 반환 받기
		int result = dao.nicknameDupCheck(conn, memberNickname);
		
		// Connection 반환
		close(conn);
		
		// 결과 반환
		return result;
	}
	
	public List<Member> searchAll() throws Exception {
		Connection conn = getConnection();
		
		List<Member> memList = dao.searchAll(conn);
		
		close(conn);
		
		
		return memList;
	}

	public int input(String email, String inputPw, String name, String phone, String addr) throws Exception {
		Connection conn = getConnection();
		
		int input = dao.input(conn, email, inputPw, name, phone, addr);
		
		
		if(input > 0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return input;
	}

	/** 프로필 이미지 변경 Service
	 * @param memberNo
	 * @param profileImage
	 * @return
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateProfileImage(conn, memberNo, profileImage);
		
		// 트랜잭션 제어 처리
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	/** 회원가입 Service
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception {

		// 1) 커넥션 얻어오기
		Connection conn = getConnection(); // DBCP 에서 얻어옴
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.signUp(conn, mem);
		
		// 3) 트랜잭션 처리
		// result가 0인 경우 -> DAO return 구문 잘못 작성
		
		if(result > 0)	commit(conn);  
		else			rollback(conn);
		
		// 4) conn 반환(DBCP로 돌려주기)
		close(conn);
		
		// 5) 결과 반환
		return result;
	}

	public int updateInfo(int memberNo, String memberNickname, String memberTel) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateInfo(conn, memberNo, memberNickname, memberTel);
		
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}

	public int changePw(int memberNo, String newPw) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.changePw(conn, memberNo, newPw);
		
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}

	public String checkPw(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		String result = dao.checkPw(conn, memberNo);
		
		return result;
	}

	public int secession(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.secession(conn, memberNo);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}

}
