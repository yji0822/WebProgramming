package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MemberJoinService;
import com.lec.service.MemberListService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	private void actionDo (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uri = request.getRequestURI(); // "ch19_mvc/memberList.do"
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length()); // 앞에서부터 conPath 까지
		String viewPage = null; 
		Service service = null; // Service란 인터페이스 만든 다음 호출해주어야 한다.
		
		if(command.equals("/memberList.do")) {
			// list로직 수행하는 객체를 생성
			service = new MemberListService();
			// 객체.메소드() // request = memberList
			service.excute(request, response);
			// view단 설정
			viewPage = "member/memberList.jsp";
			
		} else if(command.equals("/memberJoin_view.do")) {
			// join로직 수행하는 객체를 생성 X
			// 객체.메소드() X
			// 화면에 뿌리는 역할만 수행을 하기 때문에 따로 객체를 생성하고 호출할 이유가 없다
			
			// view단 설정
			viewPage = "member/join.jsp";
		
		} else if(command.equals("/memberJoin.do")) {
			// list로직 수행하는 객체를 생성
			service = new MemberJoinService();
			// 객체.메소드()
			service.excute(request, response);
			// view단 설정
			viewPage="memberList.do"; // insert 다 된 다음에 list페이지를 출력하라는 의미
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		// view단에선 for문만 돌리면 끝난다!
		
	}
	

}
