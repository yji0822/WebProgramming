package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {

	@RequestMapping(value="inputForm.do", method=RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	
	// 유효성 검사를 하는 곳
	@RequestMapping(value="input.do", method=RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		// String viewPage = "ex/inputResult"; - 써도 되고 안써도 된다.
		// if(에러를 잡았다면) { viewPage = "inputForm.do" 에러난 곳 점검 메세지 model에 add
		// viewPage = "ex/inputForm" } 

		// 검증 객체를 이용 해서 검증 method 호출
		StudentValidator validator = new StudentValidator();
		validator.validate(student, errors);
		
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수 입니다.");
			}
			return "ex/inputForm"; // 다시 입력 창으로 돌아갈 수 있도록
		}
		return "ex/inputResult";
	}
	
	// 검증 클래스를 만들어야 하고 errors를 담아놔야 함
	
	
	
}
