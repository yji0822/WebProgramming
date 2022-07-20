package com.lec.ch04.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch04.ex4.EnvInfo;

public class ProfileTestMain {

	public static void main(String[] args) {
		
		// 어떤 환경인지 체크하는 부분 = 오늘은 Scanner로 확인할 것
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("어떤 환경인지 적어주세요(dev, run) : ");
		String answer = sc.next();
		
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev"; // xml에 소문자로 적었으니까 소문자로 진행하도록 한다.
		} else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.exit(0); // 시스템 종료
		}
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config); // dev or run 둘 중에 하나 받아오고 활성화를 시키는 작업(파싱)
		ctx.load("classpath:META-INF/ex3/CTX_dev.xml", "classpath:META-INF/ex3/CTX_run.xml");
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
	} // main

}
