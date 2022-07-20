package com.lec.ch03.ex2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements InitializingBean, DisposableBean, EnvironmentAware{
	
	// 빈의 생명주기 - aop 설명을 위한 전처리 작업
	
	private String name;
	private String tel;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 객체가 생성될때 자동으로 호출이 되는 함수
		System.out.println("2. Person형 빈 객체를 생성하자 마자 실행되는 함수 : afterPropertiesSet() 호출");
	}

	@Override
	public void destroy() throws Exception { // 내가 조정할 수 없다.
		System.out.println("3. Person형 빈 소멸하기 전에 실행되는 함수 : distroy() 호출 "); 
	}

	@Override
	public void setEnvironment(Environment environment) { // 객체를 만들자마자 실행1
		System.out.println("1. Person형 빈 소멸 바로 전  실행 : setEnvironment() 호출");
	} 
	
}
