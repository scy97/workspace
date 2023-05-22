package edu.kh.comm.member.model.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import edu.kh.comm.member.model.dao.MemberDAO;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/appServlet/servlet-context.xml", "classpath:/spring/root-context.xml" })
@WebAppConfiguration
public class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    @Before
    public void setup() {
        // MemberDAO의 의존성 주입이 이루어진 후에 실행될 코드 작성 (예: 초기 데이터베이스 설정)
    }

    @Test
    public void emailDupCheckTest() {

        // 중복되지 않은 이메일을 입력하여 테스트
        String email = "test@test.com";
        int result1 = memberDAO.emailDupCheck(email);
        assertEquals(result1, 0);

        // 이미 존재하는 이메일을 입력하여 테스트
        String existingEmail = "existing@test.com";
        int result2 = memberDAO.emailDupCheck(existingEmail);
        assertEquals(result2, 1);
    }
}
