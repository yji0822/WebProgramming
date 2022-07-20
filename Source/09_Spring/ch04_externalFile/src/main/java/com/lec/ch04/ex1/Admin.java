package com.lec.ch04.ex1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Data;

@Data
public class Admin implements EnvironmentAware, InitializingBean {
	
	// admin.id와 admin.pw에 객체를 받아올 때 알아서 들어갈 수 있도록 해주고 싶다.
	private String adminId;
	private String adminPw;
	
	private Environment env; // import 잘 해오기 > implementAware implement 해주기 > 인터페이스 내부에 있는 것 가져오기 

	@Override
	public void setEnvironment(Environment environment) {
		env = environment; // bean 객체를 막 만들고 가장 먼저 실행됨 1.
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		adminId = env.getProperty("admin.id"); // 그대로 작성을 해주어야 한다. (properties와 있는 속성 이름과)
		adminPw = env.getProperty("admin.pw"); // 2. 아무런 정보가 없어도 알아서 만들어준다.
		
	}
	
	
	
}
