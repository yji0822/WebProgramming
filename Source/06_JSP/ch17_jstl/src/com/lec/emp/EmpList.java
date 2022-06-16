package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/empList")
public class EmpList extends HttpServlet {
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
		// Dao 객체 만든 후 호출
		EmpDao eDao = new EmpDao(); // 싱글톤이 아니기 때문에 new!
		ArrayList<EmpDto> emps = eDao.listEmp(); // 전체 emp테이블 리스트 출력
		
		// 불러온 리스트들을 emps라는 request 객체에 담아주는 작업
		request.setAttribute("emps", emps);
		// 파라미터들을 모두 넘겨주는 작업 - 폴더 반드시 넘겨주기
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empList.jsp");
		// 넘겨줘!
		dispatcher.forward(request, response);
	}

}
