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
	
	<!--  insert를 누르면 한 곳으로 가라! 로직 구현 
		없으면 404 에러-->
	<h1><a href="${conPath }/insert.do">INSERT</a></h1>
	<h1><a href="../select.do">SELECT</a></h1>
	<h1><a href="/ch18/delete.do">delete</a></h1>
	<h1><a href="http://localhost:8090/ch18/update.do">update</a></h1>
	<!-- 다 똑같은 경로를 나타낸 것
	.do 다 서블릿으로 갈 것이다. 원글쓰기 같은 경우는  서블릿으로 안가도 되지 않나? 라고 생각할 수 있지만 
	일단 서블릿으로 간 후에 다시 jsp로 가게 된다.	 -->
	<!-- 여태까지 했던게 디렉토리 구조. 우리는 확장자 구조의 서블릿으로 변경해서 사용할 것. -->
</body>
</html>