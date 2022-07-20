package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;
import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class QuizController {
	
	// 항상 cnt가 들어오도록 
	@ModelAttribute("cnt") // 모든 함수에서 적용이 된다.  model.addAttribute("cnt", 5);
	public int cnt() {
		return 4;
	}
	
	@RequestMapping(value="quizInput.do", method=RequestMethod.GET)
	public String quizInput() {
		return "quiz/quizInput";
	}
	
	@RequestMapping(value="quizInputResult.do", method=RequestMethod.POST)
	public String quizInput(Quiz quiz, Errors errors, Model model) {
			QuizValidator validator = new QuizValidator();
		validator.validate(quiz, errors);
		
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if(errors.getFieldError("kor") != null) {
				model.addAttribute("scoreError", "과목 점수는 0점~100점 사이입니다.");
			}
			return "quiz/quizInput"; // 다시 입력 창으로 돌아갈 수 있도록
		}
		return "quiz/quizResult";
	}
	

	
	
}
