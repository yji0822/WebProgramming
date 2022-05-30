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
	// 로그인 성공 - 이름 및 아이디 출력 되는 메인
	// 세션 변수에 받아오기
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	%>	
	
	<% if(name != null) { %>
		<h2><%=name %>(<%=id %>)님, 안녕하세요!</h2>
		<button onclick="location.href='logout.jsp'">로그아웃</button>
	<%} else { %>
		<h2>손님 안녕하세요! 로그인 해주세요.</h2>
		<button onclick="location.href='login.jsp'">로그인</button>
	<% } %>
	<button onclick="location.href='sessionTest.jsp'">세션 확인</button>
	
	
</body>
</html>