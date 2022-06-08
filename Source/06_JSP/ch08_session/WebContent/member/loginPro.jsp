<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>

<body>

	<!-- 로그인 성공 페이지 -->
	<%
		Boolean ok = false;
		String msg;
	
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id!=null && id.equals("aaa")) {
			if(pw!=null && pw.equals("111")) {
				session.setAttribute("name", "홍길동");
				response.sendRedirect("main.jsp");
			} else {
				// sendRedirect로 메세지를 전달하고자 할때는 URLEncoder.encode("넘길 메세지", "utf-8");
				msg = URLEncoder.encode("비밀번호를 확인하세요.", "utf-8");
				response.sendRedirect("login.jsp?msg=" + msg);
			} // pw if-else
		} else {
			msg = URLEncoder.encode("아이디를 확인하세요.", "utf-8");
			response.sendRedirect("login.jsp?msg=" + msg);
		}
		
	%>
	
	
</body>
</html>