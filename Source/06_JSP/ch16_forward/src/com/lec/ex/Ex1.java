package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response); // request랑 response 호출 하도록 함수 생성 후 호출
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// id랑 pw를 매개변수로 받은 상태.. - 프로세스 단
		// 넘어온 파라미터 id, pw를 이용하여 객체를 만든 후 View단으로 넘긴다(=forward)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 객체생성
		Member member = new Member(id, pw);
		// 값을 넘기는 것
		request.setAttribute("member", member); // request에서 member를 출력하도록
		// request를 유지한 채로 forward를 해주어야 한다.
		// View단으로 forward - RequestDispatcher dispatcher 
		// 따옴표 안에는 뷰단의 이름을 적어준다.(폴더 이름도 반드시 적어주어야 한다.)
		RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex2_View.jsp"); 
		dispatcher.forward(request, response);
		
		// ex2_View.jsp 생성해주기....
		// 서블릿으로 난 것 처럼 보이는데 뷰단에서 출력되어서 뿌려진 것이다.
		
		// request 객체가 새로 만들어지므로 저장한 파라미터들이 다 사라진다.
		// response.sendRedirect("1_dispatcher/ex2_View.jsp?id=aaa&pw=111");
	}
}
