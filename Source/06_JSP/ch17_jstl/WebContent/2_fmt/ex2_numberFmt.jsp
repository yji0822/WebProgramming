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

	<!-- 숫자의 3자리마다 , 을 찍어주거나 소수점을 붙여주는 법 -->
	<c:set var="num" value="1234567.8"/> <!-- 변수선언 -->
	<p>num : ${num }</p>
	<p>세자리 마다 , : <fmt:formatNumber value="${num }" groupingUsed="true"/></p>
	<p>세자리 마다 , : <fmt:formatNumber value="${num }" pattern="#,###.#"/></p>
	
	<p>소수점 2자리(소수점 한자리의 경우 뒤에 0) :
	<!-- 자리에 상관없이 보여지는 패턴대로 출력하게 하는 것 -->
	<fmt:formatNumber value="${num }" pattern="#,###.00"/>
	</p>

	<!-- 변수 재선언 가능 -->	
	<c:set var="num" value="3.149"/>
	<p>num : ${num }</p>
	<p>
		소수점 2자리 (소수점 한자리의 경우 한자리만 출력) :
		<fmt:formatNumber value="${num }" pattern="#,###.##"/>
	</p>
	
</body>
</html>