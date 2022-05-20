package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// menu, rest 파라미터 : null, 같은 이름의 파라미터가 여러개 - > 복수개일 수 있으면
		// ->>>> request.getParameterValues("파라미터이름") =>> 배열로 받음
		// ->>>> 같은 이름의 파라미터를 여러개 전달받을 경우
		// nation 파라미터 : request.getParameter("파라미터이름") >>>> String으로 받음
		String[] menu = request.getParameterValues("menu"); // 배열
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation"); // 절대로 여러개 받을 수 없는 Radio Button!
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 무조건 for문을 돌리면 안된다
		// \n 대신에 <br>
		if(menu!=null) {
			out.println("<h4>선택한 메뉴는 ");
			for(String m : menu) {
				out.println(m + " ");
			}
			out.println("입니다. </h4>");
		}else {
			out.println("<h4>선택한 메뉴가 없습니다.</h4>");
		}
		
		if(rest!=null) {
			out.println("<h4>선택 식당 지역은 " + Arrays.toString(rest) + "입니다. </h4>");
		} else {
			out.println("<h4>선택한 식당 지역이 없습니다. </h4>");
		}
		
		out.println("<h4>선택한 국적은 " + nation + "입니다. </h4>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
