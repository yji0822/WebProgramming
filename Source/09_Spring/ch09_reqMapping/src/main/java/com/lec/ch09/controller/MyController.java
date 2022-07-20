package com.lec.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	// .do는 붙여도 되고 안붙여도 되고
	/* @RequestMapping(value="main.do") */
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String student(String id, Model model) {
		// get인지 post인지 확인하는 방법
		/* String method = request.getMethod(); */
		// id = request.getParameter("id"); -이런 방식은 사용하지 않는다.
		
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	
	@RequestMapping(value="student", method=RequestMethod.POST)
	public ModelAndView student (String id, ModelAndView mav) {
		// id = request.getParameter("id");
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}
	
	// idConfirm.do 로 get방식으로 받아온 id
	@RequestMapping(value="idConfirm", method=RequestMethod.GET)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			// return "studentOk.do"; // 에러발생 - 요청경로라고 생각하지 않고 jsp라고 생각한다.
			return "forward:studentOk.do"; // 방법1. 새로운 요청 경로로 가라는 의미
			// return "redirect:studentOk.do"; // 방법2. redirect / 새로운 경로로 가라고 하기 때문에 파라미터가 다 날라가버림.
			// 파라미터를 받아서 가려면 forward로 해서 넘겨주는 것이 맞다.
		}
		return "redirect:studentNg.do?id="+id;
	}
	
	// 로그인 처리, 같은 get방식으로 적어 주어야 한다. - forward
	@RequestMapping(value="studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	
	// redirect
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
	public String studentNg(String id) {
		return "studentNg";
	}
	
	// fullpath 를 사용할때에도 redirect를 사용해야 한다.
	@RequestMapping(value="fullPath", method=RequestMethod.GET)
	public String fullPath() {
		return "redirect:https://www.naver.com";
	}
	
	
}
