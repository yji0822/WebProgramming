package com.lec.ch03.ex2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtherPerson {
	
	// 방법2
	private String name;
	private int age;
	
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherPerson 형 빈 생성하자마자 자동 호출 : initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("OtherPerson형 빈 소멸 전 자동 호출 : destroyMethod()");
	}

	// 외부파일을 불러올 때 실행 시점에서 가져올지 종료 시점에서 가져올지에 따라 사용하기도 해서... 배우는 것...
	
}
