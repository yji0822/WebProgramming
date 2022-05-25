<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	a {
		color: red;
		text-decoration: none;
	}
	</style>
</head>

<body>
	
	<h1>쿠키 생성</h1> <!-- 쿠키 생성 : 객체로 생성 -->
	
	<%
	Cookie cookie = new Cookie("cookieName", "cookieValue"); // 쿠키 생성 : 우리가 나중에  쓸 때는 id로
	cookie.setMaxAge(60*60); // 한시간 유효한 쿠키
	response.addCookie(cookie); // response에 탑재
	%>	
	
	<!-- ★ 아래 두 변수는 꼭 기억하기 ★ -->
	<h2>지금 막 생성된 쿠키 이름 : <%= cookie.getName() %></h2>
	<h2>지금 막 생성된 쿠키의 값 : <%= cookie.getValue() %></h2>
	
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키생성(cookieName))</a> <br>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름-쿠키값) 리스트 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName인 것) 찾기</a><br>
	<a href="ex4_cookieDel.jsp">쿠키 삭제</a> <!-- (id란 이름의 쿠키를 갖고 있는지 아닌지 확인) -->
	
</body>
</html>