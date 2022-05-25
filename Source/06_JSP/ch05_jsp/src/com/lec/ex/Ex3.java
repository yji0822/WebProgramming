package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 요청이 들어왔는지 판가름
		// ex... /Ex3, /insert.do /delete.do /update.do - 쇼핑몰에 물건 구매할때 url 한번 확인해보기
		String conPath = request.getContextPath(); // conPath = "/ch05_jsp"
		String uri     = request.getRequestURI(); 
		// 포트번호 이후부터 uri = "/ch05_jsp/Ex3" 
		// - /Ex3 어떤 요청이 들어왔는지 확인(substring으로 conPath 제거)
		//String command = uri.substring(9); // 9인덱스부터 끝까지
		String command = uri.substring(conPath.length()); // conPath의 길이부터 끝까지 출력
		System.out.println("conPath : " + conPath);
		System.out.println("uri     : " + uri);
		System.out.println("command : " + command);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
