package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost에서도 결국은 doGet을 호출하기 때문에 doGet에서 한번에 적어주어도 된다.
		// id, pw 파라미터 받아 브라우저 화면에 뿌리기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8"); // response 출력의 한글처리 ** 한글처리를 받아온 후에 출력
		PrintWriter out = response.getWriter();
		out.println("<h2>아이디: " + id + "</h2>");
		out.println("<h2>비밀번호: " + pw + "</h2>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // request 파라미터의 한글처리 - 한글처리를 한 후에 doGet을 처리를 해주어야 한다. ***
		doGet(request, response);
	}

}
