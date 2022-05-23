package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Ex3_LifeCycle() {
		// 객체 만들 때 딱 한번 호출 초기값 생성이 되려고 할때
		System.out.println("Ex3_LifeCycle 생성자 / 1 "); 
	}
	
	// 어노테이션 함수를 쓴 것이 먼저 수행이 된다.
	@PostConstruct
	public void postConstruct() {
		System.out.println("Ex3_LifeCycle 서블릿 객체가 생성되었을 때 수행 / 2-1 : postConstruct()");
	}
	public void init(ServletConfig config) throws ServletException {
		// 객체가 막 생성될 때 최초 한번 수행
		System.out.println("Ex3_LifeCycle 서블릿 객체가 생성되었을 때 수행 / 2-2 : init()");
	}

	// 요청이 들어왔을때
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 요청이 들어왔을 때 수행.(service메소드가 있으면 doGet/doPost는 실행되지 않는다.
		System.out.println("service() 실행 / 3 : service()");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>service() 실행!!</h2>");
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청이 get방식으로 들어왔을 경우 수행 - service()가 있으면 수행하지 않음
		System.out.println("doGet() 실행");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>doGet() 실행!</h2>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청이 post방식으로 들어왔을 때 수행 (service함수가 없을때)
		System.out.println("doPost() 실행 ");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>doPost() 실행!</h2>");
		out.close();
	}

	public void destroy() {
		// Ex3_LifeCycle 서블릿이 메모리에서 이 서블릿이 사라질 때(해제될 때) 수행
		System.out.println("destroy() 실행 (메모리 해제) / 4-1 : destroy()");
	}
	// 더 마지막에 실행
	@PreDestroy
	private void preDestroy() {
		System.out.println("preDestroy() 실행 (메모리 해제) / 4-2 : preDestroy()");
	}
}
