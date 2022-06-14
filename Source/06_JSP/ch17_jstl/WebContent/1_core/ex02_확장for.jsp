<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<%
		String[] names = {"홍길동", "김길동", "신길동"};
		
	/* for(String name: names) {
			out.println("<p>" +name + "</p>");
		}
		
		for(int i=0; i<names.length; i++) {
			out.println("<p>" + i +"번째 이름 : " + names[i] +"</p>");
		} */
	%>
	
	<c:set var="names" value="<%=names %>"/> <!-- names라는 이름의 변수 선언 -->
	
	<c:forEach var="name" items="${names }">
		<h3>${name }</h3>
	</c:forEach>
	
	<h1>랙</h1>
	<c:set var="idx" value="0"/> <!-- idx변수 선언 -->
	<c:forEach var="name" items="${names }">
		<h4>${idx }번째 이름은 ${name }</h4>
		<c:set var="idx" value="${idx + 1 }"/>
	</c:forEach>
	
	<p>최종 idx값은 ${idx }</p>
	
</body>
</html>