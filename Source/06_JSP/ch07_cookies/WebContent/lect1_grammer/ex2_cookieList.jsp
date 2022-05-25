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

	<h1>쿠키 리스트</h1>
	
	<%
		Cookie[] cookies = request.getCookies();
		// 배열로 쿠키 출력
		for(int idx=0; idx<cookies.length; idx++){
			// 쿠키 리스트 출력
			String name = cookies[idx].getName(); // idx번째 쿠키 이름
			String value = cookies[idx].getValue(); // idx번째 쿠키의 값
			out.println("<h2>"+ idx + "번째 쿠키 이름 : " + name + ", 값 : " + value + "</h2>");
		}
	%>
	
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키생성(cookieName))</a> <br>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름-쿠키값) 리스트 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName인 것) 찾기</a><br>
	<a href="ex4_cookieDel.jsp">쿠키 삭제</a> <!-- (id란 이름의 쿠키를 갖고 있는지 아닌지 확인) -->

</body>
</html>