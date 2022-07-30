package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	// dao 받아오기
	@Autowired
	private MemberDao memberDao;
	// 메일 빈 받아오기
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		// member.getMname()에게 메일 보내기, member db insert, session에 mid attribute 추가하기
		
		// 1. member.getMname()에게 메일 보내기 - 직전 프로젝트 참고(String content)
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin:0 auto; text-align:center;\">\n" + 
					"        <h1 style=\"color:blue;\">" + member.getMname() +"님 회원가입 감사합니다.</h1>\n" + 
					"        <div>\n" + 
					"            <p> 이 사이트에서만 사용할 수 있는 감사 쿠폰을 드립니다. </p>\n" + 
					"            <p>\n" + 
					"                <img src=\"http://localhost:8090/ch19/img/coupon.jpg\" />\n" + 
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
				// mimeMessage 완성하기
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMemail())); // 받는 메일 
				mimeMessage.setFrom(new InternetAddress("jeongim0822@gmail.com")); // 보내는 메일
				mimeMessage.setSubject(member.getMname() + "님 회원가입 감사합니다. (쿠폰동봉)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		System.out.println("메일 보낼 예정이다 : " + ((mailSender==null)? "널":"널아냐"));
		mailSender.send(message); // 메일 발송
		System.out.println("메일 보냈다");
		httpSession.setAttribute("mid", member.getMid()); // 세션에 mid 속성 추가
		
		return memberDao.joinMember(member); // 저장 return 이 int이기 때문에... 
		// 예외처리 시에 
		// result를 받고 0일 시에는 경고창 출력하고 1이면 위에 로직을 수행하는 방법도 있다.
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		// mid가 맞으면 비밀번호 불러와서 비교하는 로직
		String result = "로그인 성공";
		// dto가 존재하는지 id 확인
		Member member = memberDao.getDetailMember(mid);
		// mid가 있으면 mid dto 리턴해서 비밀번호 체크
		if(member == null) {
			result = "유효하지 않은 아이디 입니다.";
		} else if(! mpw.equals(member.getMpw())) { // pw는 제대로 체크 했는지
			result = "비밀번호가 맞지 않습니다.";
		} else { // 로그인 성공 - 세션에 저장하도록
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mid", mid);
		}
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}
