package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam2
 */
@WebServlet("/Exam2")
public class Exam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실무에서는 함수를 만든 뒤에 호출해주는 방식에서 사용한다.
		actionDo(request, response);
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h2>이름은 " + name +"이고, 주소는 " + address + "입니다. </h2>");
//		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		doGet(request, response);
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address"); // 위의 doGet과 doPost에 있는 throws를 가져온다.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>이름은 " + name +"이고, 주소는 " + address + "입니다. </h2>");
		out.close();
	}
	
	

}
