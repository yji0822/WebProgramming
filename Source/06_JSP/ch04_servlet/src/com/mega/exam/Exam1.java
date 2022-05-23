package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam1
 */
@WebServlet("/Exam1")
public class Exam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] su = request.getParameterValues("su");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(su!=null) {
			for(String s : su) {
				int dansu = Integer.parseInt(s);
				out.println("<h4>" + dansu + "단</h4>");
				for(int i=1; i<=9; i++) {
					out.printf("%d * %d = %d <br/>", dansu, i, dansu*i);
				} // for문
			} // 확장for문
		} else {
			out.println("<h2>선택된 구구단이 없습니다. </h2>");
		} // if-else
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
