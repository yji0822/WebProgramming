package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
	// 스프링으로 import 해야 함
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입 명시 - 어떤 타입으로 할지 정해주면 됨(하라는대로)
	}

	@Override
	public void validate(Object target, Errors errors) {
		// student를 받아서 student를 검증하는 것
		// validate(student, errors) 호출
		// student를 받아와서 형변환 - target이 object이기 때문

		// name 잘못친 유효성 검사 로직
		/* 방법 1
		 * if(name==null || name.trim().isEmpty()) {
			errors.rejectValue("name", "no"); // name 에러 등록
		} */
		
		Student student = (Student)target;
		String name = student.getName(); // name이 스페이스인지 확인 - 다 스페이스면 오류 출력하기 위함
		int id = student.getId(); // id는 숫자형이었으니까!
		
		
		// 방법2 - 함수 사용
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no"); // name 에러 등록 - errors에 에러를 name의 에러를 등록해라
		if(id <= 0) {
			errors.rejectValue("id", "no"); // id 에러 등록
		}
	}
	
}
