package com.lec.ch04.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 빈 컨테이너 생성
		ConfigurableEnvironment env = ctx.getEnvironment(); // 마우스를 가져다 대면 리턴 타입(ConfigurableEnvironment)이 나온다.
		
		System.out.println("방법1");
		// env의 속성리스트를 불러와서 출력하도록 하는 작업
		MutablePropertySources propertySources = env.getPropertySources(); // env의 속성과 속성값 세팅(set)
		// admin id와 pw
		// 속성을 추가하라는 의미
		try {
			String location = "classpath:META-INF/ex1/admin.properties";
			propertySources.addLast(new ResourcePropertySource(location)); // 외부설정 파일 추가
		} catch (IOException e) {
			System.out.println(e.getMessage() + "properties에 불러올 값 없음.");
		}
		
		// admin.properties에서 받아온 admin.id와 admin.pw를 출력한다. 띄어쓰기가 없도록 주의 한다.
		System.out.println("admin.id = " + env.getProperty("admin.id")); // 반드시 properties의 = 앞에 있는 것 그대로 받아와야 한다.
		System.out.println("admin.pw = " + env.getProperty("admin.pw"));
		
		// 스프링컨테이너가 있고 컨테이너 안에 아무것도 없는 상태. env에 속성이 담겨져 있고 그걸 받아서 출력한 것임.
		
	
		/* env에 외부 설정 파일 속성들을 추가한 후 빈 생성 admin 객체로 받아와서 출력하는 것 */
		System.out.println("방법2");
		ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh(); // admin.id와 admin.pw를 받아옴
		
		Admin admin = ctx.getBean("admin", Admin.class); // admin 객체 생성 후 받아오는 작업
		
		System.out.println("adminId : " + admin.getAdminId());
		System.out.println("adminPw : " + admin.getAdminPw());
		ctx.close();
	}

}
