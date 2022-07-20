package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("member") // 공통 요청 경로
public class MemberController {

	// member?method=join, member?method=login, member?method=logout, member?method=infoModify
	
	// 메소드는 파라미터이다. member는 공통경로로 빼주었기 때문에 안써줘도 된다
	@RequestMapping(/*value="member",*/ params="method=join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	
	@RequestMapping(params="method=login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("result", "login");
		return "member/result";
		// 한꺼번에 써주는 작업
	}
	
	@RequestMapping(params = "method=logout")
	public String logout(Model model) {
		model.addAttribute("result", "logout");
		return "member/result";
	}
	
	@RequestMapping(params = "method=infoModify")
	public String infoModify(Model model) {
		model.addAttribute("result", "infoModify");
		return "member/result";
	}

	
	
}
