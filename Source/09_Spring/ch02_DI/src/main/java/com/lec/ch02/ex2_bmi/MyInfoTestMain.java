package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTestMain {

	public static void main(String[] args) {
		
		String resourceLocation = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		// 웹프로젝트가 아니기 때문에 파싱을 해주어야 한다. 웹프로젝트 진행 시 알에서 파싱을 해주는 친구가 들어갈 예정
		
		// MyInfo myInfo = (MyInfo) ctx.getBean("myInfo");
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		myInfo.getInfo();
		ctx.close();
		
	}

}
