<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link href="${conPath }/css/style.css" rel="stylesheet">	
</head>
<body>

	<h1> ${greeting } </h1>

	<P>  The time on the server is ${serverTime}. </P>
	<P>  오늘은 2022년 7월 14일 입니다. </P>
	
	<!-- css 도 jpg도 굳이 conPath를 안써도 무방하지만 써주도록 한다. -->
	<p> <img src="${conPath }/img/100.jpg" alt="test"> </p>
	<p> <img src="img/100.jpg" alt="test"> </p>
	

</body>
</html>
