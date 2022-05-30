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
		session.setAttribute("SESSION_NAME", "SESSION_VALUE");
		session.setAttribute("MY_NUM", 123);
		
	%>
		<h1> session에 SESSION_NAME 추가 </h1>
		<h1> session에 MY_NUM 추가</h1>
		<h1> <a href="home2_sessionGet.jsp">SESSION GET</a></h1>
</body>
</html>