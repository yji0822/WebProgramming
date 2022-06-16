package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.DeleteService;
import com.lec.service.InsertService;
import com.lec.service.SelectService;
import com.lec.service.Service;
import com.lec.service.UpdateService;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* response.getWriter().append("<h1>FrontController</h1>"); */
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); 
		// uri에서 5글자만 뺀 나머지 
		String command = uri.substring(conPath.length()); // "/select.do" 를 선택했는지 아닌지 알 수 있다.
		
		System.out.println("uri = " + uri); // /ch18/*.do - localhost:8090 을 지운 나머지 뒤
		System.out.println("conPath = " + conPath); // /ch18
		// uri를 받은 후에 conpath인 /ch18을 뺀다. (subString)
		System.out.println("들어온 요청 = " + command); // "/select.do"
		
		// jsp페이지를 저장하는 변수 생성
		String viewPage = null; // 뷰단의 이름이 들어갈 예정
		Service service = null;
		
		if(command.equals("/insert.do")) {
			// insert.do가 들어왔다면 insert.do 로직을 수행해라
			 /* 부품화를 시켜야 한다! >> 인터페이스화 시켜야 한다. */
			// 어떤 기능이 있는지만 확인하고 어디로 가야하는지만 확인할 수 있도록
			// 객체이름과 메소드 이름을 일치시키도록 한다. - 헷갈리면 안되니까!
			// request.setAttribute(request, response);
			
			// insert 로직을 수행할 객체 생성
			service = new InsertService();
			// 객체이름.메소드(request, response);
			service.excute(request, response); // db연동을 하는 역할을 하는 excute함수
			// request.setAttribute("result", "insert 결과");
			/* viewPage = "ex2/insert.jsp"; */
			// list 결과를 못뿌린다. insert한 후에는 list(select)화면을 뿌려주게 하는데 
			// select.jsp를 하는 것이 아니라 다시 select.do로 가도록 한다.
			// 글을 쓴 다음에 작성이 완료되면 insert뷰가 따로 있는 것이 아닌 select의 list화면으로 가는데
			// 그 로직을 수행하기 위해서는 select.do로 옮겨 가도록 한다.
			viewPage = "select.do";

		} else if(command.equals("/select.do")) {
			// 슬래시 꼭 넣어주자. select.do 실행하도록 하는 로직
			//request.setAttribute("list", "list결과");
			
			service = new SelectService();
			service.excute(request, response);
			viewPage = "ex2/select.jsp";
		} else if(command.equals("/delete.do")) {
			service = new DeleteService();
			service.excute(request, response);
			// request.setAttribute("result", "delete결과");
			// 삭제한 결과를 request객체에 넣어주는
			viewPage = "select.do";
		} else if(command.equals("/update.do")) {
			// 화면에 뿌려주고 싶은 결과가 있으면 setAttribute를 사용한다.
			service = new UpdateService();
			service.excute(request, response);
			//request.setAttribute("result", "update결과");
			viewPage = "select.do";
		}
		// select단을 잘 만들어주어야 한다..! ㅋㅋ
		// insert,update,delete는 select로 넘어가도록 한다.
		
		// 어떤 command가 들어왔는지 분기하는 작업 - request.setAttribute를 해줬기 때문에 새로 생성하면 안됨
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
