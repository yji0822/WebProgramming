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

	<h1>ex02_scope.jsp 입니다.</h1>
	<!-- scope 객체만 생략해서 사용 가능하다 -->
	<h3>page 내 속성 변수 값 : ${pageName }</h3>
	<h3>request 내 속성 변수 값 : ${requestName } </h3>
	<h3>session 내 속성 변수 값 : ${sessionName }</h3>
	<h3>application 내 속성 변수 값 : ${applicationName }</h3>
	
	<hr>
	<h3>이름 : ${param.name } <%=request.getParameter("name") %></h3>
	<h3>아이디 : ${param.id	 }</h3>
	<h3>비밀번호 : ${param.pw }</h3>
	
</body>
</html>