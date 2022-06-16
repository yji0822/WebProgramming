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

	<!-- webcontent 밑에 있는 index.jsp -->	
	<h2><a href="${conPath }/memberList.do">회원리스트</a></h2>
	
	<!-- 화면에 form태그 밑에 뿌려주는 역할만 하는 것 -->
	<h2><a href="${conPath }/memberJoin_view.do">회원가입 </a></h2>
	
	<!-- memberJoin.do form태그 안에서 사용할 친구 -->

</body>
</html>