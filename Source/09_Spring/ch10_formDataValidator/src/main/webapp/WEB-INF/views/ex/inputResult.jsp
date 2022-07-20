<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

	<!-- 검증이 완료된 페이지 id랑 name이 정상적으로 들어오는 것
	: addAttribute해서 괜찮다. -->
	
	<h1>검증이 완료된 페이지 입니다.</h1>
		
	<h4>이름 ${student.name }</h4>
	<h4>Id ${student.id }</h4>
	
	<button onclick="history.back()">이전</button>
	<button onclick="location.href='${conPath}/inputForm.do'">다시</button>
	
</body>
</html>