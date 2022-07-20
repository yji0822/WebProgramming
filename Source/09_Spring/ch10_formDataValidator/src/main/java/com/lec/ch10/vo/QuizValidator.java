package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class QuizValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Quiz.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입 명시 - 어떤 타입으로 할지 정해주면 됨(하라는대로)
	}

	@Override
	public void validate(Object target, Errors errors) {
		Quiz quiz = (Quiz)target;
		
		String name = quiz.getName(); // name이 스페이스인지 확인 - 다 스페이스면 오류 출력하기 위함
		int kor = quiz.getKor();
		int eng = quiz.getEng(); 
		int math = quiz.getMath(); 
		
		
		// 방법2 - 함수 사용
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no"); // name 에러 등록 - errors에 에러를 name의 에러를 등록해라
		if(kor < 0 || eng < 0 || math < 0 || kor > 100 || eng > 100 || math > 100) {
			errors.rejectValue("kor", "no"); // 점수 유효성 검증
		}
	}
	
}
