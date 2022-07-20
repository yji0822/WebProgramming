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
	<h2>studentOk.jsp 페이지</h2>
	<h2>forward 전송 방식</h2>
	<h3>confirm된 id : ${id } (model의 id O)</h3>	
	<h3>confirm된 id : ${param.id } (파라미터의 id O)</h3>	
</body>
</html>