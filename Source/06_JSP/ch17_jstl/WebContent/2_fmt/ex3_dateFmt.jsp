<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
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

	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowDateUtil" value="<%=new java.util.Date() %>"/>

	${nowDate } <br> <!-- 2022-06-15 -->
	${nowTimes } <br> <!-- 2022-06-15 10:12:49.256 -->
	${nowDateUtil } <br> <!-- Wed Jun 15 10:12:49 KST 2022 -->
	
	<!-- Date 형식 사용 : type을 Date를 하면 date만 출력이 된다. type="time" type="both" (날짜+시간)-->
	<hr>
	<h3>날짜만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/> /
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/> /
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/> /
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/>
	<!-- 22. 6. 15 / 2022. 6. 15 / 2022년 6월 15일 (수) / 2022년 6월 15일 수요일 -->
	
	<hr>
	<h3>시간만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/> /
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/> /
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/> /
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/>
	
	<hr>
	<h3>날짜와 시간 모두 출력</h3>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/>
	
	<hr>
	<h3>나만의 패턴 출력</h3>
	<!-- 나만의 패턴을 만들 수 있다. -->
	<fmt:formatDate value="${nowDate }" pattern="yyyy년MM월dd일(E요일) hh:mm:ss:SS(a)"/> / 
	<fmt:formatDate value="${nowDate }" pattern="yyyy년MM월dd일(E) HH:mm:ss"/>
	<!--yyyy:연도, MM:월 E:요일 / hh:12시 HH:24시 dd:일 ss:초 SS:밀리세컨 / a : 오전, 오후 -->
	
</body>
</html>