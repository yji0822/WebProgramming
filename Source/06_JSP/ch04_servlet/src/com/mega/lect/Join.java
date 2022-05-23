package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id, pw, 이름 등 정보 받아서 출력하는 것
		String hiddenParam = request.getParameter("hiddenParam");
		String name 	   = request.getParameter("name");
		String id   	   = request.getParameter("id");
		String pw   	   = request.getParameter("pw");
		String birth       = request.getParameter("birth");
		Date birth2 = null;
		Timestamp birth3 = null;
		if(birth !="") {
			birth2      = Date.valueOf(request.getParameter("birth")); // 데이터베이스 연동을 위하여 사용
			birth3   = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00"); // 데이터베이스 연동 TimeStamp는 반드시 시간이 들어가야 한다.
		}
		String[] hobby = request.getParameterValues("hobby"); // 하나도 안받을 수 있다. - 배열(하나라도 체크했으면) or null
		String gender  = request.getParameter("gender");
		String email   = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend"); // 배열
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		// <link href='css/join.css' rel='stylesheet'>
		out.println("<link href='css/join.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id=join_title>회 원 가 입 정 보</div>");
		out.println("<h2>hiddenParam = " +hiddenParam + "</h2>");
		out.println("<h2>이름 : " + name + "</h2>");
		out.println("<h2>비밀번호 : "); 
		// 비밀번호를 다 출력하지 않고 * 로 출력할 수 있도록
		for(int i=0; i<=pw.length(); i++) {
			out.println('*'); // 글자 숫자만큼만 출력이 된다.
		}
		out.println("</h2>");
		
		out.println("<h2>생년월일 : " + birth + "</h2>");
		out.println("<h2>생년월일2(java.sql.Date) : " + birth2 + "</h2>"); // 빈스트링이 들어오면 에러
		out.println("<h2>생년월일3(java.sql.TimeStamp) : " + birth3 + "</h2>"); // 빈스트링이들어오면 에러
		
		out.println("<h2>취미 : "); // 취미 : 요리, 운동
		if(hobby!=null) {
			for(int i=0; i<hobby.length; i++) {
				if(i==hobby.length-1) {
					out.println(hobby[i]);
				} else {
					// 여러개가 있을 경우
					out.println(hobby[i] + ", ");
				} // if-else
			}
		} else {
			out.println("선택된 취미가 없음");
		}
		out.println("</h2>");
		out.println("<h2>성별 : " + gender + "</h2>");
		out.println("<h2>이메일 : " + email + "</h2>");
		out.println("<h2>메일 수신 동의 : " + Arrays.toString(mailSend) + "</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
