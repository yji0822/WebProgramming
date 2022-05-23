package com.mega.lect;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
// 개인적으로 쓸 일은 없지만 
public class Ex4_Listener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹프로젝트가 메모리에 구동되는 시점에 실행
		System.out.println("★★★ ch04_context가 ■시작■될 때 (웹프로젝트(ch04_servlet)가 메모리에 구동됨) ★★★");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹프로젝트가 메모리에서 해제되는 시점에 실행
		System.out.println("★★★ ch04_context가 ※종료※될 때 (웹프로젝트(ch04_servlet)가 메모리에 구동됨) ★★★");
	}
}
