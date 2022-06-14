<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

	<h2>예외처리</h2>
	
	<c:catch var="error">
		<h2>테스트</h2>
		<%= 8/0 %>
		<p>예외가 발생되는 즉시 catch절을 빠져나감. 이 p태그 출력 시 예외가 발생이 안됨</p>
	</c:catch>
	예외타입과 예외메세지 : <c:out value="${error }" default="예외 발생 안됨"/>
	
</body>
</html>