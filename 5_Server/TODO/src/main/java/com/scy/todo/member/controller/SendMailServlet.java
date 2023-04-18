package com.scy.todo.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scy.todo.member.model.service.MemberService;

@WebServlet("/member/signUp/sendMail")
public class SendMailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail = req.getParameter("mail");
		
		String subject = "Todo List 회원 가입 이메일확인";
		
		String fromMail = "scy7143@gmail.com";
		String fromUserName = "관리자";
		String toMail = mail;
		
		final String smtpEmail = "scy7143@gmail.com";
		final String password = "inhlpifirldolqbl";
		
		Properties props = new Properties();
		
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587"); // 465, 587
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		try {
			Session session = Session.getDefaultInstance(props);
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(fromMail, fromUserName));
			message.addRecipient(RecipientType.TO, new InternetAddress(toMail));
			message.setSubject(subject);
			
			Multipart mParts = new MimeMultipart();
			MimeBodyPart mTextPart = new MimeBodyPart();
			
			String cNumber = "";
			for (int i = 0; i < 6; i++) {
				int sel1 = (int) (Math.random() * 3);
				
				if (sel1 == 0) {
					int num = (int) (Math.random() * 10);
					cNumber += num;
				} else {
					char ch = (char) (Math.random() * 26 + 65);
					
					int sel2 = (int) (Math.random() + 2);
					
					if (sel2 == 0) {
						ch = (char) (ch + ('a' - 'A'));
					}
					
					cNumber += ch;
				}
			}
			
			StringBuffer sb = new StringBuffer();
			sb.append("<h3>Todo List 회원 가입 인증 번호입니다.</h3>\n");
			sb.append("<h3>인증번호 : <span style='color:red'>" + cNumber + "<span</h3>\n");
			
			String mailContent = sb.toString();
			
			mTextPart.setText(mailContent, "UTF-8", "html");
			mParts.addBodyPart(mTextPart);
			
			message.setContent(mParts);
			
			Transport t = session.getTransport("smtp");
			t.connect(smtpEmail, password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			
			int result = new MemberService().insertCertification(mail, cNumber);
			resp.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
