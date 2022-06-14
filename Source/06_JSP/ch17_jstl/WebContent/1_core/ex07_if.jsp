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

	<c:if test="${1+2 eq 3 }">
		1+2는 3입니다.<br>
	</c:if>
	
	<c:if test="${1+2 !=3 }" var="result" scope="page">
		1+2는 3이 아닙니다.<br>
	</c:if>
	두번째 if 조건문에 대한 결과는 ${result }입니다.
	
	<br>
	<br>
	<%
		if(1+2==3) {
			out.println("(스크립트릿) 1+2는 3입니다.");
		} else {
			out.println("1+2는 3이 아닙니다."); // dead code
		}
	%>

</body>
</html>