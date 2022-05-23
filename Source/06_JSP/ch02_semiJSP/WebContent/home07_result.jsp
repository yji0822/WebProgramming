<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>결과화면</h1>
	<%! String name, id, pw; %>
	<% 
	request.setCharacterEncoding("utf-8");
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	%>
	<h2><%=name %>님, 안녕하세요! 회원님의 아이디는 <%=id %>, 비밀번호는 <%= pw %>입니다.</h2>
</body>
</html>