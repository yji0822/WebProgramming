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
		// 세션에 속성 추가 (객체 타입으로 추가) - 뺄때 object type로 리턴
		session.setAttribute("sessionName", "sessionValue");
		session.setAttribute("myNum", 123); // 아래와 같이 인식되어 받아들여진다.
		// session.setAttribute("myNum", new Integer(123)); 
	%>
	<!-- 오직 자바로만 확인이 가능하다 -->
	<h1>세션에 sessionName 속성 추가</h1>
	<h1>세션에 myNum 속성 추가</h1>
	<h1><a href="ex2_sessionGet.jsp">세션Get</a></h1>
	
	
</body>
</html>