package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	
	public int idConfirm(String mid);
	public int joinMember(Member member, HttpSession httpSession); 
	// 메일 보내주는 기능 추가. idSession에 넣어주어야 함 (session필요)
	// request객체가 없음 컨트롤러단에서 request 단에서 받아줘야 하는데.. session을 받아오도록
	public String loginCheck(String mid, String mpw, HttpSession httpSession);
	// 로그인 체크 로직 : 디테일은 아이디만 입력하고 이 아이디가 있니? 없어? 아이디 제대로 쳐 + 아이디가 있니? 비밀번호를 가져와 
	// 비밀번호가 같으면 경고창 
	// 왜 리턴 타입이 String ? >> 로그인 성공 로그인 실패 이런거 출력하기 위해서
	public Member getDetailMember(String mid); // 상세보기만 하기 때문에 세션 넣어주지 않을 것
	public int modifyMember(Member member); 
	// session 은 컨트롤러 단에서 처리할 것 / 저장하고 가져와야 하기 때문에 컨트롤러에서
	

	
}
