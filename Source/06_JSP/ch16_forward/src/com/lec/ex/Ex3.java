package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex3() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	actionDo(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	actionDo(request,response);
    }
    
    private void actionDo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	int su = Integer.parseInt(request.getParameter("su"));
    	int sum = 0; //누적변수
    	for(int i=1; i<=su; i++) {
    		sum += i;
    	}
    	// 뷰단에 넘겨줘야 할 변수 = su
    	// 내부적으로 객체로 만들어서 넘겨주도록 한다.
		/* request.setAttribute("sum", new Integer(sum)); */
    	request.setAttribute("sum", sum);
    	
    	// view 단으로 
    	RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex3_suView.jsp");
    	dispatcher.forward(request, response);
    }
    

}
