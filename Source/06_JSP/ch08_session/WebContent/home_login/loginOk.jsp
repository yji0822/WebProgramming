<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%
	// 화면에는 출력되지 않는 단순 로그인 체크 로직
	String msg = "";
	String id = request.getParameter("id"); // id 입력값 받아오기
	String pw = request.getParameter("pw"); // pw 가져오기
	
	// 유효성 검증
	if(id != null && id.equals("aaa")) { // id가 aaa가 맞는지
		if(pw != null && pw.equals("111")){ // pw가 111이 맞는지
			// 로그인 성공 처리 / 세션에 저장하기 - 이름과 아이디
			session.setAttribute("name", "홍길동");
			session.setAttribute("id", id);
			response.sendRedirect("welcome.jsp");
		} else {
			// pw 오류
			msg = URLEncoder.encode("pw를 체크하세요", "utf-8");
			response.sendRedirect("login.jsp?msg=" + msg);
		} // pw 유효성 검사 if-else
	} else {
		msg = URLEncoder.encode("id를 체크하세요", "utf-8");
		response.sendRedirect("login.jsp?msg=" + msg);
	} //if-else
	
	%>

</body>
</html>