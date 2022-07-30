package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	// properties가 제대로 연결이 되었는지 확인하는 방법
	// 아이디랑 비밀번호를 제대로 입력했는지 확인하는 것은 아직은 확인 불가
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// 메일 보내는 창 만들기 (이메일만 처리하는 로직)
		
		return "join";
	}
	
	// 이 요청경로로 들어오면 이름이랑 메일 먼저 전달 받기
	@RequestMapping(value="textMail", method=RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		// 텍스트 메일 보낼때 필요한 객체
		// new를 하는 것은 그냥 주입받지 않고 그래도 사용을 하기 때문에
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("jeongim0822@gmail.com"); // 관리자의 메일 주소(보내는 사람 메일)
		message.setTo(email); // 받는 사람의 메일 주소
		message.setSubject("[text 가입인사]" + name + "님 회원가입을 진심으로 감사 드립니다.");
		// 메일 내용은 길 수도 있으므로 String으로 먼저 작성해준다.
		String content = name+ "님 회원가입 감사합니다.\n <h1> 태그 안 먹음 </h1>"; // 텍스트 방식으로. 태그 미적용
		// 말 그대로 텍스트만 전송 가능하고 html처럼 이쁘게 꾸미는 것은 불가함.
		message.setText(content); // 메일 본문 내용 

		// 메일 보내기는 mailSender 이용 - properties에 입력했던 것이 오류가 났을 경우에는 메일이 보내지지 않을 것
		mailSender.send(message); 
		model.addAttribute("mailSendResult", "text메일이 발송 되었습니다."); 
		// 메일 보내기가 성공이 되었을 경우에는 이 메세지가 성공적으로 출력
		return "sendResult"; // 그리고 페이지 이동
	}
	
	// html 이용하는 방식 - annonymous 방식은 final 변수로 받아와야 한다.
	@RequestMapping(value="htmlMail", method=RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		
		// 1. html 먼저 만들어주기 - 그냥 html 파일에 만들기
		// name에게 email 주소로 html적용되는 내용 보내기
		MimeMessagePreparator message = new MimeMessagePreparator() {
			// html로 만든 메일내용 (직전에 만든 것 그대로 복붙)
			// 받는 사람 이름은 변경이 되어야 하는데..
			String content = "<div style=\"width:500px; margin:0 auto; text-align:center;\">\n" + 
					"        <h1 style=\"color:blue;\">홍길동님 회원가입 감사합니다.</h1>\n" + 
					"        <div>\n" + 
					"            <p> 이 사이트에서만 사용할 수 있는 감사 쿠폰을 드립니다. </p>\n" + 
					"            <p>\n" + 
					"                <img src=\"http://localhost:8090/ch18/resources/coupon.jpg\" />\n" + 
					"            </p>\n" + 
					"        </div>\n" + 
					"        <div>\n" + 
					"            <p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"            <p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"            <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\" />\n" + 
					"        </div>\n" + 
					"        <p> 서울시 어떤구 어떤로 어떤빌딩 402호</p>\n" + 
					"    </div>"; 
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 위에 있는 변수 mimeMessage를 가지고 보내는 메일, 받는 메일, 메일 제목, 한글이면 utf-8 필터링
				
				// 받는 메일 - 한번 감싸주어야 한다.
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 매개변수로 들어온 메일
				// 보내는 메일 
				mimeMessage.setFrom(new InternetAddress("jeongim0822@gmail.com"));
				mimeMessage.setSubject("[HTML 가입인사]" + name + "님 회원가입 감사합니다.");
				// utf-8 처리
				mimeMessage.setText(content, "utf-8", "html"); //html이라고 명시를해주는 것
			}
		}; // 인터페이스 - new 불가
		
		mailSender.send(message);
		model.addAttribute("mailSendResult", "HTML 메일이 발송 완료 되었습니다.");
		
		return "sendResult";
	}
}
