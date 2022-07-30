package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	// 차이점 controller에서 확인하기
	
	// 회원가입 뷰단 
	@RequestMapping(params="method=joinForm", method=RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	
	// 회원가입 시 아이디 확인로직
	@RequestMapping(params = "method=idConfirm", method=RequestMethod.GET)
	public String idconfirm(String mid, Model model) {
		model.addAttribute("result", memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	
	// 회원가입 진행 로직
	@RequestMapping(params="method=join", method=RequestMethod.POST)
	public String join(@ModelAttribute("mDto") Member member, HttpSession httpSession, Model model) {
		model.addAttribute("joinResult", memberService.joinMember(member, httpSession));
		return "forward:member.do?method=loginForm";
	}
	
	// 로그인 뷰단
	@RequestMapping(params="method=loginForm", method={RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 로그인 처리
	@RequestMapping(params="method=login", method=RequestMethod.POST)
	public String login(String mid, String mpw, Model model, HttpSession httpSession) {
		
		String result = memberService.loginCheck(mid, mpw, httpSession);
		
		if(result.equals("로그인 성공")) {
		
			return "redirect:main.do";
		
		}else {
			
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result", result);
			
			return "forward:member.do?method=loginForm";
		}
	}
	
	 // 회원정보 수정 폼
	 @RequestMapping(params="method=modifyForm", method={RequestMethod.GET, RequestMethod.POST}) 
	 public String modifyForm() {
		 return "member/modifyForm"; 
	 }
	 
	 // 회원정보 수정 처리
	 @RequestMapping(params="method=modify", method=RequestMethod.POST)
	 public String modify(@ModelAttribute("mDto") Member member, Model model, HttpSession httpsession) {
		
		model.addAttribute("modifyResult", memberService.modifyMember(member)); 
		httpsession.setAttribute("member", member);
		
		return "forward:main.do";
	 }
	 
	 // 로그아웃
	 @RequestMapping(params="method=logout")
	 public String logout(HttpSession httpSession) {
		 
		 httpSession.invalidate(); // 로그인 세션 만료
		
		 return "redirect:main.do"; // 메인 페이지로 넘어가도록 하는 로직
	 }
	 
	 
	 
	
	
}
