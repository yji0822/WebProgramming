<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %>
<!-- 무조건 getContextPath() 가 들어가야 하는 이유 :  -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 서블릿 호출 
		표현식에는 무조건 세미콜론(;)을 쓰면 안된다.-->
	<h2>context path : <%=conPath %></h2>
	<hr>
	<a href="<%=conPath%>/Ex3">Ex3서블릿</a>
	<!-- <a href="../Ex3">Ex3서블릿</a>	<a href="/ch05_jsp/Ex3">Ex3서블릿</a> -->
	<button onclick="location.href='<%=conPath %>/Ex3'">Ex3서블릿</button>
</body>
</html>