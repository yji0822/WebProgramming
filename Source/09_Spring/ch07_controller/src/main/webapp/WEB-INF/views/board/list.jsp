<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="conPath/css/style.css" rel="stylesheet">
</head>
<body>
	
	<h2>board의 list.jsp 페이지 입니다.</h2>
	
	<c:if test="${list.size() eq 0 }">
		<h3>입력된 member가 존재하지 않습니다.</h3>
	</c:if>
	<c:if test="${list.size() != 0 }">
		<c:forEach var="member" items="${list }">
			<h3>id : ${member.id }</h3>
			<h3>pw : ${member.pw }</h3>
		</c:forEach>
		<h3>이상 ${list.size() } 명 입니다.</h3>
	</c:if>
	
	<!--  / 요청 경로가 메인페이지이기 때문에 이렇게 적어주면 된다 -->
	<h2 onclick="location.href='${conPath}/'">메인 페이지로 가기</h2>
	
</body>
</html>