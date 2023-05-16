package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.dao.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/*.xml")
public class MemberServiceImplTest {

    MemberDAO test = new MemberDAO();

    @Test
    public void emailDupCheck() throws NoSuchMethodException {

        int result = test.emailDupCheck("test01@naver.com");
        assertEquals(1, result);

    }
}