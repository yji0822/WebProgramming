package com.lec.ch02.ex4_vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VehicleTestMain {

	public static void main(String[] args) {
		String location = "classpath:applicationCTX4.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
	
		Vehicle vh = ctx.getBean("vh", Vehicle.class); // 타는 것과 스피드를 불러옴
		vh.ride("박길동"); // 이름 넣어주기
		ctx.close();
		
	}

}
