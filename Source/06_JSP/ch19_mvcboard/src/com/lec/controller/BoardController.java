package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BContentService;
import com.lec.service.BDeleteService;
import com.lec.service.BListService;
import com.lec.service.BModifyService;
import com.lec.service.BModifyViewService;
import com.lec.service.BReplyService;
import com.lec.service.BReplyViewService;
import com.lec.service.BWriteService;
import com.lec.service.Service;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean write_view = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
		// throws는 dispathcer 할 때 필요하다.
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri     = request.getRequestURI(); // /ch19_mvcboard/list.do
		String conPath = request.getContextPath(); // /ch19_mvcboard
		String command = uri.substring(conPath.length()); // /list.do
		
		String viewPage = null;
		// 결과를 setAttribute를 해줘야 한다.
		// 인터페이스 Service 생성하기 > service 단에서 생성하기 
		Service service = null;
		
		if(command.equals("/list.do")) {
			// list.do - startPage + endPage
			service = new BListService();
			service.excute(request, response);
			// bListService 호출하고 request한 것들을 모두 받아온다. 그런 후에 
			// viewPage로 넘어간다.
			viewPage = "board/list.jsp"; // conPath 안붙여도 된다.
		
		} else if(command.equals("/write_view.do")){ // 원글쓰기 view (FORM 화면)
			viewPage = "board/write_view.jsp";
			write_view = true; // 변수설정을 해서 저장을 했는지 안했는지 확인 - 잠깐 확인한 후 다시 false로 반환
			// f5키를 누르면 저장이 안되도록
		} else if(command.equals("/write.do")) { // 원글쓰기 DB저장
			if(write_view) {
				service = new BWriteService();
				service.excute(request, response);
				write_view = false;
			}
			viewPage = "list.do";
			
		} else if(command.equals("/content_view.do")) {
			// 글 상세 보기
			service = new BContentService();
			service.excute(request, response);
			viewPage = "board/content_view.jsp";
		} else if(command.equals("/modify_view.do")) {
			// 글 수정 view (form태그)
			service = new BModifyViewService();
			service.excute(request, response);
			viewPage = "board/modify_view.jsp";
		} else if(command.equals("/modify.do")) {
			// 수정 DB저장
			service = new BModifyService();
			service.excute(request, response);
	        viewPage = "list.do";
		} else if(command.equals("/delete.do")) {
			// 글 db 삭제
			service = new BDeleteService();
			service.excute(request, response);
			viewPage = "list.do";
		} else if (command.equals("/reply_view.do")) { 
			// 답변글쓰기 view(form태그)
			service = new BReplyViewService();
			service.excute(request, response);
			viewPage = "board/reply_view.jsp";
		} else if(command.equals("/reply.do")) { // 답변글 DB 저장
			service = new BReplyService();
			service.excute(request, response);
			viewPage = "list.do";
		}	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); // request받은 것들을 지우지 않고 jsp로 넘겨주도록
	}

}
