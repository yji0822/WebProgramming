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
	
	<h1> GET방식 </h1>
	<form action="${conPath }/student.do" method="get">
		ID <input type="text" name="id">
		<input type="submit" value="GET방식으로 전송하기">
	</form>	
	
	<h1> POST방식 </h1>
	<form action="${conPath }/student.do" method="post">
		ID <input type="text" name="id">
		<input type="submit" value="POST방식으로 전송하기">
	</form>	
	
	<hr>
	<h1>redirect, forward 키워드 예제</h1>
	<form action="${conPath }/idConfirm.do" method="get">
		Id <input type="text" name="id">
		<input type="submit" value="idConfirm">
	</form>
	<!-- id1 가 들어오면 ~로 가는 것 id2가 들어오면 ..로 가도록 하는 로직 -->
	
	<hr>
	<a href="${conPath }/fullPath.do">fullPath로 가기</a>


</body>
</html>