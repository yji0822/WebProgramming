package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2_suOut
 */
@WebServlet(name = "Ex2_suOut", description = "sumOut", urlPatterns = { "/Ex2suOut" })
public class Ex2_suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2_suOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String numStr = request.getParameter("num");
		// 값이 없거나 빈스트링이 들어갈 경우 1로 처리해줌
		if(numStr==null || numStr.equals("")) {
			numStr = "1"; // 페이징할때 많이 쓰인다. 빈페이지가 들어가면 홈으로 옮겨진다던가..
		}
		int num = Integer.parseInt(request.getParameter("num"));
		// 안넣으면 값이 1로 세팅될 수 있도록
		int sum = 0; // 누적변수
		for(int i=0; i<=num; i++) {
			sum += i;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // html을 만들 수 있도록
		// 바디만 작성할 경우에는 body안에만 들어갈 수 있는 내용들만 적어도 된다.
		out.println("<h1>1부터 " + num + "까지의 누적합은 " + sum + "입니다.</h1>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
