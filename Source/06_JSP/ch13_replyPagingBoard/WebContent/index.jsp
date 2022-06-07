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

	<%-- <jsp:forward page="board/list.jsp"/> --%>
	<!-- forward는 모든 jsp파일들에 conPath를 잡아놓고 경로를 잡아주어야 한다. -->
	<% response.sendRedirect("board/list.jsp"); %>
	
</body>
</html>