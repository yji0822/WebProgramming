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

	<h2>변수 선언과 출력</h2>
	<!-- 한페이지에서만 유효한 변수 -->	
	<c:set var="varName" value="varValue"/> <!-- 변수선언 -->
	varName : ${varName } <br>
	<c:set var="varName" value="abc <varValue>"/>
	varName : ${varName } <br>
	
	<!-- 변수 출력 : escapeXml = "true" : 특수문자 인식 (default) -->
	varName : <c:out value="${varName }" escapeXml="true"/><br>
	<!-- customer 객체를 request.setAttribute 해서 받아와서 사용할 예정 
	/ 객체만 받아올 수 있다. value=12는 안됨 대신 value=에 EL을 넣어서 이런식으로 넣어서 사용할 수 있도록-->
	
	<c:remove var="varName"/> <!-- 변수 삭제 -->
	varName : ${varName } <br>
	varName : ${empty varName ? "삭제되어서 없음" : "남아있음" } <br>
	varName : <c:out value="${varName }" default="지워진 변수"/>
	
	
</body>
</html>