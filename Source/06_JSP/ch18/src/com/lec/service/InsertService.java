package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// 우리가 만들어준 인터페이스 implement
		// insert로직 (DAO 생성 - request.getParameter / 파라미터 받아 dto 객체 생성 - dao.insert호출)
		/* int result = dao.insert(dto); 이런 식으로! 성공하면 결과값 1 아니면 0*/
		int result = 1;
		request.setAttribute("insertResult", result);
		// 나를 호출한 곳? frontController로 넘어간다. 
		// viewPage 존재하고 insert.jsp로 결과값을 넘겨준다.
	}

}
