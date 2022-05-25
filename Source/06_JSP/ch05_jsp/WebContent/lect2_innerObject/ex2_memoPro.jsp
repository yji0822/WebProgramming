<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex2_memo에서 파라미터 전달받은 후에 출력하는 페이지 -->
	<!-- writer랑 memo -->
	<%
		// post타입으로 받아주었을 때는 반드시 제일 앞에 
		request.setCharacterEncoding("utf-8"); 
		String writer = request.getParameter("writer");
		String memo   = request.getParameter("memo");
		// 요청한 클라이언트의 ip주소, 글쓴 시점  자동 저장
		// ip와 date는 DB에 저장할 예정
		String ip     = request.getRemoteAddr(); 
		Date   date   = new Date(System.currentTimeMillis()); // 요청한 시점의 날짜와 시간
	%>
		<h2>글쓴이 : <%=writer %></h2>
		<h2>한줄메모 : <%=memo %></h2>
		<h2>글쓴 ip주소 : <%=ip %></h2>
		<h2>글쓴 시점 : <%=date %></h2>
</body>
</html>