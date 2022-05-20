package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_HelloWorld
 */
// URL매핑 /HWorld
//@WebServlet(name = "HelloWorld", urlPatterns = { "/HWorld" }) // 새로운 URL : HWorld
public class Ex01_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// 있어도 되고 없어도 되고!
    public Ex01_HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 들어왔는데 get방식으로 들어오면 실행하는 곳 - 브라우저 안에서는 get방식으로 들어온다.
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet 호출"); // 콘솔창에서만 출력
		
		// response안에 한글까지 들어올 수 있도록 - HTML을 넣어주는 역할
		// charset=UTF-8을 사용해주어야 한글을 사용해도 깨지지 않게 나온다. 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // Stream 객체 생성 - html을  response에 넣어주기 위한 역할
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("h1 {color:blue;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>안녕하세요. 첫 servlet 예제입니다. </h1>");
		out.print("</body>");
		out.print("</html>"); // println도 사용 가능하다.
		out.close(); // 닫아주는 것이 예의
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// "post방식" 일때만 호출을 한다. - doPost를 출력한 뒤 바로 doGet을 호출한다.
		System.out.println("doPost 호출"); // 수행 안함
		doGet(request, response);
		
	}

}
